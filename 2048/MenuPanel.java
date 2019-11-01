/**
 *
 * The following class models the MenuPanel object, and specifically represents the what will appear on the Frame
 * when the Menu Panel is added to and painted on the frame. The following class extends the JPanel object.
 * The class contains three methods: a constructor, an overridden paintComponent method, and a single getter method.
 *
 * January 19, 2019
 * @author William Estony
 * @version 1.0
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {

    private int num_records = 10; //the maximum number of leader board records we wish to display on the panel
    private final int TILE_LENGTH = 88;
    private final int Y_PAD = 31;
    private final Color background = new Color(225,225,225); //the background color of the panel

    private final int LEADER_BOARD_PAD = 249;
    private final int MENU_BAR_HEIGHT = 50;
    private final int SMALL_TILE_SIDE = 10; //the length of one size of the small "background" tiles

    //Static because we will want to access it without an initialized instance of the class
    private static LeaderboardInfo lbi;

    /**
     * The following method is a constructor for the MenuPanel object and is fairly straightforward.
     * It does the following things:
     *
     *      1) Creates a leader board associated object (we will use this in PaintComponent).
     *      2) Sets the background color to a light gray.
     *      3) Creates 3 Buttons and places them using the Spring Layout.
     *      4) Creates a discrete Action Listener Class to make the NewGame and ResumeGame button do something
     *         when you press them.
     */
    public MenuPanel(){

        //First thing we do is get the leader board loaded up
        lbi = new LeaderboardInfo();

        //set the background color to gray
        setBackground(background);

        //The spring layout allows pinpoint placement of JObjects onto the Panel
        SpringLayout layout = new SpringLayout();
        setLayout(layout);

        //There will be three buttons on the menu pannel, as of 1/10/19 the leader_board button doesn't do anything
        Button newGame = new Button("New Game", Main.getFrame().getWidth()/2, MENU_BAR_HEIGHT);
        Button resumeGame = new Button("Resume Game", Main.getFrame().getWidth()/2 + GamePanel.getBorderThickness(), MENU_BAR_HEIGHT);
        Button leader_board = new Button("Leaderboard", Main.getFrame().getWidth(), MENU_BAR_HEIGHT);

        //The following three pairs of code place the three buttons on the panel.
        //I won't give a dissertation on how this works, but the top line deals with the X location of the object
        //The bottom line deals with the Y location of the object
        layout.putConstraint(SpringLayout.WEST, newGame, 0, SpringLayout.WEST, Main.getFrame().getContentPane());
        layout.putConstraint(SpringLayout.NORTH, newGame, Y_PAD *2 + TILE_LENGTH, SpringLayout.NORTH, Main.getFrame().getContentPane());

        layout.putConstraint(SpringLayout.WEST, resumeGame, Main.getFrame().getWidth()/2 - GamePanel.getBorderThickness(), SpringLayout.WEST, newGame);
        layout.putConstraint(SpringLayout.NORTH, resumeGame, Y_PAD *2 + TILE_LENGTH, SpringLayout.NORTH, Main.getFrame().getContentPane());

        layout.putConstraint(SpringLayout.WEST, leader_board, 0, SpringLayout.WEST, Main.getFrame().getContentPane());
        layout.putConstraint(SpringLayout.NORTH, leader_board, MENU_BAR_HEIGHT - GamePanel.getBorderThickness(), SpringLayout.NORTH, newGame);

        //Add the three buttons to the Panel
        add(newGame);
        add(resumeGame);
        add(leader_board);

        //Add an action listener to the New Game Button
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                /* When NewGame is pressed: start the clock
                   Clear the frame of all content
                   Add the Game Panel to the frame (we've already initialized this in the Main Class
                   call repaint and revalidate on the Main Frame
                   give game panel focus
                */
                GamePanel.getPause().setText("Pause");
                GamePanel.getGame().setRunClock(true);
                Main.getFrame().getContentPane().removeAll();
                Main.getFrame().repaint();
                Main.getFrame().add(Main.getGamePanel());
                Main.getFrame().repaint();
                Main.getFrame().revalidate();
                GamePanel.getGame().NewGame();
                Main.getGamePanel().requestFocus();


            }
        });

        resumeGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (TwentyFortyEight.getResumeGame()) {

                    GamePanel.getPause().setText("Pause");
                    GamePanel.getGame().setRunClock(true);
                    Main.getFrame().getContentPane().removeAll();
                    Main.getFrame().repaint();
                    Main.getFrame().add(Main.getGamePanel());
                    Main.getFrame().repaint();
                    Main.getFrame().revalidate();
                    Main.getGamePanel().requestFocus();
                }
            }

        });

    }

    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        TwentyFortyEight.populateColorTable();

        //500 = width of the frame
        //152 = the space between the top of the frame and the buttons

        int color = 2; //the color of the tile labeled 2


        //first lets loop through the height
        for (int height = 0; height < 155; height += SMALL_TILE_SIDE) { //150 because we will allow the display to "hang"
            //underneath the buttons
            //now lets loop through the width
            for (int width = 0; width < Main.getFrame().getWidth(); width += SMALL_TILE_SIDE) {
                //now we need to loop through the colors

                g2.setColor(TwentyFortyEight.getColorValue(Integer.toString(color)));
                g2.fillRect(width, height, SMALL_TILE_SIDE, SMALL_TILE_SIDE);

                if (color == 8192) {
                    color = 2;
                } else {
                    color *= 2;

                }
            }
        }


        g2.setColor(new Color(75, 225, 250));
        g2.fillRect(Main.getFrame().getWidth() / 2 - TILE_LENGTH / 2, Y_PAD, TILE_LENGTH, TILE_LENGTH);
        g2.setFont(new Font("Serif", Font.BOLD, 24));
        g2.setColor(Color.black);
        g2.drawString("2048", Main.getFrame().getWidth() / 2 - 24, Y_PAD + (TILE_LENGTH / 2) + 9);


        /*
                        Paint the top 10 leader board statistics
         */


        g2.setFont(new Font("Serif", Font.BOLD, 32));

        try {
            if (lbi.getData().size() < num_records) {

                num_records = lbi.getData().size();
            }

            for (int i = 1; i <= num_records; i++) {

                String text = i + ". " + lbi.getData().get(i - 1).getValue2() + "- " + lbi.getData().get(i - 1).getValue0();

                int width = g2.getFontMetrics().stringWidth(text);
                int height = g2.getFontMetrics().getHeight();

                g2.drawString(text, Main.getFrame().getWidth() / 2 - width / 2, LEADER_BOARD_PAD + Y_PAD + (height + 5) * (i - 1));
            }

        }catch(NullPointerException e){

        }
    }


    public static LeaderboardInfo getLbi(){
        return lbi;
    }
}
