import javax.swing.JPanel;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Graphics;

public class Panel extends JPanel implements MouseListener, MouseMotionListener{

    private boolean pressed;
    private Board board;
    private int buildPileSelected;
    private int drawPileSelected;
    private int subPileIndex;
    private BuildPile subPile;
    private static final int PILE_Y_BUFFER = 25;
    private int startX;
    private int startY;
    private boolean flip = false;
    private boolean drawCard = false;
    private boolean playCard = false;

    public Panel(){
        board = new Board();
        buildPileSelected = -1;
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    protected void paintComponent(Graphics g) {
        setBackground(Color.white);
        Graphics2D g2 = (Graphics2D) g;
        board.drawBoard(g2);
        board.getBuildPiles().drawCards(g2);
        board.getDrawPile().drawCards(g2);

        if(buildPileSelected > -1){ /* highlight the selected cards in red */
            //board.getBuildPiles().getPile(pileSelected).highlight(g2, subPileIndex);
            subPile.drawCards(g2);
        }
        
    }
    public void mousePressed(MouseEvent e) {
        buildPileSelected = board.getBuildPiles().clicked(e.getX(), e.getY());
        drawPileSelected = board.getDrawPile().clicked(e.getX(), e.getY());
        System.out.println(drawPileSelected);
        if(buildPileSelected > -1){
            
            if(board.getBuildPiles().getPile(buildPileSelected).getNumFaceUpCards() > 0){ //at least one face up card
                subPileIndex = board.getBuildPiles().getPile(buildPileSelected).getSubPileIndex(e.getY(), board.getBuildPiles().getStartY());
                subPile = board.getBuildPiles().getPile(buildPileSelected).getSubPile(subPileIndex);
                startX = e.getX() - subPile.getXCord();
                startY = e.getY() - subPile.getYCord();
                pressed = true;
            }else if(board.getBuildPiles().getPile(buildPileSelected).getNumCards() > 0){ //at least one face down card
                flip = true;
            }
        }else if(drawPileSelected > -1){
            if(drawPileSelected == 0){
                drawCard = true;
            }else{
                startX = e.getX() - board.getDrawPile().getPile(1).getXCord();
                startY = e.getY() - board.getDrawPile().getPile(1).getYCord();
                playCard = true;
            }
        }
        repaint();
    }
    public void mouseReleased(MouseEvent e) {
        
        int pileReleasedOn = board.getBuildPiles().released(e.getX(), e.getY());
        if(pressed){
            /* Get rid of the subPile by appending it to one of the 7 piles in PC */
            

            if(pileReleasedOn > -1){
            
                if(subPile.getNumFaceUpCards() + board.getBuildPiles().getPile(pileReleasedOn).getNumFaceUpCards() <= 13){
                    board.getBuildPiles().getPile(pileReleasedOn).append(subPile);
                    //perform a check here to see if the pile we just took from has no 
                    //more cards left in its faceUp pile, in that case we move the topmost card from
                    //the facedown pile into the faceup pile. 
                    //board.getBuildPiles().getPile(pileSelected).popFaceDownCard();
                }else{
                    board.getBuildPiles().getPile(buildPileSelected).append(subPile);
                }
            }else{
                board.getBuildPiles().getPile(buildPileSelected).append(subPile);
            }
            
        }else if(flip){
            board.getBuildPiles().getPile(buildPileSelected).popFaceDownCard();
        }else if(drawCard){
            board.getDrawPile().flip();
        }else if(playCard){
            if(board.getBuildPiles().getPile(pileReleasedOn).getNumFaceUpCards() + 1 <= 13){
                board.getBuildPiles().getPile(pileReleasedOn).append(board.getDrawPile().getPile(1).popTopCard());
                board.getDrawPile().getPile(1).removeTopCard();
            }
        }
        repaint();
        drawCard = false;
        pressed = false;
        flip = false;
    }
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseDragged(MouseEvent e) {
        /* Loop through each card that's selected and change their location to 
         * match where the mouse is.
         * */

        if(pressed){
            for(int i = 0; i < subPile.getNumFaceUpCards(); i++){
                subPile.getCard(i).setXCord(e.getX() - startX);
                subPile.getCard(i).setYCord((e.getY() - startY) + (i * PILE_Y_BUFFER));  
            }
            repaint();
        }else if(playCard){
            board.getDrawPile().getPile(1).popTopCard().setXCord(e.getX() - startX);
            board.getDrawPile().getPile(1).popTopCard().setYCord(e.getY() - startY);
            repaint();
        }
    }
    
    public void mouseMoved(MouseEvent e){}
}