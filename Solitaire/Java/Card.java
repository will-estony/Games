import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Card{
    private String suit;
    private int val;
    private BufferedImage img;
    private int xCord;
    private int yCord;
    private Rectangle rect;
    private boolean faceUp;
    private static final int CARD_WIDTH = 73;
    private static final int CARD_HEIGHT = 98;
    
    public Card(){};

    public Card(boolean faceUp, String suit, int val, int xCord, int yCord, BufferedImage img){
        this.faceUp = faceUp;
        this.suit = suit;
        this.val = val;
        this.img = img;
        this.xCord = xCord;
        this.yCord = yCord;
        rect = new Rectangle(xCord, yCord, CARD_HEIGHT, CARD_WIDTH);
    }

    public boolean getFaceUp(){ return faceUp; }
    public int getXCord(){ return xCord; }
    public int getYCord(){ return yCord; }
    public void setYCord(int y){
        yCord = y;
    }
    public void setXCord(int x){
        xCord = x;
    }
    public void drawCard(Graphics2D g2){
        g2.drawImage(this.img,this.xCord,this.yCord, CARD_WIDTH, CARD_HEIGHT,null);
    }
    public boolean cardClicked(int xCord, int yCord){
        if(rect.contains(xCord, yCord)){
            return true;
        }else{
            return false;
        }
    }
    public void flip(){ faceUp = true; }

    public BufferedImage getImg(){
        return img;
    }

    public String toString(){
        return this.val + " of " + this.suit;
    }

}