/**
 *
 * The following class models a Board Object which is essentially a JFrame wrapped in a different name.
 * We do this so we don't have to define some of the basic attributes of our frame in the Main method.
 * The class contains only one constructor method. The class is a child of the JFrame class.
 *
 * January 19, 2019
 * @author William Estony
 * @version 1.0
 *
 */

import javax.swing.*;
import java.awt.*;

public class Board extends JFrame{

    /**
     * The following method constructs an instance of a JFrame with size and title defined by the
     * user as parameters
     *
     * The one component of the frame that isn't up to the user is the Default Close Operation which
     * is to exit on close (the frame will close when the user presses the x)
     *
     * @param width - an int representing the width of the frame that will contain our game
     * @param height - an int representing the height of the frame that will contain our game
     * @param title - a String that will be displayed on the top of the frame
     *
     *
     *
     */
    public Board(int width, int height, String title){

        setSize(new Dimension(width,height));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(title);

    }

}
