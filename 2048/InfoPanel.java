
import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {

    private SpringLayout layout;
    private JLabel name;
    private JLabel date;


    public InfoPanel(){

        layout = new SpringLayout();
        name = new JLabel("Written by William F. Estony");
        date = new JLabel("December - 2018");

        //set the color and font size of the text
        name.setForeground(new Color(247,148,29));
        date.setForeground(new Color(247,148,29));
        name.setFont(new Font("Serif", Font.PLAIN, 14));
        date.setFont(new Font("Serif", Font.PLAIN, 14));

        this.add(name);
        this.add(date);

        this.setBackground(new Color(253,247,153));
        this.setLayout(layout);

        //change the location of where the text is printed
        layout.putConstraint(SpringLayout.WEST, name,150,SpringLayout.WEST, Main.getFrame().getContentPane());
        layout.putConstraint(SpringLayout.NORTH, name,25,SpringLayout.NORTH, Main.getFrame().getContentPane());

        layout.putConstraint(SpringLayout.WEST, date,150,SpringLayout.WEST, Main.getFrame().getContentPane());
        layout.putConstraint(SpringLayout.NORTH, date,25,SpringLayout.NORTH, name);


    }

}

