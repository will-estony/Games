import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.BasicStroke;
import java.awt.Color;

public abstract class Pile{

    protected int xCord;
    protected int yCord;

    protected static final int CARD_WIDTH = 73;
    protected static final int CARD_HEIGHT = 98;
    protected static final int PILE_Y_BUFFER = 25;
    
    protected Rectangle cardOutline;
    protected Rectangle pileOutline;

    public Pile(int xCord, int yCord){
        this.xCord = xCord;
        this.yCord = yCord;
        cardOutline = new Rectangle(xCord, yCord, CARD_WIDTH, CARD_HEIGHT);
    }
    public void drawBorder(Graphics2D g2){
        g2.setColor(Color.black);
        g2.setStroke(new BasicStroke(5));
        g2.draw(cardOutline);
    }
    public abstract void drawCards(Graphics2D g2);
    public abstract int getNumCards();
    public abstract void addCard(Card c);
    public abstract boolean pileClicked(int x, int y);
    public int getXCord(){ return xCord; }
    public int getYCord(){ return yCord; }
}