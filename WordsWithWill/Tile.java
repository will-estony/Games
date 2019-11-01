import java.awt.geom.RoundRectangle2D;

/**
 * @author Will Estony
 * @version 0.0.1
 *
 * Class to model a Tile object
 *
 */

public class Tile {

    private char c;
    private int pointValue;
    private RoundRectangle2D.Double rect;

    public Tile(char c, int pointValue){
        this.c = c;
        this.pointValue = pointValue;
    }

    public char getC(){ return c; }
    public int getPointValue(){ return pointValue; }

    public void setRect(RoundRectangle2D.Double rect){
        this.rect = rect;
    }

    public RoundRectangle2D.Double getRect(){ return rect; }

    public String toString(){
        return "Character: " + c + "\nPoint Value: " + pointValue + "\n";
    }

}
