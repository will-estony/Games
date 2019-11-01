import javax.swing.*;
import java.awt.*;

public class QuitFrame extends JFrame {

    private JPanel panel;

    private JLabel message;

    private Button yes;
    private Button no;
    private Button quit;

    private int buttonWidth = 100;
    private int buttonHeight = 25;

    private int textFieldWidth = 200;
    private int textFieldHeight = 25;

    private SpringLayout layout;

    public QuitFrame(){

        setTitle("Quit");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(new Dimension(500,200));

        panel = new JPanel();
        panel.setBackground(new Color(225,225,225));

        yes = new Button("Yes",buttonWidth, buttonHeight);
        no = new Button("No", buttonWidth, buttonHeight);
        quit = new Button("Cancel", buttonWidth, buttonHeight);



        message = new JLabel("Are you sure you want to quit?");

        layout = new SpringLayout();

        int len = message.getMaximumSize().width;


        layout.putConstraint(SpringLayout.WEST, message, this.getWidth()/2 - len/2, SpringLayout.WEST,getContentPane());
        layout.putConstraint(SpringLayout.NORTH, message, 50, SpringLayout.NORTH,getContentPane());

        layout.putConstraint(SpringLayout.WEST, yes, 50, SpringLayout.WEST,getContentPane());
        layout.putConstraint(SpringLayout.NORTH, yes, 125, SpringLayout.NORTH,getContentPane());

        layout.putConstraint(SpringLayout.WEST, no, buttonWidth + 50,SpringLayout.WEST, yes);
        layout.putConstraint(SpringLayout.NORTH, no, 125,SpringLayout.NORTH,getContentPane());

        layout.putConstraint(SpringLayout.WEST, quit, buttonWidth + 50,SpringLayout.WEST, no);
        layout.putConstraint(SpringLayout.NORTH, quit, 125,SpringLayout.NORTH,getContentPane());

        panel.setLayout(layout);

        panel.add(message);
        panel.add(yes);
        panel.add(no);
        panel.add(quit);


        getContentPane().add(panel);

    }

    public Button getYes(){
        return yes;
    }

    public Button getNo(){

        return no;
    }

    public Button getCancel(){
        return quit;
    }
}
