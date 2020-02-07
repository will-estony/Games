import java.awt.Graphics2D;

public abstract class PileCollection{
    
    protected static final int CARD_WIDTH = 73;
    protected static final int PILE_X_BUFFER = 50;
    protected int startX;
    protected int startY;
    protected static Deck d;
    protected int pileClicked;

    protected Pile[] collection;

    public PileCollection(int numPiles, int startX, int startY){
        
        this.startX = startX;
        this.startY = startY;
        collection = new Pile[numPiles];
        d = new Deck();
        pileClicked = -1;
    }

    public abstract int clicked(int x, int y);

    public void drawBorders(Graphics2D g2){
        for(int i = 0; i < collection.length; i++){
            collection[i].drawBorder(g2);
        }
    }
    
    public void drawCards(Graphics2D g2){
        for(int i = 0; i < collection.length; i++){
            collection[i].drawCards(g2);
        }
    }
    public int getPileClicked(){ return pileClicked; }
    public void setPileClicked(int p) {pileClicked = p; }
}