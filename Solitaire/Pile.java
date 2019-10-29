import java.awt.Graphics2D;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.BasicStroke;
import java.awt.Rectangle;
public class Pile{
    
    private ArrayList<Card> pile;
    private int xCord;
    private int yCord;
    private Rectangle rect;
    private static final int CARD_WIDTH = 73;
    private static final int CARD_HEIGHT = 98;

    public Pile(int xCord, int yCord){
        this.xCord = xCord;
        this.yCord = yCord;
        pile = new ArrayList<Card>();
        rect = new Rectangle(xCord, yCord, CARD_WIDTH, CARD_HEIGHT);
    }
    public void addCard(Card c){
        pile.add(c);
    }

    public void drawBoarder(Graphics2D g2){
        g2.setColor(Color.black);
        g2.setStroke(new BasicStroke(5));
        g2.draw(rect);
    }

    public boolean pileClicked(int xCord, int yCord){
        if(rect.contains(xCord, yCord)){ 
            return true;
        }else{
            return false;
        }
    }
    public int getXCord(){ return xCord; }
    public int getYCord(){ return yCord; }

    public void drawCards(Graphics2D g2){
        for(int i = 0; i < pile.size(); i++){
            pile.get(i).drawCard(g2);
        }
    }
    public String toString(){
        String ret = "";
        for(int i = 0; i < pile.size(); i++){
            ret = ret + pile.get(i) + "\n";
        }
        return ret;
    }
}