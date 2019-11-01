import java.awt.event.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel{

    private int yPAD = 120;
    private int xPAD = 65;
    private int sideLen = 352;
    private int height = 352;
    private int width = 352;
    private int topMenuBarStart = 32;
    private int bottomMenuBarStart = 510;
    private int menuBarHeight = 50;
    private static int tileLen = 88;
    private static int borderThickness = 3;
    private SpringLayout layout;
    private static TwentyFortyEight game;
    private String blank = "X";
    private int boarderLen = 2;
    private java.util.Timer time = new Timer();

    private Date date;

    private static Button pause;
    private Button menu;
    private Button quit;

    private LoseFrame loseFrame;
    private QuitFrame quitFrame;


    private TimerTask task = new TimerTask() {
        @Override
        public void run() {
            if(game.getRunClock()){
            game.incrementSecondsPassed();
            repaint();
            }
        }
    };

    public static int getTileLen(){
        return tileLen;
    }

    public static int getBorderThickness(){
        return borderThickness;
    }

    public GamePanel(){

        date = new Date();
        layout = new SpringLayout();
        game = new TwentyFortyEight();

        pause = new Button("Pause", tileLen, menuBarHeight);
        menu = new Button("Menu", tileLen, menuBarHeight);
        quit = new Button("Quit", tileLen, menuBarHeight);

        setBackground(new Color(225,225,225));
        setLayout(layout);

        TwentyFortyEight.populateColorTable();


        /*
        The following three sections align the three buttons on the game panel in the lower octant of the panel
         */

        layout.putConstraint(SpringLayout.WEST, menu, Main.getFrame().getWidth()/2 - tileLen - tileLen/2, SpringLayout.WEST, Main.getFrame().getContentPane());
        layout.putConstraint(SpringLayout.NORTH, menu, bottomMenuBarStart, SpringLayout.NORTH,Main.getFrame().getContentPane());

        layout.putConstraint(SpringLayout.WEST, pause, tileLen-borderThickness, SpringLayout.WEST, menu);
        layout.putConstraint(SpringLayout.NORTH, pause, bottomMenuBarStart, SpringLayout.NORTH,Main.getFrame().getContentPane());

        layout.putConstraint(SpringLayout.WEST, quit, tileLen - borderThickness, SpringLayout.WEST,pause);
        layout.putConstraint(SpringLayout.NORTH,quit, bottomMenuBarStart, SpringLayout.NORTH, Main.getFrame().getContentPane());

        add(pause);
        add(menu);
        add(quit);

        pause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.Pause();
                if(game.getRunClock()){
                    pause.setText("Pause");
                }else{
                    pause.setText("Play");
                }
                repaint();

            }
        });

        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TwentyFortyEight.setResumeGame(true);
                GamePanel.getGame().setRunClock(false);
                Main.getFrame().getContentPane().removeAll();
                Main.getFrame().repaint();
                Main.getFrame().getContentPane().add(Main.getMenuPanel());
                Main.getFrame().repaint();
                Main.getFrame().revalidate();
                Main.getMenuPanel().requestFocus();

            }
        });

        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.Pause();
                quitFrame = new QuitFrame();
                quitFrame.setVisible(true);

                quitFrame.addWindowListener(new WindowListener() {
                    @Override
                    public void windowOpened(WindowEvent e) {

                    }

                    @Override
                    public void windowClosing(WindowEvent e) {

                    }

                    @Override
                    public void windowClosed(WindowEvent e) {
                        game.Pause();
                    }

                    @Override
                    public void windowIconified(WindowEvent e) {

                    }

                    @Override
                    public void windowDeiconified(WindowEvent e) {

                    }

                    @Override
                    public void windowActivated(WindowEvent e) {

                    }

                    @Override
                    public void windowDeactivated(WindowEvent e) {

                    }
                });

                quitFrame.getYes().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        TwentyFortyEight.setResumeGame(false);
                        EnterNameFrame enterNameFrame = new EnterNameFrame();

                        enterNameFrame.addWindowListener(new WindowListener() {
                            @Override
                            public void windowOpened(WindowEvent e) {

                            }

                            @Override
                            public void windowClosing(WindowEvent e) {

                            }

                            @Override
                            public void windowClosed(WindowEvent e) {
                                TwentyFortyEight.setResumeGame(true);
                            }

                            @Override
                            public void windowIconified(WindowEvent e) {

                            }

                            @Override
                            public void windowDeiconified(WindowEvent e) {

                            }

                            @Override
                            public void windowActivated(WindowEvent e) {

                            }

                            @Override
                            public void windowDeactivated(WindowEvent e) {

                            }
                        });

                        enterNameFrame.setVisible(true);
                        enterNameFrame.getCancel().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                enterNameFrame.setVisible(false);
                            }

                        });
                        enterNameFrame.getEnter().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String name = enterNameFrame.getInput().getText();
                                MenuPanel.getLbi().updateLeaderBoardInfo(name, TwentyFortyEight.getScore(),game.getSecondsPassed(), date.toString());

                                TwentyFortyEight.setResumeGame(false);
                                MenuPanel menuPanel = new MenuPanel();
                                enterNameFrame.setVisible(false);
                                enterNameFrame.dispose();
                                quitFrame.setVisible(false);
                                quitFrame.dispose();
                                Main.getFrame().getContentPane().removeAll();
                                Main.getFrame().repaint();
                                Main.getFrame().getContentPane().add(menuPanel);
                                Main.getFrame().repaint();
                                Main.getFrame().revalidate();
                                Main.getMenuPanel().requestFocus();
                            }
                        });
                    }
                });

                quitFrame.getNo().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        quitFrame.setVisible(false);
                        game.Pause();
                    }
                });

                quitFrame.getCancel().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        quitFrame.setVisible(false);
                        game.Pause();
                    }
                });
            }
        });

        /**
         *              Key Listener
         */
        this.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {

                    int keyID = e.getKeyCode();

                    if (keyID == KeyEvent.VK_UP && game.getRunClock()) {

                        game.moveTilesUp();

                    } else if (keyID == KeyEvent.VK_DOWN && game.getRunClock()) {
                        game.moveTilesDown();

                    } else if (keyID == KeyEvent.VK_RIGHT && game.getRunClock()) {
                        game.moveTilesRight();

                    } else if (keyID == KeyEvent.VK_LEFT && game.getRunClock()) {

                        game.moveTilesLeft();

                    }
                    repaint();
                }

            @Override
            public void keyReleased(KeyEvent e) {
                game.resetCombinable();
                if(game.getValidMove() && game.getRunClock()) {
                    game.placeNewTile();
                    try {
                        Thread.sleep(150);
                    } catch (InterruptedException ex) {

                    }
                    repaint();
                }


                if(game.checkLoss()){
                    TwentyFortyEight.setResumeGame(false);
                    loseFrame = new LoseFrame();
                    loseFrame.setVisible(true);
                    //loseFrame.get
                    loseFrame.getMainMenu().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            String name = loseFrame.getInput().getText();
                            MenuPanel.getLbi().updateLeaderBoardInfo(name, TwentyFortyEight.getScore(),game.getSecondsPassed(), date.toString());
                            loseFrame.setVisible(false);
                            loseFrame.dispose();
                        }
                    });

                    loseFrame.getNewGame().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            String name = loseFrame.getInput().getText();
                            MenuPanel.getLbi().updateLeaderBoardInfo(name, TwentyFortyEight.getScore(),game.getSecondsPassed(), date.toString());
                            loseFrame.setVisible(false);
                            loseFrame.dispose();

                        }
                    });

                    loseFrame.getQuit().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            String name = loseFrame.getInput().getText();
                            MenuPanel.getLbi().updateLeaderBoardInfo(name, TwentyFortyEight.getScore(),game.getSecondsPassed(), date.toString());
                            loseFrame.setVisible(false);
                            loseFrame.dispose();
                        }
                    });
                }
            }
        });
    }

    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(100, 100, 100));
        g2.fillRect(xPAD, yPAD, width, height);
        g2.setColor(Color.black);
        g2.setStroke(new BasicStroke(borderThickness));

        /*
        The following two loops draw the rows and columns on the game panel to create squares for our tiles to sit in
         */

        for (int col = 0; col <= 4; col++) {

            g2.drawLine(xPAD + col * tileLen, yPAD, xPAD + col * tileLen, yPAD + sideLen);
        }

        for (int row = 0; row <= 4; row++) {

            g2.drawLine(xPAD, yPAD + row * tileLen, xPAD + sideLen, yPAD + row * tileLen);
        }

        g2.setColor(new Color(100,100,100));

        g2.fillRect(0, bottomMenuBarStart, Main.getFrame().getWidth(), menuBarHeight);
        g2.fillRect(0, topMenuBarStart, Main.getFrame().getWidth(), menuBarHeight);

        g2.setColor(Color.black);

        g2.drawLine(0, topMenuBarStart + 1, Main.getFrame().getWidth(), topMenuBarStart + 1);
        g2.drawLine(0, topMenuBarStart + menuBarHeight - 1, Main.getFrame().getWidth(), topMenuBarStart + menuBarHeight - 1);

        g2.drawLine(0, bottomMenuBarStart + 1, Main.getFrame().getWidth(), bottomMenuBarStart + 1);
        g2.drawLine(0, bottomMenuBarStart + menuBarHeight - 1, Main.getFrame().getWidth(), bottomMenuBarStart + menuBarHeight - 1);


        g2.setColor(new Color(225,225,225));
        g2.setFont(new Font("Lucinda", Font.BOLD, 13));
        g2.drawString("Score: " + game.getScore(), xPAD + tileLen/2,60);
        g2.drawString("Time: " + game.getSecondsPassed(), xPAD + 2 * tileLen + tileLen/2, 60);

        g2.setColor(Color.black);

        for (int i = 0; i < game.getNumRows(); i++) {

            for (int j = 0; j < game.getNumCols(); j++) {

                if (!game.getValue(i, j).equals(blank)) {


                    g2.setColor(TwentyFortyEight.getColorValue(game.getValue(i,j)));
                    g2.fillRect(j * tileLen + xPAD + 2, i * tileLen + yPAD + boarderLen, tileLen - boarderLen*2, tileLen -boarderLen * 2);
                    g2.setColor(Color.black);

                    if(game.getNumDigits(i,j) == 1) {
                        g2.setFont(new Font("Serif", Font.BOLD, 32));
                        g2.drawString(game.getValue(i, j), (j * tileLen + xPAD) + tileLen / 2 - 9, (i * tileLen + yPAD) + tileLen / 2 +13);
                    }
                    else if(game.getNumDigits(i,j) == 2) {

                        g2.setFont(new Font("Serif", Font.BOLD, 32) );
                        g2.drawString(game.getValue(i, j), (j * tileLen + xPAD) + tileLen / 2 - 15, (i * tileLen + yPAD) + tileLen / 2 +10);
                    }
                    else if(game.getNumDigits(i,j) == 3) {

                        g2.setFont(new Font("Serif", Font.BOLD, 30) );
                        g2.drawString(game.getValue(i, j), (j * tileLen + xPAD) + tileLen / 2 - 22, (i * tileLen + yPAD) + tileLen / 2 + 10);
                    }

                    else if(game.getNumDigits(i,j) == 4) {

                        g2.setFont(new Font("Serif", Font.BOLD, 24) );
                        g2.drawString(game.getValue(i, j), (j * tileLen + xPAD) + tileLen / 2 - 23, (i * tileLen + yPAD) + tileLen / 2 + 10);
                    }
                    else if(game.getNumDigits(i,j) == 5) {

                        g2.setFont(new Font("Serif", Font.BOLD, 24) );
                        g2.drawString(game.getValue(i, j), (j * tileLen + xPAD) + tileLen / 2 - 28, (i * tileLen + yPAD) + tileLen / 2 +10);
                        g2.setColor(Color.black);
                    }
                }
            }
        }
    }

    public void start(){

        time.scheduleAtFixedRate(task, 1000,1000);
    }

    public static TwentyFortyEight getGame(){
        return game;
    }

    public static Button getPause(){

        return pause;
    }
}
