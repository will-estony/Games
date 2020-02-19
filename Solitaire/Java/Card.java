import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * The following class models a playing card object. It contains necessary instance elements like suit, color and value.
 * It also contains methods to get and set the value of the location where the card will be drawn on the screen.
 * This object also holds the image of the backing of the card. The face images of the card are loaded
 * in the Deck class (@see Deck.java). 
 */
public class Card{
    
    /*The following variables describe the specific Card objects suit and value */
    private String suit;
    private int val; //Ace is 1, Jack is 11, Queen is 12, King is 13.


    private BufferedImage face; //An Image of the face of the card
    private static BufferedImage back; //The backing of the card, there only exists one.
    private int xCord, yCord; //The x and y coordinate of the top left corner of the card where it will be drawn
    
    private boolean faceUp; //True when the card is facing upward, false when it is facedown.
    
    /*The filename for the image of the backing of the card */
    private static final String backImage = "cardBacking.jpg";
    
    private static final int CARD_WIDTH = 73;
    private static final int CARD_HEIGHT = 98;
    

    /**
     * Constructor for the Card object. 
     * 
     * @param faceUp - boolean tells us whether the card should be drawn faceup or facedown.
     * @param suit - the suit of the Card represented as a String.
     * @param val - the value of the Card represented as an int.
     * @param xCord - the X coordinate of the upper left coordinate of where the Card is drawn on the Panel
     * @param yCord - the Y coordinate of the upper left coordinate of where the Card is drawn on the Panel
     * @param face - the image of the face of the Card 
     */
    public Card(boolean faceUp, String suit, int val, int xCord, int yCord, BufferedImage face){
        this.faceUp = faceUp;
        this.suit = suit;
        this.val = val;
        this.face = face;
        this.xCord = xCord;
        this.yCord = yCord;
        Card.back = loadBackImage();
    }

    /**
     * The following method uses the Graphics2D class to draw the Card on the Panel.
     * It is called by one of the classes that extends Pile.java (BuildPile, AcePile or DrawPile).
     * Draws the appropriate image based on whether the card is faceup or facedown.
     */
    public void drawCard(Graphics2D g2){
        if(faceUp){
            g2.drawImage(this.face,this.xCord,this.yCord, CARD_WIDTH, CARD_HEIGHT,null);
        }else{
            g2.drawImage(Card.back,this.xCord,this.yCord, CARD_WIDTH, CARD_HEIGHT,null);
        }
    }

    /**
     * This method is only called once. Returns an image of the backing of the card.
     * 
     * @return BufferedImage of the back of the card.
     */
    private BufferedImage loadBackImage(){
        try{
            return ImageIO.read(getClass().getResource(backImage));
        }catch(IOException e){}
        return null;
    }

    /**
     * This method switches the faceUp boolean to the opposite of what it is.
     * Effectively flipping the card.
     */
    public void flip(){ 
        if(!faceUp){
            faceUp = true; 
        }else{
            faceUp = false;
        }
    }

    /**
     * Sets the y coordinate of the Card.
     * @param y - the Y coordinate of the top left corner of where the Card is drawn.
     */
    public void setYCord(int y){ yCord = y; }
     /**
     * Sets the x coordinate of the Card.
     * @param x - the X coordinate of the top left corner of where the Card is drawn.
     */
    public void setXCord(int x){ xCord = x; }

    /**
     * Gets the value of the card
     * @return val - the value of the Card represented as ant int.
     */
    public int getVal(){ return val;}
    /**
     * Gets the suit of the card
     * @return suit - the suit of the Card represented as a String.
     */
    public String getSuit(){ return suit; }
    /**
     * Gets whether or not the card is face up or not.
     * @return faceUp - a boolean that is true is the card is faceUp, false otherwise.
     */
    public boolean getFaceUp(){ return faceUp; }
    /**
     * Gets the xCord of the Card.
     * @return xCord - the X coordinate of the top left corner of where the Card is drawn.
     */
    public int getXCord(){ return xCord; }
    /**
     * Gets the yCord of the Card.
     * @return yCord - the Y coordinate of the top left corner of where the Card is drawn.
     */
    public int getYCord(){ return yCord; }

    /**
     * Using the suit of the Card to determine its color, 
     * this method returns the color of the Card.
     * 
     * @return - a String "black" if the card is black, "red" otherwise
     */
    public String getColor(){
        if(this.suit.equals("Clubs") || this.suit.equals("Spades")){
            return "black";
        }else{
            return "red";
        }
    }
}