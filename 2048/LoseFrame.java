import javax.swing.*;
import java.awt.*;

public class LoseFrame extends JFrame {

    private JPanel panel;

    private JTextField name;
    private JLabel enterName;
    private JLabel message;

    private Button newGame;
    private Button mainMenu;
    private Button quit;

    private int buttonWidth = 100;
    private int buttonHeight = 25;

    private int textFieldWidth = 200;
    private int textFieldHeight = 25;

    private SpringLayout layout;

    public LoseFrame(){

        setTitle("Game Over!");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(new Dimension(500,200));

        panel = new JPanel();
        panel.setBackground(new Color(225,225,225));

        newGame = new Button("New Game",buttonWidth, buttonHeight);
        mainMenu = new Button("Main Menu", buttonWidth, buttonHeight);
        quit = new Button("Quit", buttonWidth, buttonHeight);

        name = new JTextField();
        name.setPreferredSize(new Dimension(textFieldWidth,textFieldHeight));

        enterName = new JLabel("Enter your name:");
        message = new JLabel("Your final score is " + TwentyFortyEight.getScore());

        layout = new SpringLayout();

        int len = message.getMaximumSize().width;

        layout.putConstraint(SpringLayout.WEST, message, this.getWidth()/2 - len/2, SpringLayout.WEST,getContentPane());
        layout.putConstraint(SpringLayout.NORTH, message, 25, SpringLayout.NORTH,getContentPane());

        layout.putConstraint(SpringLayout.WEST, enterName, 50, SpringLayout.WEST,getContentPane());
        layout.putConstraint(SpringLayout.NORTH, enterName, 75, SpringLayout.NORTH,getContentPane());

        layout.putConstraint(SpringLayout.WEST, name, 200, SpringLayout.WEST,getContentPane());
        layout.putConstraint(SpringLayout.NORTH, name, 75, SpringLayout.NORTH,getContentPane());

        layout.putConstraint(SpringLayout.WEST, newGame, 50, SpringLayout.WEST,getContentPane());
        layout.putConstraint(SpringLayout.NORTH, newGame, 125, SpringLayout.NORTH,getContentPane());

        layout.putConstraint(SpringLayout.WEST, mainMenu, buttonWidth + 50,SpringLayout.WEST, newGame);
        layout.putConstraint(SpringLayout.NORTH, mainMenu, 125,SpringLayout.NORTH,getContentPane());

        layout.putConstraint(SpringLayout.WEST, quit, buttonWidth + 50,SpringLayout.WEST,mainMenu);
        layout.putConstraint(SpringLayout.NORTH, quit, 125,SpringLayout.NORTH,getContentPane());

        panel.setLayout(layout);

        panel.add(message);
        panel.add(enterName);
        panel.add(name);
        panel.add(newGame);
        panel.add(mainMenu);
        panel.add(quit);


        getContentPane().add(panel);

    }

    public JTextField getInput(){
        return name;
    }

    public Button getNewGame(){
        return newGame;
    }

    public Button getMainMenu(){

        return mainMenu;
    }

    public Button getQuit(){
        return quit;
    }
}
