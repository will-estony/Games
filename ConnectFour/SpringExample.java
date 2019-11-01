import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.border.*;


public class SpringExample{

public static void main(String[] args){

JButton clearButton = new JButton("Clear Board");

JFrame frame = new JFrame();

JPanel panel = new JPanel();

SpringLayout layout = new SpringLayout();
frame.getContentPane().setLayout(layout);
 layout.putConstraint(SpringLayout.WEST,clearButton,225, SpringLayout.WEST,frame.getContentPane());
 layout.putConstraint(SpringLayout.NORTH,clearButton,300,SpringLayout.NORTH,frame.getContentPane());

 panel.add(clearButton);

frame.getContentPane().add(panel);

frame.setPreferredSize(new Dimension(300,300));
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

frame.pack();
frame.setVisible(true);

}


}
