/**
 * This class runs the main method necessary for displaying
 * the connect four game
 *
 * @author Will Estony
 * @version 1.0 5/29/18
 */


import java.sql.*;
import java.awt.*;
import java.util.Scanner;
import javax.swing.*;

public class Main{


static JFrame frame = new JFrame("Connect Four");
public static int width = frame.getWidth();
public static int height = frame.getHeight();

private static JPanel singlePlayer;
private static JTabbedPane tab;

public static void main(String[] args){

  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setSize(new Dimension(475,475));

  singlePlayer = new JPanel();
  tab = new JTabbedPane();

  TwoPlayer panel = new TwoPlayer();
  SinglePlayer panel2 = new SinglePlayer();

  tab.addTab("Single Player", panel2);
  tab.addTab("Two Players", panel);


  frame.getContentPane().add(tab);
  frame.setVisible(true);

  //PopUpFrame bob = new PopUpFrame();

}
public static int getHeight(){
  return frame.getHeight();
}
public static int getWidth(){
  return frame.getWidth();
}
}
