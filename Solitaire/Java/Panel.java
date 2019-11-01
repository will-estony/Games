import javax.swing.JPanel;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Graphics;

public class Panel extends JPanel implements MouseListener, MouseMotionListener{

    private int DEST_X = 50;
    private int DEST_Y = 50;
    private static final int CARD_WIDTH = 73;
    private static final int CARD_HEIGHT = 98;
    private int xMouse = 0;
    private int yMouse = 0;
    private boolean pressed;
    private Deck d;
    private Pile p;
    private Card mouseCard;
    private Board board;

    public Panel(){
        board = new Board();
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    protected void paintComponent(Graphics g) {
        setBackground(Color.white);
        Graphics2D g2 = (Graphics2D) g;
        board.drawBoard(g2);
    }
    public void mousePressed(MouseEvent e) {
        if(e.getX() > 50 && e.getX() < 50 + CARD_WIDTH && e.getY() > 50 && e.getY() < 50 + CARD_HEIGHT){
            pressed = true;
            //mouseCard = d.getTopCard();
        }
    }
    public void mouseReleased(MouseEvent e) {
        pressed = false;
        mouseCard = null;
    }
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {
        int pile = pc.clicked(e.getX(), e.getY());
        if(pile == 0){
            System.out.println("No pile clicked");
        }else{
            System.out.println("Pile " + pile + " clicked");
        }
    }
    public void mouseDragged(MouseEvent e) {
        if(pressed){
            mouseCard.setXCord(e.getX() - CARD_WIDTH/2); 
            mouseCard.setYCord(e.getY() - CARD_HEIGHT/2);
            repaint();
        }
    }
    public void mouseMoved(MouseEvent e) {
    }
}