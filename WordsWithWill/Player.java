import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

/**
 * @author Will Estony
 * @version 0.0.1
 *
 * Class to model a Player object
 */

public class Player {

    private String username; //The username of the player represented as a String. Ex. westony
    private int score; //The player's score represented as an integer. Ex. 69
    private Tile[] rack;
    private static final short MAX_TILES_ON_RACK = 7;
    private short numTilesOnRack;
    private static final int titleBarPad = 22;
    private static final int bottomPad = 150;
    private static final int topPad = 100;
    private static final int TILES_IN_RACK = 7;
    private static final double RACK_TILE_PAD = 5.0;

    public Player(String username){
        numTilesOnRack = 0;
        rack = new Tile[MAX_TILES_ON_RACK];
        this.username = username;
        this.score = 0;
    }

    public void updateScore(int points){ this.score+=points; }
    public int getScore(){ return score; }
    public String getUsername(){ return username; }
    public short getNumTilesOnRack(){ return numTilesOnRack; }

    public void pick(Tile t){
        if(numTilesOnRack < MAX_TILES_ON_RACK){
            rack[numTilesOnRack] = t;
            numTilesOnRack++;
        }
    }

    public Tile getTile(int i){ return rack[i]; }
    public void drawRack(Graphics2D g2, double rackTileWidth, Game game, double height){
        for(short i = 0; i < TILES_IN_RACK; i++){
            g2.setColor(new Color(240,211,89));
            RoundRectangle2D.Double tile = new RoundRectangle2D.Double((RACK_TILE_PAD/2 + i * (rackTileWidth + RACK_TILE_PAD)), ((titleBarPad/2 + height + topPad + bottomPad/2) - rackTileWidth/2), rackTileWidth, rackTileWidth,25.0, 25.0);
            g2.fill(tile);


            g2.setFont(new Font("HelveticaNeue", Font.BOLD, (int) rackTileWidth /2));
            g2.setColor(new Color(55,29,21));
            String tileChar = Character.toString(game.getPlayer1().getTile(i).getC());
            FontMetrics fm = g2.getFontMetrics();
            Rectangle2D rect = fm.getStringBounds(tileChar, g2);

            double x = RACK_TILE_PAD/2 + (i * (rackTileWidth + RACK_TILE_PAD)) + (rackTileWidth - (float) rect.getWidth()) / 2;
            double y = (titleBarPad/2 + height + topPad + bottomPad/2) - rackTileWidth/2 + (rackTileWidth - (float) rect.getHeight()) / 2 + fm.getAscent();


            g2.drawString(tileChar,(float)x,(float)y);

            g2.setFont(new Font("HelveticaNeue", Font.BOLD, (int) rackTileWidth /4));
            String tileVal = Integer.toString(game.getPlayer1().getTile(i).getPointValue());
            fm = g2.getFontMetrics();
            rect = fm.getStringBounds(tileVal, g2);
            x = RACK_TILE_PAD/2 + (i * (rackTileWidth + RACK_TILE_PAD)) + rackTileWidth - RACK_TILE_PAD - rect.getWidth();
            y = (titleBarPad/2 + height + topPad + bottomPad/2) - rackTileWidth/2 + fm.getAscent();
            g2.drawString(tileVal, (float)x , (float)y);
            getTile(i).setRect(tile);
        }
    }

    public void drawTileBorder(Graphics2D g2, int i){

    }


    public void printRack(){
        System.out.print(username + "'s tiles:");
        for(int i = 0; i < numTilesOnRack; i++){
            System.out.print("|" + rack[i].getC() + "|");
        }
        System.out.println();
    }
}
