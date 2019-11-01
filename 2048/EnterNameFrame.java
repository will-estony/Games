import javax.swing.*;
import java.awt.*;

public class EnterNameFrame extends JFrame {

    private JPanel panel;

    private JTextField name;
    private JLabel enterName;
    private JLabel message;

    private Button enter;
    private Button cancel;

    private int buttonWidth = 100;
    private int buttonHeight = 25;

    private int textFieldWidth = 175;
    private int textFieldHeight = 25;

    private SpringLayout layout;

    public EnterNameFrame(){

        setTitle("");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(new Dimension(500,200));

        panel = new JPanel();
        panel.setBackground(new Color(225,225,225));

        enter = new Button("Enter",buttonWidth, buttonHeight);
        cancel = new Button("Cancel", buttonWidth, buttonHeight);

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

        layout.putConstraint(SpringLayout.WEST, enter, 100, SpringLayout.WEST,getContentPane());
        layout.putConstraint(SpringLayout.NORTH, enter, 125, SpringLayout.NORTH,getContentPane());

        layout.putConstraint(SpringLayout.WEST, cancel, buttonWidth + 75,SpringLayout.WEST, enter);
        layout.putConstraint(SpringLayout.NORTH, cancel, 125,SpringLayout.NORTH,getContentPane());

        panel.setLayout(layout);

        panel.add(message);
        panel.add(enterName);
        panel.add(name);
        panel.add(enter);
        panel.add(cancel);


        getContentPane().add(panel);

    }

    public JTextField getInput(){
        return name;
    }

    public Button getEnter(){
        return enter;
    }

    public Button getCancel(){
        return cancel;
    }
}

