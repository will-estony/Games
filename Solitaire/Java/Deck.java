import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.awt.Graphics2D;

public class Deck{
    private static final String[] SUITS = {"Clubs","Spades","Hearts","Diamonds"};
    private static final int[] VALUES = {1,2,3,4,5,6,7,8,9,10,11,12,13};
    private static Card[] deck = new Card[52];
    private static final int CARD_WIDTH = 73;
    private static final int CARD_HEIGHT = 98;
    private static HashMap<String,Card> map = new HashMap<String,Card>();
    private int size;

    public Deck(){
        populateDeck();
        this.size = 52;
    }
    public int size(){ return size;}
    public void populateDeck(){
        int k = 0;
        for(int i = 0; i < SUITS.length; i++){
            for(int j = 0; j < VALUES.length; j++){
                deck[k] = new Card(false, SUITS[i],VALUES[j], 50, 50, loadCardImage("deck.jpg", i, j, CARD_WIDTH, CARD_HEIGHT));
                k++;
            }
        }
    }
    public BufferedImage loadCardImage(String fileName, int i, int j, int cardWidth, int cardHeight){
        try{
            BufferedImage img = ImageIO.read(new File(fileName));
            return img.getSubimage(j * cardWidth, i * cardHeight, cardWidth, cardHeight);

        }catch(IOException e){}
        return null;
    }
    public void printDeck(){
        for(int i = 0; i < SUITS.length; i++){
            for(int j = 0; j < VALUES.length; j++){
                System.out.println(VALUES[j] + " of " + SUITS[i]);
            }
        }
    }
    public void drawDeck(Graphics2D g2){
        for(int i = 0; i < deck.length; i++){
            deck[i].drawCard(g2);
        }
    }
    public Card popTopCard(){
        size--;
        return deck[size];
    }
    public void putTopCard(Card c){
        deck[size] = c;
    }
    public void populateMap(){
        int k = 0;
        for(int i = 0; i < SUITS.length; i++){
            for(int j = 0; j < VALUES.length; j++){
                if(VALUES[j] == 1){
                    map.put("Ace of " + SUITS[i].toString(), deck[k]);
                }
                else if(VALUES[j] == 11){
                    map.put("Jack of " + SUITS[i].toString(), deck[k]);
                }
                else if(VALUES[j] == 12){
                    map.put("Queen of " + SUITS[i].toString(), deck[k]);
                }
                else if(VALUES[j] == 13){
                    map.put("King of " + SUITS[i].toString(), deck[k]);
                }else{
                    map.put(VALUES[j] + " of " + SUITS[i].toString(), deck[k]);
                }
                k++;
            }
        }
    }
    public static Card getCard(String card){
        return map.get(card);
    }
}