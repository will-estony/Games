import java.awt.*;
import java.awt.geom.Line2D;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.math.*;

public class SinglePlayer extends JPanel{
  private JLabel label;

  private boolean released = false;
  private boolean switcher = false;
  private boolean undo = false;
  public static boolean isMoving = false;

  private boolean row1 = false;
  private boolean row2 = false;
  private boolean row3 = false;
  private boolean row4 = false;
  private boolean row5 = false;
  private boolean row6 = false;
  private boolean row7 = false;

  private boolean[] rowBoolList = {row1, row2, row3, row4, row5, row6, row7};

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
  private JButton undoButton = new JButton("Undo");

  private int player = 1;
  private GamePiece bob;

  private static int xMouse;
  private static int yMouse;

  private int inc = 1;

  private ArrayList<GamePiece> pieces = new ArrayList<GamePiece>();
  //don't need the below data structure because we can include col
  //in the Game Piece object
  //private ArrayList<int> previousRow = new ArrayList<int>();

  private int[][] table = new int[6][7];
  private int[][] check = new int[6][7];

  private int[] columnLocations = {50,100,150,200,250,300,350};
  private int randomColumn;


  //variables associated with checking for a connect 4
  private int tempPlayer;
  private int counter;
  private int index;
  private int someVariable;

  private boolean win;
  private SpringLayout layout;


  public SinglePlayer(){
    //start of the constructor

    //populate the table array with 0
    //this array will hold every move in the form of a 1 or a 2
    resetArray(table, ROWS,COLS);

    //the point of this 2d array is to eventually
    //just populate it with the winning "connect 4"
    resetArray(check,ROWS,COLS);


    label = new JLabel();
    label.setText("Player " + player + " it is your turn");

    addMouseListener(new mListener());

    layout = new SpringLayout();

    setLayout(layout);
    layout.putConstraint(SpringLayout.WEST, newGameButton, 125, SpringLayout.WEST, Main.frame.getContentPane());
    layout.putConstraint(SpringLayout.NORTH, newGameButton,365, SpringLayout.NORTH, Main.frame.getContentPane());

    layout.putConstraint(SpringLayout.WEST, label, 175, SpringLayout.WEST, Main.frame.getContentPane());
    layout.putConstraint(SpringLayout.NORTH, label, 25, SpringLayout.NORTH, Main.frame.getContentPane());

    layout.putConstraint(SpringLayout.WEST, undoButton, 250, SpringLayout.WEST, Main.frame.getContentPane());
    layout.putConstraint(SpringLayout.NORTH, undoButton, 365, SpringLayout.NORTH, Main.frame.getContentPane());

    add(undoButton);
    add(newGameButton);
    add(label);
    setBackground(Color.white);

    newGameButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        newGame();
      }
    });

    undoButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        if(pieces.size() > 0){
        //col1++;



        pieces.remove(pieces.size()-1);
        if(bob.getColumn() == 0){

          bottomBox1+=50;
          col1+=1;
          //System.out.println(bob.getColumn() + "," + col1);
          table[col1][bob.getColumn()] = 0;

        }
        if(bob.getColumn() == 1){
          bottomBox2+=50;
          col2+=1;
          //System.out.println(bob.getColumn() + "," + col2);
          table[col2][bob.getColumn()] = 0;
        }
        if(bob.getColumn() == 2){

          bottomBox3+=50;
          col3+=1;
          //System.out.println(bob.getColumn() + "," + col3);
          table[col3][bob.getColumn()] = 0;
        }
        if(bob.getColumn() == 3){
          bottomBox4+=50;
          col4+=1;
          //System.out.println(bob.getColumn() + "," + col4);
          table[col4][bob.getColumn()] = 0;
        }
        if(bob.getColumn() == 4){
          bottomBox5+=50;
          col5+=1;
          //System.out.println(bob.getColumn() + "," + col5);
          table[col5][bob.getColumn()] = 0;
        }
        if(bob.getColumn() == 5){
          bottomBox6+=50;
          col6+=1;
          table[col6][bob.getColumn()] = 0;
        }
        if(bob.getColumn() == 6){

          bottomBox7+=50;
          col7+=1;
          System.out.println(bob.getColumn() + "," + col7);
          table[col7][bob.getColumn()] = 0;
        }
        switchPlayer();
        undo = true;



      }


      }
    });

    //end of constructor
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


  //method that deals with anything being painted on the JPanel
  protected void paintComponent(Graphics g) {
    ScreenSetup a = new ScreenSetup();
    int w = Main.getWidth();
    int h = Main.getHeight();
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;

    //repaint the screen if the user wants to undo their move
    if(undo){
      label.setText("Player " + player + " it is your turn");
      repaint();

      for(int i = 0; i < 6; i++){
        for(int j = 0; j < 7; j++){
          System.out.print(table[i][j]);
        }
        System.out.println();
      }

      undo = false;
  }



    g2.setColor(Color.black);


    //draw the row lines of table
    for(int i = 0; i <= ROWS; i++){
      int xCord = PAD + xInc*i;
      Line2D lin = new Line2D.Double(PAD, xCord, (w - PAD)-25, xCord);
      g2.draw(lin);
    }

    //draw the column lines of table
    for(int i = 0; i <= COLS; i++){
      int yCord = PAD + yInc* i;
      Line2D lin = new Line2D.Double(yCord, PAD, yCord, (h - PAD)-75);
      g2.draw(lin);
    }




    if(!connect4() && !checkDiagnal()){


      layout.putConstraint(SpringLayout.WEST, label, 175, SpringLayout.WEST, Main.frame.getContentPane());
      layout.putConstraint(SpringLayout.NORTH, label, 25, SpringLayout.NORTH, Main.frame.getContentPane());

      if(player == 2){
      //flag2 = false;
      g2.setColor(Color.red);
      //randomColumn = (int) (Math.random()*7);
      randomColumn = 1;
      bob = new GamePiece(columnLocations[randomColumn], 0, randomColumn,player);
      rowBoolList[randomColumn] = true;
      bob.draw(g);
      //System.out.println(randomColumn);
      //System.out.println(rowBoolList[randomColumn]);

      released = true;
      //switcher = true;






      if(row1){

        bob.draw(g);
        bob.move(inc);
        repaint();
        if(bob.getYCord() == bottomBox1){

          flag2 = true;
          row1 = false;

          if(flag2){
            bob.draw(g);
            bottomBox1 = bob.getYCord()-50;
            pieces.add(bob);
            table[col1][arrayCol1] = bob.getPlayer();
            col1--;
            switchPlayer();
            flag2 = false;



            label.setText("Player " + player + " it is your turn");
            add(label);
          }
        }

      }
    }

      if(row2){
        isMoving = true;
        bob.draw(g);
        bob.move(inc);
        repaint();
        if(bob.getYCord() == bottomBox2){

          flag2 = true;
          row2 = false;

          if(flag2){
            bob.draw(g);
            bottomBox2 = bob.getYCord()-50;
            pieces.add(bob);
            table[col2][arrayCol2] = bob.getPlayer();
            col2--;
            switchPlayer();
            flag2 = false;



            label.setText("Player " + player + " it is your turn");
            add(label);
            //isMoving = false;
          }
        }

      }
      if(row3){
        bob.draw(g);
        bob.move(inc);
        repaint();
        if(bob.getYCord() == bottomBox3){

          flag2 = true;
          row3 = false;

          if(flag2){
            bob.draw(g);
            bottomBox3 = bob.getYCord()-50;
            pieces.add(bob);
            table[col3][arrayCol3] = bob.getPlayer();
            col3--;
            switchPlayer();
            flag2 = false;



            label.setText("Player " + player + " it is your turn");
            add(label);
          }
        }

      }
      if(row4){
        bob.draw(g);
        bob.move(inc);
        repaint();
        if(bob.getYCord() == bottomBox4){

          flag2 = true;
          row4 = false;

          if(flag2){
            bob.draw(g);
            bottomBox4 = bob.getYCord()-50;
            pieces.add(bob);
            table[col4][arrayCol4] = bob.getPlayer();
            col4--;
            switchPlayer();
            flag2 = false;

            label.setText("Player " + player + " it is your turn");
            add(label);
          }
        }
      }
      if(row5){
        bob.draw(g);
        bob.move(inc);
        repaint();
        if(bob.getYCord() == bottomBox5){

          flag2 = true;
          row5 = false;

          if(flag2){
            bob.draw(g);
            bottomBox5 = bob.getYCord()-50;
            pieces.add(bob);
            table[col5][arrayCol5] = bob.getPlayer();
            col5--;
            switchPlayer();
            flag2 = false;



            label.setText("Player " + player + " it is your turn");
            add(label);
          }
        }

      }
      if(row6){
        bob.draw(g);
        bob.move(inc);
        repaint();
        if(bob.getYCord() == bottomBox6){

          flag2 = true;
          row6 = false;

          if(flag2){
            bob.draw(g);
            bottomBox6 = bob.getYCord()-50;
            pieces.add(bob);
            table[col6][arrayCol6] = bob.getPlayer();
            col6--;

            switchPlayer();




            flag2 = false;



            label.setText("Player " + player + " it is your turn");
            add(label);
          }
        }

      }
      if(row7){
        bob.draw(g);
        bob.move(inc);
        repaint();
        if(bob.getYCord() == bottomBox7){

          flag2 = true;
          row7 = false;

          if(flag2){
            bob.draw(g);
            bottomBox7 = bob.getYCord()-50;
            pieces.add(bob);
            table[col7][arrayCol7] = bob.getPlayer();
            col7--;

            switchPlayer();

            flag2 = false;



            label.setText("Player " + player + " it is your turn");
            add(label);
          }
        }


      }


      for(GamePiece piece: pieces){
        g.setColor(Color.white);
        g.fillOval(50,0,50,50);
        g.setColor(Color.blue);
        piece.draw(g);
      }
    }else if (released){
      //System.out.println("connect 4");
      for(int i = 0; i < ROWS; i++){
        for(int j = 0; j < COLS; j++){

          if(check[i][j] == getOppositePlayer(player)){
            g2.setColor(Color.yellow);
            Rectangle rect = new Rectangle((j)*50 + PAD,(i)*50 + PAD, 50 ,50);
            g2.fill(rect);
          }

        }
      }
      g2.setColor(Color.black);
      for(int i = 0; i <= ROWS; i++){
        int xCord = PAD + xInc*i;
        Line2D lin = new Line2D.Double(PAD, xCord, (w - PAD)-25, xCord);
        g2.draw(lin);
      }

      //draw the column lines of table
      for(int i = 0; i <= COLS; i++){
        int yCord = PAD + yInc* i;
        Line2D lin = new Line2D.Double(yCord, PAD, yCord, (h - PAD)-75);
        g2.draw(lin);
      }

      for(GamePiece piece: pieces){
        piece.draw(g);
      }

      if(switcher){
       endGameFrame();
       switcher = false;
     }



    }




    addMouseListener(new mListener(){



    });
  }


  private boolean connect4(){

    win = false;
    //logic to assess whether a player connected
    //four in a row going across
    for(int player = 1; player <= 2; player++){
      for(int i = 0; i < 6; i++){
        for(int j = 0; j < 4; j++){
          index = j;
          counter = 0;

          while(table[i][index] == player){


            counter++;
            index++;

            if(counter == 4){
                //resetArray(check,ROWS,COLS);
              for(int b = 0; b < 4; b++){

                check[i][index-1] = player;
                index--;

              }
              remove(label);

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
            //check[index][i] = player;
            counter++;
            index++;

            if(counter == 4){
              for(int b = 0; b < 4; b++){

                check[index-1][i] = player;
                index--;
                //i--;

              }
              remove(label);
              win = true;
              break;
            }
          }
        }
      }
    }
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
    for(int a = 1; a <= 2; a++){


    counter = 0;

    for(int i = 0; i < 3; i++){
      for(int j = i; j < 3; j++){

        int row = j;
        int col = i;
        while(table[row][col] == a){

          counter++;
          row++;
          col++;

          if(counter == 4){

            for(int b = 0; b < 4; b++){

              check[row-1][col-1] = a;
              row--;
              col--;

            }

            win = true;

             break;
          }
        }
        counter = 0;

  }
}
}   return win;
  }

  private boolean bottomLeft(){
      win = false;
  for(int a = 1; a <= 2; a++){

    counter = 0;
    someVariable = 0;

    for(int i = 5; i >= 3; i--){
      for(int j = someVariable; j <= 3; j++){

      int row = i;
      int col = j;

        while(table[row][col] == a){



          counter++;
          row--;
          col++;
          if(counter == 4){
            for(int b = 0; b < 4; b++){

              check[row+1][col-1] = a;
              row++;
              col--;

            }
            win = true;
             break;
          }
        }

        counter = 0;
  } someVariable++;
  }
}
    return win;
  }

  private boolean bottomRight(){

    win = false;
    for(int a = 1; a <= 2; a++){
    counter = 0;
    someVariable = 5;

    for(int i = 6; i > 3; i--){
      for(int j = someVariable; j >= 3; j--){

      int row = j;
      int col = i;

        while(table[row][col] == a){

          counter++;
          row--;
          col--;

          if(counter == 4){

            for(int b = 0; b < 4; b++){

              check[row+1][col+1] = a;
              row++;
              col++;

            }
            win = true;
             break;
          }
        }
        counter = 0;
  } someVariable--;
  }
}
    return win;
  }

  private boolean topRight(){

    win = false;
    for(int a = 1; a <= 2; a++){
    counter = 0;
    someVariable = 6;

    for(int i = 0; i < 3; i++){
      for(int j = someVariable; j > 2; j--){

      int row = i;
      int col = j;

        while(table[row][col] == a){

          counter++;
          row++;
          col--;

          if(counter == 4){
            for(int b = 0; b < 4; b++){

              check[row-1][col+1] = a;
              row--;
              col++;

            }
            win = true;
             break;
          }
        }
        counter = 0;
  } someVariable--;
  }
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

  public void endGameFrame(){





    PopUpFrame window = new PopUpFrame();

    //items to be placed on the popUpFrame using a spring layout
    JPanel panel = new JPanel();
    JLabel label = new JLabel("Player " + getOppositePlayer(player) + " wins!");
    JLabel label2 = new JLabel("Would you like to play again?");
    JButton yes = new JButton("Yes");
    JButton no = new JButton("No");


    layout = new SpringLayout();

    panel.setLayout(layout);

    //location constraints for the first label
    layout.putConstraint(SpringLayout.WEST, label, 150, SpringLayout.WEST, window.getContentPane());
    layout.putConstraint(SpringLayout.NORTH, label, 25, SpringLayout.NORTH, window.getContentPane());

    //location constraints for the second label
    layout.putConstraint(SpringLayout.WEST, label2, 100, SpringLayout.WEST, window.getContentPane());
    layout.putConstraint(SpringLayout.NORTH, label2, 50, SpringLayout.NORTH, window.getContentPane());

    //location constraints for the "yes" button
    layout.putConstraint(SpringLayout.WEST, yes, 100, SpringLayout.WEST, window.getContentPane());
    layout.putConstraint(SpringLayout.NORTH, yes, 125, SpringLayout.NORTH, window.getContentPane());

    layout.putConstraint(SpringLayout.WEST, no, 200, SpringLayout.WEST, window.getContentPane());
    layout.putConstraint(SpringLayout.NORTH, no, 125, SpringLayout.NORTH, window.getContentPane());

    panel.setBackground(Color.white);
    panel.add(label);
    panel.add(label2);
    panel.add(yes);
    panel.add(no);

    window.getContentPane().add(panel);

    //if the yes button is pushed do something
    yes.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        released = false;
        window.setVisible(false);
        //call the newGame method that "resets" the game
        newGame();
      }

    });

    //if the no button is pushed do something else
    no.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {

    }

    });


  }

  public void newGame(){

    //the first bit of this method
    //concerns making the board look like it should
    //when a new game is requested
    //we re-set the layout, remove all the J objects
    //and add them all back in the locations they started at

    released = false;


    layout = new SpringLayout();
    this.setLayout(layout);
    pieces.clear();




    player = 1;

    this.remove(label);
    label.setText("Player " + player + " it is your turn");
    layout.putConstraint(SpringLayout.WEST, label, 175, SpringLayout.WEST, Main.frame.getContentPane());
    layout.putConstraint(SpringLayout.NORTH, label, 25, SpringLayout.NORTH, Main.frame.getContentPane());
    this.add(label);

    this.remove(newGameButton);
    layout.putConstraint(SpringLayout.WEST, newGameButton, 125, SpringLayout.WEST, Main.frame.getContentPane());
    layout.putConstraint(SpringLayout.NORTH, newGameButton,365, SpringLayout.NORTH, Main.frame.getContentPane());
    this.add(newGameButton);

    this.remove(undoButton);
    layout.putConstraint(SpringLayout.WEST, undoButton, 250, SpringLayout.WEST, Main.frame.getContentPane());
    layout.putConstraint(SpringLayout.NORTH, undoButton, 365, SpringLayout.NORTH, Main.frame.getContentPane());
    this.add(undoButton);

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



    resetArray(table,ROWS,COLS);
    resetArray(check,ROWS,COLS);

  }

  public void resetArray(int[][] array, int rowMax, int heightMax){
    for(int i = 0; i < rowMax; i++){
      for(int j = 0; j < heightMax; j++){
        array[i][j] = 0;

      }
    }

  }










  private class mListener implements MouseListener{

    public void mouseClicked(MouseEvent e){

    }


    public void mouseEntered(MouseEvent e){}
      public void mouseExited(MouseEvent e){}
        public void mousePressed(MouseEvent e){

          flag2 = false;
          //label.setText("Player " + player + " it is your turn");
          //add(label);

          if(player == 1){
          if(e.getY() >= 50 && e.getY() <= 350){

            if(e.getX() >= 50 && e.getX() <= 100){
              if(!row2)
              row1 = true;
              bob = new GamePiece(50,0,0,player);
              repaint();


            }

            if(e.getX() >= 100 && e.getX() <= 150){
              row2 = true;
              bob = new GamePiece(100,0,1,player);
              repaint();


            }
            if(e.getX() >= 150 && e.getX() <= 200){
              bob = new GamePiece(150,0,2,player);
              row3 = true;
              repaint();

            }
            if(e.getX() >= 200 && e.getX() <= 250){
              bob = new GamePiece(200,0,3,player);
              row4 = true;
              repaint();

            }
            if(e.getX() >= 250 && e.getX() <= 300){
              bob = new GamePiece(250,0,4,player);
              row5 = true;
              repaint();

            }
            if(e.getX() >= 300 && e.getX() <= 350){
              bob = new GamePiece(300,0,5, player);
              row6 = true;
              repaint();

            }
            if(e.getX() >= 350 && e.getX() <= 400){
              bob = new GamePiece(350,0,6,player);
              row7 = true;
              repaint();

            }
          }
        }
          remove(label);
        }








        public void mouseReleased(MouseEvent e){



          released = true;
          switcher = true;

        }

      }
    }
