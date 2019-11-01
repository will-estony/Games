import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.border.*;



public class ScreenSetup extends JFrame{

  private JPanel singlePlayer;
  //private JPanel twoPlayer;
  private JTabbedPane tab;

  //private JLabel label = new JLabel("Hello World");







public ScreenSetup(){

this.setTitle("Connect Four");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setSize(new Dimension(475,475));



singlePlayer = new JPanel();
//twoPlayer = new JPanel();

tab = new JTabbedPane();
TwoPlayer panel = new TwoPlayer();

//tab.addTab("Single Player",singlePlayer);
tab.addTab("Two Players", panel);






getContentPane().add(tab);




singlePlayer.setBackground(Color.white);

}
}
