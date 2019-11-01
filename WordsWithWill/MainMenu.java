import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

public class MainMenu extends JPanel implements MouseListener, MouseMotionListener {

    private TextBox textBox;
    private static final int BUTTON_HEIGHT = 50;
    private static final int BUTTON_Y = 300;
    private static final int PAD = 5;
    private int width;
    private int height;
    private RoundRectangle2D button;
    private boolean hover;
    private Frame frame;

    private static final Font BUTTON_FONT = new Font("HelveticaNeue", Font.BOLD, 32);
    private static final String BUTTON_TEXT = "Find Opponent";

    private static final Color PANEL_BACKGROUND = new Color(67,122,199);
    private static final Color BUTTON_BACKGROUND = new Color(240,211,89);
    private static final Color BUTTON_FOREGROUND = new Color(203,119,53);

    public MainMenu(Frame frame, int width, int height){

        this.height = height;
        this.width = width;
        this.frame = frame;
        hover = false;
        textBox = new TextBox(width, height);
        SpringLayout layout = new SpringLayout();
        setLayout(layout);
        layout.putConstraint(SpringLayout.WEST, textBox, 5, SpringLayout.WEST, frame.getContentPane());
        layout.putConstraint(SpringLayout.NORTH, textBox, 50, SpringLayout.NORTH, frame.getContentPane());
        add(textBox);
        addMouseListener(this);
        addMouseMotionListener(this);
        button = new RoundRectangle2D.Double(PAD,BUTTON_Y,width-PAD*2,BUTTON_HEIGHT,50,50);
    }

    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        this.setBackground(PANEL_BACKGROUND);

        drawButton(g2);
        drawButtonText(g2);

    }

    private void drawButton(Graphics2D g2){

        if(!hover){
            g2.setColor(BUTTON_BACKGROUND);
        }else{
            g2.setColor(BUTTON_FOREGROUND);
        }
        g2.fill(button);
    }


    private void drawButtonText(Graphics2D g2){
        if(!hover){
            g2.setColor(BUTTON_FOREGROUND);
        }else{
            g2.setColor(BUTTON_BACKGROUND);
        }
        g2.setFont(BUTTON_FONT);
        FontMetrics fm = g2.getFontMetrics();
        Rectangle2D rect = fm.getStringBounds(BUTTON_TEXT, g2);

        float x = PAD + (width-(PAD*2))/2 - fm.stringWidth(BUTTON_TEXT)/2;
        float y = BUTTON_Y + (BUTTON_HEIGHT - fm.getHeight())/2 + fm.getAscent();

        g2.drawString(BUTTON_TEXT, x, y);
    }

    public boolean checkUsername(String input){
        boolean valid = false;
        if(!input.equals("") && !input.equals("Enter Your Username")){
            valid = true;

        }else{
            //Draw a pop-up screen
        }
        return valid;
    }

    public void update(int width, int height){
        this.width = width;
        this.height = height;
        textBox.update(width);
        button.setRoundRect((double)PAD,(double)BUTTON_Y,(double)width-PAD*2,(double)BUTTON_HEIGHT, 50.0, 50.0);

    }

    public int getWidth(){return width;}
    public int getHeight(){return height;}
    public void mousePressed(MouseEvent e) {
        if(hover) {
            switchPanel();
        }
    }

    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseDragged(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {

        if(button.contains(e.getX(), e.getY())){
            hover = true;
            repaint();
        }
        else{
            hover = false;
            repaint();
        }
    }

    private void switchPanel(){

        frame.drawBoard();
        //If player 1 exists, create a player 2 and start the game
        //Else, wait for second player to join
    }
}
