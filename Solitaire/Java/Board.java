import java.awt.Graphics2D;

/**
 * This class holds all the items that are drawn on the Panel which rests on the Frame.
 * Such items include the three distinct PileCollections which hold a set number of Piles. 
 * These Piles hold an arbitrary number of Cards. 
 * 
 * We refer to the four Piles on the top of the Board as an "AcePileCollection"
 * The seven Piles in the middle of the Board as a "BuildPileCollection"
 * Finally, we refer to the two Piles on the bottom-most portion of the Board as a "DrawPileCollection"
 * 
 * All three of these objects extend PileCollection. 
 * 
 * Currently we draw the Piles at fixed, hard coded locations based on the Card Height, 
 * we hope to change this in the future.
 */

public class Board{

    //Declare our three distinct BuildPiles
    private BuildPileCollection buildPiles;
    private AcePileCollection acePiles;
    private DrawPileCollection drawPiles;

    //Height of a playing card in Pixels
    private static final int CARD_HEIGHT = 98;
    
    /**
     * Constructor which takes no arguments.
     * Initializes all three BuildPiles to locations relative to the height of the card
     * and the height and width of the Frame which are hard coded.
     * 
     * Deals cards into the BuildPiles. Then deals the remaining cards into the DrawPiles
     */
    public Board(){
        
        try{
            Deck.populateDeck();
        }catch(InterruptedException e){

        }
        buildPiles = new BuildPileCollection(625 - 896/2, 400 - CARD_HEIGHT*2);
        acePiles = new AcePileCollection((625 - 896/2) + 220, 50);
        drawPiles = new DrawPileCollection((625 - 896/2) + 343, 650);
        buildPiles.deal();
        drawPiles.deal();
        
    }

    /**
     * Method calls the DrawBorders method for each PileCollection. 
     * These individual methods draw a black rectangle in the location on the Panel
     * where the Piles rest.
     * 
     * @param g2
     * 
     * @return void
     */
    public void drawSlots(Graphics2D g2){
        buildPiles.drawBorders(g2);
        acePiles.drawBorders(g2);
        drawPiles.drawBorders(g2);
    }

    /** 
     * Getter for buildPiles. Utilized in the Panel class. @see Panel.java
     * @return buildPiles
     */
    public BuildPileCollection getBuildPiles(){ return buildPiles; }
     /** 
     * Getter for drawPiles. Utilized in the Panel class. @see Panel.java
     * @return drawPiles
     */
    public DrawPileCollection getDrawPile(){ return drawPiles; }
     /** 
     * Getter for acePiles. Utilized in the Panel class. @see Panel.java
     * @return acePiles
     */
    public AcePileCollection getAcePiles(){ return acePiles; }
}