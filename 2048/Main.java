/**
 *
 * The following class contains the main method that is responsible for running the entire game.
 *
 * January 19, 2019
 * @author William Estony
 * @version 1.0
 *
 */

import javax.swing.*;

public class Main {

    /**
     * The frame where our game panel and menu panel will sit.
     */
    private static Board frame;

    /**
     * The two panels that could at any point get added to the frame
     *
     * Note, we define and initialize the GamePanel even though it is not directly being drawn until
     * the user presses a button. We do this so that we can control the start method from the main method.
     * The start method tells the program to do a certain task every second (keep track of game-time) and
     * will not be started until the user presses the New Game button.
     */
    private static GamePanel game;
    private static MenuPanel menu;

    /**
     * The following three instance variables describe the dimensions of title of the Frame where our game will
     * be played.
     */
    private final static int FRAME_WIDTH = 500;
    private final static int FRAME_HEIGHT = 650;
    private final static String GAME_TITLE = "2048";


    public static void main(String[] args) {


        frame = new Board(FRAME_WIDTH, FRAME_HEIGHT, GAME_TITLE);

        menu = new MenuPanel();
        game = new GamePanel();

        //the following call will fire a task every second once the program is started
        game.start();

        //add the menu panel to the frame and set the frame to be visible
        //the first thing the user will see, thus is the main menu.
        frame.getContentPane().add(menu);
        frame.setVisible(true);


    }

    /**
     *
     * @return the main frame
     */
    public static JFrame getFrame(){
        return frame;
    }

    /**
     *
     * @return the game panel
     */
    public static GamePanel getGamePanel(){
        return game;
    }

    /**
     *
     * @return the menu panel
     */
    public static MenuPanel getMenuPanel(){
        return menu;
   }


}
