import javax.swing.JPanel;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.HashMap;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Graphics;

/**
 * This class is responsible for drawing all card images onto a JPanel which is then 
 * added to a JFrame in the Frame class (@see Frame.java). In addition, Panel 
 * utilizes the MouseListener and MouseMotionListener class, to define how the location
 * that cards are drawn at should change when they are clicked, dragged or released.
 */
public class Panel extends JPanel implements MouseListener, MouseMotionListener{


    /* Responsible for holding all the PileCollections and the locations they should be drawn at*/
    private Board board;

    /* Represents a pile of cards that are moving from one pile to another, could contain a single card */
    private BuildPile movingCards = new BuildPile(); 
    
    /* An enumeration of the 3 different Pile types we see on the Board. */
    private enum Piles{
        buildPile,
        drawPile,
        acePile
    }
    /* A HashMap mapping Piles to Integers, where the integer represents 
        the index of a Pile within a PileCollection that has been clicked on */
    private HashMap<Piles,Integer> pileIndexes = new HashMap<>();
    
    /* Represents the index of Pile clicked on, when there are multiple 
       cascading cards in a BuildPile, and only a certain portion wish to be relocated */
    private int subPileIndex = -1;
    
    /* Number of pixels horizontally between each pile*/
    private static final int PILE_Y_BUFFER = 25; 

    /* Keep track of the x and y values that the mouse starts at when they press a pile, before they drag the pile */
    private int startX;
    private int startY;

    private boolean flip = false;      //set to true when the user wants to flip a card over in a BuildPile
    private boolean draw3 = false;     //set to true when the user wishes to pick 3 cards off the top of the draw pile
    private boolean moveCards = false; //set to true when a card is being moved from one pile to another
    
    /**
     * The following constructor method accepts no arguments and does simple things.
     * 
     *    Instantiates an instance of the Board object (@see Board.java) 
     *    Set the PileIndexes to -1 for each PileCollection as no Pile has been selected when the game starts
     *    Passes an instance of itself to the addMouseListener method (@see MouseListener)
     *    Passes an instance of itself to the addMouseMotionListener method (@see MouseMotionListener)
     * 
     * The last two are necessary for the functionality of our desired mouse behavior. 
     */
    public Panel(){
        board = new Board();
        updatePileIndexes(-1, -1, -1);
        
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    /**
     * paintComponent is responsible for painting everything displayed on the JPanel.
     * It is an overridden method that originates from the JPanel class.
     * Gets called every time repaint() is called.
     * 
     * @param g - a Graphics object which gets casted to a Graphics2D object.
     *            Graphics2D contains methods necessary for drawing images on the JPanel.  
     */
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        
        setBackground(Color.white);
        board.drawSlots(g2); //Draw the slots where the cards rest. This is a decoration. 

        //Draw all the cards in their respective locations. 
        board.getBuildPiles().drawCards(g2);
        board.getDrawPile().drawCards(g2);
        board.getAcePiles().drawCards(g2);

        //Draws the moving pile of cards in cases when the movingCards BuildPile will contain cards
        if(subPileIndex > -1 || pileIndexes.get(Piles.drawPile) == 1 || pileIndexes.get(Piles.acePile) > - 1){
            movingCards.drawCards(g2);
        }
    }

    /**
     * A private helper method that loops through each Piles key in the pileIndexes Map
     * and checks to see if any values are greater than -1 (ie selected).
     * The method then returns the corresponding Pile associated with the Piles key found.
     * 
     * @return Pile - the Pile clicked on by the user
     */
    private Pile getPileSelected(){
        for(Piles p: pileIndexes.keySet()){
            int i = pileIndexes.get(p);
            if(i > -1){
                if(p.equals(Piles.buildPile)){
                    return board.getBuildPiles().getPile(i);
                }else if(p.equals(Piles.acePile)){
                    return board.getAcePiles().getPile(i);
                }else{
                    return board.getDrawPile().getPile(i);
                }
            }
        }
        return null; //We should never end up here.
    }

    /**
     * A method to update the pileIndexes HashMap. Gets called each time the mouse is clicked.
     * Updates the correct key in pileIndexes with the value of the index clicked on in a Pile by the user.
     * If the user didn't click on a certain PileCollection, the value at that key is set to -1.
     * We should only ever have one value in the map greater than -1 at a certain time.
     * @param buildPileSelected
     * @param drawPileSelected
     * @param acePileSelected
     * 
     * @return void
     */
    private void updatePileIndexes(int buildPileSelected, int drawPileSelected, int acePileSelected){
        pileIndexes.put(Piles.buildPile, buildPileSelected);
        pileIndexes.put(Piles.drawPile, drawPileSelected);
        pileIndexes.put(Piles.acePile, acePileSelected);
    }

    /**
     * Overridden mousePressed method. Fired every time the mouse is pressed.
     * 
     * @param MouseEvent e
     * 
     * @return void
     */
    public void mousePressed(MouseEvent e) {

        /* Check each PileCollection on the board to see if they have been clicked
            if they haven't been clicked, these values will all be -1 */
        int buildPileSelected = board.getBuildPiles().clicked(e.getX(), e.getY());
        int drawPileSelected = board.getDrawPile().clicked(e.getX(), e.getY());
        int acePileSelected = board.getAcePiles().clicked(e.getX(), e.getY());

        /* Put all the updated indexes in the PileIndexes HashMap */
        updatePileIndexes(buildPileSelected, drawPileSelected, acePileSelected);

        /* Check to see what type of PileCollection (if any was selected) */
        if(buildPileSelected > -1){
            if(board.getBuildPiles().getPile(buildPileSelected).getNumFaceUpCards() > 0){ //at least one face up card
                /* subPileIndex tells us where within a cascading Pile, the user clicked */
                subPileIndex = board.getBuildPiles().getPile(buildPileSelected).getSubPileIndex(e.getY(), board.getBuildPiles().getStartY());
                /* based on where the user clicked within the pile, we can move the selected cards into a new BuildPile called movingCards*/
                movingCards = board.getBuildPiles().getPile(buildPileSelected).getSubPile(subPileIndex);
                /* log the starting location of the mouse when the pile is pressed */
                startX = e.getX() - movingCards.getXCord();
                startY = e.getY() - movingCards.getYCord(); 
                moveCards = true;
            }else if(board.getBuildPiles().getPile(buildPileSelected).getNumCards() > 0){ //at least one face down card
                flip = true;
            }
            /* two cases for when a drawPileCollection is clicked, either deal 3 cards off the top,
               or move the top card into movingCard and prepare to move it onto another Pile  */
        }else if(drawPileSelected > -1){
            if(drawPileSelected == 0){
                draw3 = true;
            }else{
                subPileIndex = 0;
                movingCards.addCard(board.getDrawPile().getPile(1).popTopCard()); 
                startX = e.getX() - board.getDrawPile().getPile(1).xCord;
                startY = e.getY() - board.getDrawPile().getPile(1).yCord;
                moveCards = true;
            }
            /* when the ace pile is selected, take the top card out of the AcePile,
               and put it in movingCards when there is at least one Card in the pile*/
        }else if(acePileSelected > -1){
            if(board.getAcePiles().getPile(acePileSelected).getNumCards() > 0){
                subPileIndex = 0;
                movingCards.addCard(board.getAcePiles().getPile(acePileSelected).popTopCard());
                startX = e.getX() - board.getAcePiles().getPile(acePileSelected).xCord;
                startY = e.getY() - board.getAcePiles().getPile(acePileSelected).yCord;
                moveCards = true;
            }
        }
        repaint();
    }

    /**
     * Overridden mouseDragged method. Outlines the behavior our Panel should produce when the 
     * mouse is dragged from one point on the screen to another (while clicked).
     * 
     * We utilize a bit of geometry to get the mouse to stay at the correct location on the card
     * while it is being dragged and to allow the cards to remain in their "cascading state" while
     * they are being dragged.
     * 
     * @param MouseEvent e
     * 
     * @return void
     */
    public void mouseDragged(MouseEvent e) {
        
        if(moveCards){

           /* Loop through each card that's selected and change their location to 
            * match where the mouse is. */
            for(int i = 0; i < movingCards.getNumFaceUpCards(); i++){
                movingCards.getCard(i).setXCord(e.getX() - startX);
                movingCards.getCard(i).setYCord((e.getY() - startY) + (i * PILE_Y_BUFFER) + (subPileIndex * PILE_Y_BUFFER));  
            }
        }
        repaint();
    }
    
    /**
     * Overridden mouseReleased method. Dictates the behavior of the Panel, when the mouse is 
     * released from being clicked. In the case when a card is being moved, there are several cases
     * that need to be checked when the Pile is released onto another Pile. Did the user released it
     * on a valid location (Pile), if so, is the move valid, only in this case can we transfer movingPile
     * to another Pile, in all other cases, movingPile must be returned to its original Pile, 
     * pileIndexes is responsible for keeping track of those original Pile locations.
     * 
     * @param MouseEvent e
     * 
     * @return void
     */

    public void mouseReleased(MouseEvent e) {
        if(moveCards){
            /* First get the type of Pile that the user releases on,
            if no valid location has been released upon, these values will be -1 */
            int buildPileReleasedOn = board.getBuildPiles().released(e.getX(), e.getY());
            int acePileReleasedOn = board.getAcePiles().clicked(e.getX(), e.getY());
            
            //Releasing any Pile on top of a BuildPile
            if(buildPileReleasedOn > -1){
                //Check that the combined number of cards is less than or equal to 13
                if(movingCards.getNumFaceUpCards() + board.getBuildPiles().getPile(buildPileReleasedOn).getNumFaceUpCards() <= 13){
                    //Check that the move is valid.
                    if(Rules.validMove(board.getBuildPiles().getPile(buildPileReleasedOn), movingCards)){
                        board.getBuildPiles().getPile(buildPileReleasedOn).append(movingCards);
                    }else{
                        //Otherwise, return movingPile to its original pile.
                        getPileSelected().append(movingCards);
                    }
                }
                //Case when we release a single card onto an acePile
            }else if(acePileReleasedOn > -1 && movingCards.getNumFaceUpCards() == 1){
                //Check that the combined number of cards is less than or equal to 13
                if(board.getAcePiles().getPile(acePileReleasedOn).getNumCards() <= 13){
                    //Check that the move is valid
                    if(Rules.validMove(board.getAcePiles().getPile(acePileReleasedOn), movingCards)){
                        board.getAcePiles().getPile(acePileReleasedOn).append(movingCards);
                    }else{
                        //Otherwise, return movingPile to its original pile.
                        getPileSelected().append(movingCards);
                    }
                }
                //Case where no valid Pile was released on, return cards to original Pile
            }else{ getPileSelected().append(movingCards);}
           
            moveCards = false;

            //flip over the card if the user clicks on a buildPile that only contains facedown cards,
            //and they didn't move the mouse off the pile before they release it
        }else if(flip && board.getBuildPiles().clicked(e.getX(), e.getY()) > -1){
            board.getBuildPiles().getPile(pileIndexes.get(Piles.buildPile)).flip();
            flip = false;
            //draw 3 cards off the top of the drawPile if the user clicks on the pile 
            //and doesn't move the mouse off the pile before they release it
        }else if(draw3 && board.getDrawPile().clicked(e.getX(), e.getY()) == 0){
            board.getDrawPile().draw3();
            draw3 = false;
        }
        movingCards.clear();
        repaint();
        if(board.getAcePiles().checkWin()){
            System.out.println("YOU WIN!");
        } 
    }
    
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseMoved(MouseEvent e){}   
}