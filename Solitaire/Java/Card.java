import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

public class Card{
    private String suit;
    private int val;
    private BufferedImage img;
    private int xCord;
    private int yCord;
    private static final int CARD_WIDTH = 73;
    private static final int CARD_HEIGHT = 98;
    
    public Card(){};

    public Card(String suit, int val, int xCord, int yCord, BufferedImage img){
        this.suit = suit;
        this.val = val;
        this.img = img;
        this.xCord = xCord;
        this.yCord = yCord;
    }

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
    public BufferedImage getImg(){
        return img;
    }

    public String toString(){
        return this.val + " of " + this.suit;
    }

}