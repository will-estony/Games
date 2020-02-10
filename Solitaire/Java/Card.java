import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;

public class Card{
    private String suit;
    private int val;
    private BufferedImage face;
    private static BufferedImage back;
    private int xCord;
    private int yCord;
    private Rectangle rect;
    private boolean faceUp;
    private static final int CARD_WIDTH = 73;
    private static final int CARD_HEIGHT = 98;
    
    public Card(){};

    public Card(boolean faceUp, String suit, int val, int xCord, int yCord, BufferedImage face){
        this.faceUp = faceUp;
        this.suit = suit;
        this.val = val;
        this.face = face;
        this.xCord = xCord;
        this.yCord = yCord;
        this.back = loadBackImage();
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
        if(faceUp){
            g2.drawImage(this.face,this.xCord,this.yCord, CARD_WIDTH, CARD_HEIGHT,null);
        }else{
            g2.drawImage(this.back,this.xCord,this.yCord, CARD_WIDTH, CARD_HEIGHT,null);
        }
    }
    public boolean cardClicked(int xCord, int yCord){
        if(rect.contains(xCord, yCord)){
            return true;
        }else{
            return false;
        }
    }

    private BufferedImage loadBackImage(){
        try{
            return ImageIO.read(new File("cardBacking.jpg"));
        }catch(IOException e){}
        return null;
    }

    public void flip(){ 
        if(!faceUp){
            faceUp = true; 
        }else{
            faceUp = false;
        }
    }

    public BufferedImage getImg(){
        return face;
    }

    public int getVal(){ return val;}
    public String getSuit(){ return suit; }
    public String getColor(){
        if(this.suit.equals("Clubs") || this.suit.equals("Spades")){
            return "black";
        }else{
            return "red";
        }
    }
    public String toString(){
        return this.val + " of " + this.suit;
    }

}