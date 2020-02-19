import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Deck extends Thread{

    /*The suits in our deck of cards. Order matters because this is the way
    the suits are ordered in the template image that we cut our cards from */
    private static final String[] SUITS = {"Clubs","Spades","Hearts","Diamonds"};

    /*The values of cards in our deck. Ace is of value 1, King is of value 13 */
    private static final int[] VALUES = {1,2,3,4,5,6,7,8,9,10,11,12,13};

    /*The crux of our deck object, an array of Cards of size 52 
    gets populated in the populateDeck method. */
    private static Card[] deck = new Card[52];

    private static final int CARD_WIDTH = 73;
    private static final int CARD_HEIGHT = 98;
    
    /*The number of cards in the deck at a given time. Will be decremented as 
    we deal cards from the universal, static deck to various piles */
    private static int numCards = 52;

    /*The following variables are used to multi-thread */
    private int lo, hi, k;

    /*The file of the image containing the cards represented as a String. */
    private static final String cardImage = "deck.jpg";

    /*We define 2 threads, that will import 26 cards each to split the workload in half */
    private static final int NUM_THREADS = 2;


    /**
     * One of two constructors. The following constructor is used for multi-threading.
     * Called in the method populateDeck.
     * 
     * @param lo - the lower index when looping through four suits. Will take values 0 and 2
     * @param hi - the higher index when looping through four suits. Will take values 2 and 4.
     * @param k - the index in the deck that a new Card is being added to
     */
    public Deck(int lo, int hi, int k){
        this.lo = lo;
        this.hi = hi;
        this.k = k;
    }

    /**
     * Default constructor, takes no arguments.
     * Used in PileCollection (@see PileCollection.java)
     */
    public Deck(){}

    /**
     * The following method utilizes two threads to populate the array of Cards.
     * This was by far the most expensive method in the game so we split the work in half
     * by having one thread read in the first 26 cards, and another thread read in the final 26
     * 
     * Because we extend thread, the actual reading in of the cards now takes place in the run 
     * method. This method merely creates the two threads and starts them.
     * 
     * @return void
     * @throws InterruptedException
     */
    public static void populateDeck() throws InterruptedException{

        //Declare an array of threads of size 2.
        Deck[] myThreads = new Deck[NUM_THREADS];

        //Initialize the threads and start them concurrently. 
        //Since they are enacting on different parts of the array we should be safe.
        for(int i = 0; i < NUM_THREADS; i++){
            myThreads[i] = new Deck(NUM_THREADS * i, NUM_THREADS * (i+1), i * (numCards/2));
            myThreads[i].start();
        }

        //Join the threads when it is safe to do so.
        for(int i = 0; i < NUM_THREADS; i++){
            myThreads[i].join();
        }

        shuffle(); //Shuffle the deck
    }

    /**
     * Overridden run method from the Thread class. Loops over half the number of cards in the deck,
     * creates the necessary cards and places them in the appropriate part of the deck[] array.
     */
    public void run(){
        for(int y = lo; y < hi; y++){
            for(int x = 0; x < VALUES.length; x++){
                deck[k] = new Card(false, SUITS[y],VALUES[x], 0, 0, loadCardImage(cardImage, x, y, CARD_WIDTH, CARD_HEIGHT));
                k++;
            }
        }
    }

    /**
     * The following method attempts to return a BufferedImage, which in our case, is a subImage from
     * within a larger card template image. The BufferedImage returned will then be passed to a Card object.
     * 
     * @param fileName - the name of the file containing the image we are trying to return a portion of
     * @param x - the X coordinate of the upper-leftmost corner of the subImage we are returning
     * @param y - the Y coordinate of the upper-leftmost corner of the subImage we are returning
     * @param cardWidth - the width of the subImage we are returning
     * @param cardHeight - the height of the subImage we are returning
     * 
     * @return BufferedImage - the image of a playing card  
     * 
     **/
    public static BufferedImage loadCardImage(String fileName, int x, int y, int cardWidth, int cardHeight){
        try{
            //Read in the file containing the image of all the card faces.
            BufferedImage img = ImageIO.read(Deck.class.getResource(fileName));
            //Capture the portion of the template that represents the card we want to instantiate.
            return img.getSubimage(x * cardWidth, y * cardHeight, cardWidth, cardHeight);

        }catch(IOException e){}
        return null;
    }
    /**
     * Decrements numCards by 1.
     * @return the top card on the deck
     */
    public Card popTopCard(){ return deck[--numCards]; }

    /**
     * @return the number of cards in the Deck
     */
    public int size(){ return numCards;}

    /**
     * The following method shuffles all the cards in the deck, by swapping an arbitrarily large
     * number of pairs in the deck at random locations. In our case we do this one-hundred thousand
     * times.
     * 
     * @return void
     */
    private static void shuffle(){
        Random random = new Random();
        int a,b;
        Card temp;
        
        for (int i = 0; i < 100000; i++){
            
            //Get two random numbers in the range 0 to 51.
			a = random.nextInt(52);
            b = random.nextInt(52);

            //Swap two random cards in the deck.
			temp = deck[a];
			deck[a] = deck[b];
			deck[b] = temp;
        }
    }
}