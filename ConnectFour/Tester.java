import java.awt.*;
import java.awt.geom.Line2D;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;



public class Tester extends JPanel{

  private JLabel label;
  private JLabel label2;
  private boolean released = false;

  private boolean row1 = false;
  private boolean row2 = false;
  private boolean row3 = false;
  private boolean row4 = false;
  private boolean row5 = false;
  private boolean row6 = false;
  private boolean row7 = false;

  private int bottomBox1 = 300;
  private int bottomBox2 = 300;
  private int bottomBox3 = 300;
  private int bottomBox4 = 300;
  private int bottomBox5 = 300;
  private int bottomBox6 = 300;
  private int bottomBox7 = 300;

  private int col1 = 5;
  private int col2 = 5;
  private int col3 = 5;
  private int col4 = 5;
  private int col5 = 5;
  private int col6 = 5;
  private int col7 = 5;

  private int arrayCol1 = 0;
  private int arrayCol2 = 1;
  private int arrayCol3 = 2;
  private int arrayCol4 = 3;
  private int arrayCol5 = 4;
  private int arrayCol6 = 5;
  private int arrayCol7 = 6;

  private boolean flag2 = false;
  final int ROWS = 6;
  final int COLS = 7;
  final static int PAD = 50;
  static int xInc = 50;
  static int yInc = 50;
  private JButton newGameButton = new JButton("New Game");
  //private JButton moveButton = new JButton("Move");
  int dy = 0;
  private int player = 1;




  private GamePiece bob;

  private static int xMouse;
  private static int yMouse;

  private int inc = 1;

  private ArrayList<GamePiece> pieces = new ArrayList<GamePiece>();
  private int[][] table = new int[6][7];
  private int[][] check = new int[6][7];

  //variables associated with checking for a connect 4
  private int tempPlayer;
  private int counter;
  private int index;
  private int someVariable;

  private boolean win;
  private SpringLayout layout;


  public Tester(){

    label = new JLabel("No 4 in a row");
    label2 = new JLabel("4 in a row");
    add(label);
    repaint();

    //System.out.println(connect4());

    for(int i = 0; i < 6; i++){
      for(int j = 0; j < 7; j++){
        table[i][j] = 0;

      }
    }
    //for testing purposes only


    for(int i = 0; i < 6; i++){
      for(int j = 0; j < 7; j++){
        check[i][j] = 0;

      }
    }







    addMouseListener(new mListener());

    layout = new SpringLayout();

    setLayout(layout);
    layout.putConstraint(SpringLayout.WEST, newGameButton, 175, SpringLayout.WEST, Main.frame.getContentPane());
    layout.putConstraint(SpringLayout.NORTH, newGameButton,365, SpringLayout.NORTH, Main.frame.getContentPane());








    add(newGameButton);

    setBackground(Color.white);

    newGameButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        newGame();
      }
    });




  }



  private int getPlayer(){

    return player;

  }

  public static int getxMouse(){

    return xMouse;

  }

  public static int getyMouse(){

    return yMouse;

  }



  protected void paintComponent(Graphics g) {
    ScreenSetup a = new ScreenSetup();
    int w = Main.getWidth();
    int h = Main.getHeight();
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;


    for(int i = 0; i <= ROWS; i++){
      int xCord = PAD + xInc*i;

      Line2D lin = new Line2D.Double(PAD, xCord, (w - PAD)-25, xCord);
      g2.draw(lin);
    }


    for(int i = 0; i <= COLS; i++){

      int yCord = PAD + yInc* i;

      Line2D lin = new Line2D.Double(yCord, PAD, yCord, (h - PAD)-75);
      g2.draw(lin);
    }

    if(!connect4() && !checkDiagnal()){





      // if(row1){
      //
      //     flag2 = true;
      //     row1 = false;
      //
      //     if(flag2){
      //       bob.draw(g);
      //       bottomBox1 = bob.getYCord()-50;
      //       pieces.add(bob);
      //       table[col1][arrayCol1] = bob.getPlayer();
      //       col1--;
      //       flag2 = false;
      //     }
      //
      //
      // }
      // if(row2){
      //   bob.draw(g);
      //   bob.move(inc);
      //   repaint();
      //   if(bob.getYCord() == bottomBox2){
      //
      //     flag2 = true;
      //     row2 = false;
      //
      //     if(flag2){
      //       bob.draw(g);
      //       bottomBox2 = bob.getYCord()-50;
      //       pieces.add(bob);
      //       table[col2][arrayCol2] = bob.getPlayer();
      //       col2--;
      //       //switchPlayer();
      //       flag2 = false;
      //
      //
      //
      //
      //     }
      //   }
      //
      // }
      // if(row3){
      //   bob.draw(g);
      //   bob.move(inc);
      //   repaint();
      //   if(bob.getYCord() == bottomBox3){
      //
      //     flag2 = true;
      //     row3 = false;
      //
      //     if(flag2){
      //       bob.draw(g);
      //       bottomBox3 = bob.getYCord()-50;
      //       pieces.add(bob);
      //       table[col3][arrayCol3] = bob.getPlayer();
      //       col3--;
      //       //switchPlayer();
      //       flag2 = false;
      //
      //
      //
      //
      //     }
      //   }
      //
      // }
      // if(row4){
      //   bob.draw(g);
      //   bob.move(inc);
      //   repaint();
      //   if(bob.getYCord() == bottomBox4){
      //
      //     flag2 = true;
      //     row4 = false;
      //
      //     if(flag2){
      //       bob.draw(g);
      //       bottomBox4 = bob.getYCord()-50;
      //       pieces.add(bob);
      //       table[col4][arrayCol4] = bob.getPlayer();
      //       col4--;
      //       //switchPlayer();
      //       flag2 = false;
      //
      //
      //     }
      //   }
      // }
      // if(row5){
      //   bob.draw(g);
      //   bob.move(inc);
      //   repaint();
      //   if(bob.getYCord() == bottomBox5){
      //
      //     flag2 = true;
      //     row5 = false;
      //
      //     if(flag2){
      //       bob.draw(g);
      //       bottomBox5 = bob.getYCord()-50;
      //       pieces.add(bob);
      //       table[col5][arrayCol5] = bob.getPlayer();
      //       col5--;
      //       //switchPlayer();
      //       flag2 = false;
      //
      //
      //
      //
      //     }
      //   }
      //
      // }
      // if(row6){
      //   bob.draw(g);
      //   bob.move(inc);
      //   repaint();
      //   if(bob.getYCord() == bottomBox6){
      //
      //     flag2 = true;
      //     row6 = false;
      //
      //     if(flag2){
      //       bob.draw(g);
      //       bottomBox6 = bob.getYCord()-50;
      //       pieces.add(bob);
      //       table[col6][arrayCol6] = bob.getPlayer();
      //       col6--;
      //
      //       //switchPlayer();
      //
      //
      //
      //
      //       flag2 = false;
      //
      //
      //
      //     }
      //   }
      //
      // }
      // if(row7){
      //   bob.draw(g);
      //   bob.move(inc);
      //   repaint();
      //   if(bob.getYCord() == bottomBox7){
      //
      //     flag2 = true;
      //     row7 = false;
      //
      //     if(flag2){
      //       bob.draw(g);
      //       bottomBox7 = bob.getYCord()-50;
      //       pieces.add(bob);
      //       table[col7][arrayCol7] = bob.getPlayer();
      //       col7--;
      //
      //       //switchPlayer();
      //
      //       flag2 = false;
      //
      //
      //
      //
      //     }
      //   }
      //
      //
      // }
      if(flag2){
        boolean joe = true;
        flag2 = false;
        if(joe){
          bob.draw(g);
          repaint();

        }
      }



      for(GamePiece piece: pieces){
        g.setColor(Color.white);
        g.fillOval(50,0,50,50);
        g.setColor(Color.blue);
        piece.draw(g);
      }
    }else if(released) {
      newGame();
      System.out.println("4 in a row");
      remove(label);
      released = false;

    }




    addMouseListener(new mListener(){



    });
  }


  private boolean connect4(){

    win = false;
    //logic to assess whether a player connected
    //four in a row going across
    //for(int player = 1; player <= 2; player++){
      for(int i = 0; i < 6; i++){
        for(int j = 0; j < 4; j++){
          index = j;
          counter = 0;
          //System.out.println(i + "," + index);
          while(table[i][index] == 1){
            //System.out.println(i + "," + index);
            counter++;
            index++;
            if(counter == 4){

              win = true;
              break;
            }
          }
        }
      }

      //logic to assess whether a player connected
      //four in a row going up and down
      for(int i = 0; i < 7; i++){
        for(int j = 0; j < 3; j++){
          counter = 0;
          index = j;

          while(table[index][i] == player){
            counter++;
            index++;
            if(counter == 4){
              remove(label);
              win = true;
              break;
            }
          }
        }
      }
    //}

    // if(checkDiagnal())
    //   win = true;

    return win;
  }


  private boolean checkDiagnal(){

    //this method combines all four diagnal checking methods
    //and returns one compact boolean value
    win = false;

    if(topLeft()||bottomLeft()||topRight()||bottomRight())
      win = true;

    return win;
}

//the following methods check the diagnals from each corner
//of the Board
//uses nested for-loops to traverse down columns
//across rows and into the board
  private boolean topLeft(){

    win = false;
    //tempPlayer = getOppositePlayer(player);

    counter = 0;

    for(int i = 0; i < 3; i++){
      for(int j = i; j < 3; j++){

        int row = j;
        int col = i;
        while(table[row][col] == 1){
          counter++;
          row++;
          col++;
          check[row][col] = table[row][col];
          if(counter == 4){

            win = true;

             break;
          }
        }
        counter = 0;
  }
}   return win;
  }

  private boolean bottomLeft(){

    win = false;

    tempPlayer = getOppositePlayer(player);

    counter = 0;
    someVariable = 0;

    for(int i = 5; i >= 3; i--){
      for(int j = someVariable; j <= 3; j++){

      int row = i;
      int col = j;

        while(table[row][col] == tempPlayer){
          counter++;
          row--;
          col++;
          check[row][col] = table[row][col];
          if(counter == 4){
            win = true;
             break;
          }
        }
        counter = 0;
  } someVariable++;
  }
    return win;
  }

  private boolean bottomRight(){

    win = false;

    tempPlayer = getOppositePlayer(player);


    counter = 0;
    someVariable = 5;

    for(int i = 6; i > 3; i--){
      for(int j = someVariable; j >= 3; j--){

      int row = j;
      int col = i;

        while(table[row][col] == tempPlayer){
          counter++;
          row--;
          col--;
          check[row][col] = table[row][col];
          if(counter == 4){
            win = true;
             break;
          }
        }
        counter = 0;
  } someVariable--;
  }
    return win;
  }

  private boolean topRight(){

    win = false;
    tempPlayer = getOppositePlayer(player);
    counter = 0;
    someVariable = 6;

    for(int i = 0; i < 3; i++){
      for(int j = someVariable; j > 2; j--){

      int row = i;
      int col = j;

        while(table[row][col] == tempPlayer){
          counter++;
          row++;
          col--;
          check[row][col] = table[row][col];
          if(counter == 4){
            win = true;
             break;
          }
        }
        counter = 0;
  } someVariable--;
  }
    return win;
  }

  //helper method for diagnal methods
  //ensures the connect four is "seen"
  //before the next move is made
  private int getOppositePlayer (int player){
    if(player == 1)
      return 2;
    else
      return 1;
  }

  private void switchPlayer(){
    if(player == 1)
      player = 2;
    else
      player = 1;

  }



  public void newGame(){

    pieces.clear();

    repaint();



    bottomBox1 = 300;
    bottomBox2 = 300;
    bottomBox3 = 300;
    bottomBox4 = 300;
    bottomBox5 = 300;
    bottomBox6 = 300;
    bottomBox7 = 300;

    col1 = 5;
    col2 = 5;
    col3 = 5;
    col4 = 5;
    col5 = 5;
    col6 = 5;
    col7 = 5;

    arrayCol1 = 0;
    arrayCol2 = 1;
    arrayCol3 = 2;
    arrayCol4 = 3;
    arrayCol5 = 4;
    arrayCol6 = 5;
    arrayCol7 = 6;




    for(int i = 0; i < 6; i++){
      for(int j = 0; j < 7; j++){
        table[i][j] = 0;

      }
    }



    }












  private class mListener implements MouseListener{

    public void mouseClicked(MouseEvent e){

    }


    public void mouseEntered(MouseEvent e){}
      public void mouseExited(MouseEvent e){}
        public void mousePressed(MouseEvent e){


          //label.setText("Player " + player + " it is your turn");
          //add(label);
          int boxSide = 50;

          //bob = new GamePiece((e.getX()/boxSide)*boxSide,(e.getY()/boxSide)*boxSide,1);
          flag2 = true;


          // if(e.getY() >= 50 && e.getY() <= 350){
          //   if(e.getX() >= 50 && e.getX() <= 100){
          //     bob = new GamePiece(50,0,player);
          //     row1 = true;
          //     repaint();
          //
          //
          //   }
          //
          //   if(e.getX() >= 100 && e.getX() <= 150){
          //     bob = new GamePiece(100,0,player);
          //     row2 = true;
          //     repaint();
          //
          //
          //   }
          //   if(e.getX() >= 150 && e.getX() <= 200){
          //     bob = new GamePiece(150,0,player);
          //     row3 = true;
          //     repaint();
          //
          //   }
          //   if(e.getX() >= 200 && e.getX() <= 250){
          //     bob = new GamePiece(200,0,player);
          //     row4 = true;
          //     repaint();
          //
          //   }
          //   if(e.getX() >= 250 && e.getX() <= 300){
          //     bob = new GamePiece(250,0,player);
          //     row5 = true;
          //     repaint();
          //
          //   }
          //   if(e.getX() >= 300 && e.getX() <= 350){
          //     bob = new GamePiece(300,0,player);
          //     row6 = true;
          //     repaint();
          //
          //   }
          //   if(e.getX() >= 350 && e.getX() <= 400){
          //     bob = new GamePiece(350,0,player);
          //     row7 = true;
          //     repaint();
          //
          //   }
          // }







        }






        public void mouseReleased(MouseEvent e){
          released = true;

        }

      }
    }
