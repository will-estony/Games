import javax.swing.JPanel;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.time.Year;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Graphics;

public class Panel extends JPanel implements MouseListener, MouseMotionListener{

    private boolean pressed;
    private Board board;
    private int pileSelected;
    private int subPileIndex;
    private Pile subPile;
    private static final int PILE_Y_BUFFER = 25;
    private static final int CARD_WIDTH = 73;
    private static final int CARD_HEIGHT = 98; 
    private int startX;
    private int startY;

    public Panel(){
        board = new Board();
        pileSelected = -1;
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    protected void paintComponent(Graphics g) {
        setBackground(Color.white);
        Graphics2D g2 = (Graphics2D) g;
        board.drawBoard(g2);
        board.getPC().drawCards(g2);

        if(pileSelected > -1){ /* highlight the selected cards in red */
            //board.getPC().getPile(pileSelected).highlight(g2, subPileIndex);
            subPile.drawCards(g2);
        }
        
    }
    public void mousePressed(MouseEvent e) {
        pileSelected = board.getPC().clicked(e.getX(), e.getY());
        if(pileSelected > -1){
            subPileIndex = board.getPC().getPile(pileSelected).getSubPileIndex(e.getY(), board.getPC().getStartY());
            subPile = board.getPC().getPile(pileSelected).getSubPile(subPileIndex);
            startX = e.getX() - subPile.getCard(0).getXCord();
            startY = e.getY() - subPile.getCard(0).getYCord();
            pressed = true;
        }
        repaint();
    }
    public void mouseReleased(MouseEvent e) {
        
        if(pressed){
            /* Get rid of the subPile by appending it to one of the 7 piles in PC */
            int pileReleasedOn = board.getPC().released(e.getX(), e.getY());

            if(pileReleasedOn > -1){
            
                if(subPile.getNumFaceUpCards() + board.getPC().getPile(pileReleasedOn).getNumFaceUpCards() <= 13){
                    board.getPC().getPile(pileReleasedOn).append(subPile);
                    //perform a check here to see if the pile we just took from has no 
                    //more cards left in its faceUp pile, in that case we move the topmost card from
                    //the facedown pile into the faceup pile. 
                    board.getPC().getPile(pileSelected).popFaceDownCard();
                }else{
                    board.getPC().getPile(pileSelected).append(subPile);
                }
            }else{
                board.getPC().getPile(pileSelected).append(subPile);
            }
            repaint();
            pressed = false;
        }
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
        }
    }
    
    public void mouseMoved(MouseEvent e){}
}