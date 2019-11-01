import java.awt.*;
import java.awt.geom.Line2D;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;




public class GamePiece{

private int player;
private int xCord;
private int yCord;
private int column;

public GamePiece(int xCord, int yCord, int column, int player){
    this.xCord = xCord;
    this.yCord = yCord;
    this.player = player;
    this.column = column;
}

public void setyCord(int yCord){

this.yCord = yCord;

}

public int getXCord(){

  return xCord;
}

public int getYCord(){

  return yCord;
}

public int getColumn(){

  return column;
}
public int getPlayer(){

  return player;
}

public void draw(Graphics g){
if(this.player == 1)
g.setColor(Color.blue);
else
g.setColor(Color.red);

g.fillOval(this.xCord, this.yCord, 50, 50);

}


public void move(int inc){
  //while(yCord<=300)
  TwoPlayer.isMoving = true;
  yCord+=inc;
  //System.out.println(inc);


}

}
