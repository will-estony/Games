import javax.swing.JFrame;
/**
 * This class sets a few basic features of the frame which
 * the panel that contains our game will rest on. It only contains 
 * on constructor method. 
 * In addition, this class instantiates a Panel object.
 * 
 * @see Panel
 * @see JFrame
 */
public class Frame extends JFrame{
    /**
     * Constructs a new Frame object. Takes no parameters.
     * Sets the following JFrame features: the default close operation, size, visibility.
     * Adds a panel object to the JFrame.
     */
    public Frame(){
        Panel panel = new Panel();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1250,1000);
        add(panel);
        setVisible(true);
    }
}