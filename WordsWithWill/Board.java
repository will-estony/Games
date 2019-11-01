/**
 * Need to get the height and width from main menu
 */

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;

public class Board extends JPanel implements MouseListener, MouseMotionListener {

    private static final int titleBarPad = 22;
    private static final int topPad = 100;
    private static final int bottomPad = 150;
    private int width;
    private int height;
    private double boardSquareHeight;
    private double boardSquareWidth;
    private double rackTileHeight;
    private double rackTileWidth;
    private static final int TILES_IN_RACK = 7;
    private static final double RACK_TILE_PAD = 5.0;
    private static final int COLS = 15;
    private static final int ROWS = 15;
    private static final String blank = "X";
    private static final BoardValues boardValues = new BoardValues();
    private Game game;
    private Frame frame;
    private int tileClicked;

    public Board(Frame frame, Game game, int width, int height){

        this.width = width;
        this.height = height-topPad-bottomPad-titleBarPad;
        this.rackTileWidth = (double)(this.width)/(double)(TILES_IN_RACK) - RACK_TILE_PAD;
        this.boardSquareWidth = (double)(this.height)/(double)COLS;
        this.boardSquareHeight = (double)(width)/(double)ROWS;
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.game = game;
        this.frame = frame;
        tileClicked = -1;
        frame.setResizable(false);

    }

    protected void paintComponent(Graphics g) {

        BoardValues.populateColorTable();
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        this.setBackground(new Color(237,236,233));

        g2.setColor(new Color(67,122,199));

        //Draw blue region on top
        Rectangle2D yourSquare = new Rectangle2D.Double(0,0, width/2, topPad);
        g2.fill(yourSquare);

        //Draw blue rectangle on the bottom third tier of the frame
        g2.fillRect(0, height + topPad, width, bottomPad + titleBarPad);

        //Draw rectangle to separate player's scores in top region
        g2.setColor(new Color(57,104,170));

        Rectangle2D opponentSquare = new Rectangle2D.Double(width/2, 0, width/2 , topPad);
        g2.fill(opponentSquare);

        g2.setColor(new Color(251,248,247));
        g2.setFont(new Font("HelveticaNeue", Font.BOLD, (int) boardSquareHeight /2));
        FontMetrics fm = g.getFontMetrics();

        String player1Info = game.getPlayer1().getUsername() + ": " + game.getPlayer1().getScore();
        String player2Info = game.getPlayer2().getUsername() + ": " + game.getPlayer2().getScore();
        g2.drawString(player1Info,width/4 - fm.stringWidth(player1Info)/2,topPad/2);
        g2.drawString(player2Info, (3*width)/4 - fm.stringWidth(player2Info)/2, topPad/2);

        for (int i = 0; i < ROWS; i++) {

            for (int j = 0; j < COLS; j++) {

                if(!boardValues.getBoardValue(i, j).equals(blank)) {
                    g2.setColor(BoardValues.getColorValue(boardValues.getBoardValue(i,j)));
                    Rectangle2D valueTile = new Rectangle2D.Double((double)i* boardSquareHeight, (double)j* boardSquareWidth + topPad, boardSquareHeight, boardSquareWidth);
                    g2.fill(valueTile);

                }
            }
        }

        drawGridLines(g2);

        if(tileClicked != -1){
            game.getPlayer1().drawTileBorder(g2, tileClicked);
        }

        for (int i = 0; i < ROWS; i++) {

            for (int j = 0; j < COLS; j++) {
                //Draw the letters indicating if a tile has a special value like Double Letter or Triple Word
                if (!boardValues.getBoardValue(i, j).equals(blank) && !boardValues.getBoardValue(i, j).equals("Star")) {
                    String tileLabel = boardValues.getBoardValue(i,j);
                    FontMetrics fontMetrics = g2.getFontMetrics();
                    Rectangle2D rect = fontMetrics.getStringBounds(tileLabel, g2);
                    double x = (i * boardSquareHeight) + (boardSquareHeight - (float) rect.getWidth()) / 2;
                    double y = (j * boardSquareWidth) + (boardSquareWidth - (float) rect.getHeight()) / 2 + topPad + fontMetrics.getAscent();

                    g2.setColor(new Color(251,248,247));
                    g2.drawString(tileLabel, (float)x, (float)y);
                }
            }
        }
        game.getPlayer1().drawRack(g2,rackTileWidth,game,height);
    }

    public void update(int width, int height){
        this.width = width;
        this.height = height-topPad-bottomPad-titleBarPad;
        this.boardSquareHeight = (double)width/(double)ROWS;
        this.boardSquareWidth = (double)(this.height)/(double)COLS;
    }

    private void drawGridLines(Graphics2D g2){
        g2.setColor(Color.white);

        for(int i = 0; i <= ROWS; i++){

            Rectangle2D vertical = new Rectangle2D.Double(i * boardSquareHeight, topPad, 2.5, (double) height);
            g2.fill(vertical);
        }
        for(int j = 0; j <= COLS; j++){

            Rectangle2D horizontal = new Rectangle2D.Double(0.0, j * boardSquareWidth + topPad, (double) width, 2.5);
            g2.fill(horizontal);
        }
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {


    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseClicked(MouseEvent e) {
        for(int i = 0; i < TILES_IN_RACK; i++){
            if(game.getPlayer1().getTile(i).getRect().contains(e.getX(), e.getY())){
                System.out.println("Tile " + (i + 1) + " clicked");
                tileClicked = i;
                repaint();
                return;
            }
        }
        tileClicked = -1;
        repaint();
    }

    public void mouseDragged(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {
    }

    public void printBoardValues(){
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                System.out.println(boardValues.getBoardValue(i,j));
            }
        }
    }

    public void printBoxCoordinates(){
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
               System.out.println(i* boardSquareWidth + ":" + j* boardSquareHeight);
            }
        }
    }
}
