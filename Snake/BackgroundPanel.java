import javax.swing.*;
import java.util.Random;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

public class BackgroundPanel extends JPanel {
    private static final int boxSize = 25;
    private static final int inc = 25;
    private int xCord;
    private int yCord;
    private int x;
    private int y;



    private static int gameTime = 0;

    private boolean rightMoving = true;
    private boolean leftMoving = false;
    private boolean upMoving = false;
    private boolean downMoving = false;


    private static int upInc = 0;
    private static int downInc = 0;
    private static int rightInc = 0;
    private static int leftInc = 0;

    private java.util.Timer time = new Timer();
    public BackgroundPanel(){
        xCord = 50;
        yCord = 50;

        x = getRandom('x');
        y = getRandom('y');

        setBackground(Color.white);




        this.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {


                if(gameTime == 0){start();}

                int keyID = e.getKeyCode();

                if (keyID == KeyEvent.VK_UP) {
                    clearMovements();
                    upInc = inc;

                } else if (keyID == KeyEvent.VK_DOWN ) {

                    clearMovements();
                    downInc = inc;


                } else if (keyID == KeyEvent.VK_RIGHT) {


                    clearMovements();
                    rightInc = inc;




                }
                else if (keyID == KeyEvent.VK_LEFT ) {


                    clearMovements();
                    leftInc = inc;


                }
                else if(keyID == KeyEvent.VK_SPACE){
                    clearMovements();

                }
                repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {



            } });


    }



    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.black);
        g2.fillRect(xCord,yCord,boxSize,boxSize);

        g2.setColor(Color.yellow);
        Random rand = new Random();

        g2.fillRect(x,y,boxSize,boxSize);

        g2.setColor(Color.black);
        for(int i = 0; i < getWidth(); i+= boxSize ){
            g2.drawLine(0,i,getWidth(),i);
            g2.drawLine(i,0,i,getHeight());
       }
        g2.drawString(Integer.toString(gameTime), 50,50);
        //g2.drawString(Integer.toString(yCord), 100,50);

    }

    private TimerTask task = new TimerTask() {
        @Override
        public void run() {

            xCord+=rightInc;
            yCord-=upInc;
            yCord+=downInc;
            xCord-=leftInc;


            if(xCord >= getWidth()){
                xCord = 0;

            }
            else if(xCord <= 0){
                xCord = getWidth();
            }
            else if(yCord > getHeight()){
                yCord = 0;
            }
            else if(yCord <= 0){
                yCord = getHeight();
            }


            removeAll();
            repaint();
            gameTime++;


        }
    };

    public void start(){time.scheduleAtFixedRate(task, 0,100); }
    private void clearMovements(){
        upInc = downInc = rightInc = leftInc = 0;

    }
    private void clearMoving(){
        rightMoving = leftMoving = upMoving = downMoving = false;
    }

    private int getRandom(char cord){
        Random rand = new Random();
        if(cord == 'x'){
            int i = rand.nextInt(100);
            return i + boxSize - (i % boxSize);
        }else{

            int j = rand.nextInt(100);
            return j + boxSize - (j % boxSize);
        }
    }
}
