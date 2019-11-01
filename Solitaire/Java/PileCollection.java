import java.awt.Graphics2D;

public class PileCollection{

    private static final int CARD_WIDTH = 73;
    private static final int CARD_HEIGHT = 98;
    private int startX;
    private int startY;
    private Pile[] collection;
    private Deck d;

    public PileCollection(int numPiles, int startX, int startY){
        
        this.startX = startX;
        this.startY = startY;

        collection = new Pile[numPiles];
        populatePiles();
        d = new Deck();
        
    }
    public void drawBoarders(Graphics2D g2){
        for(int i = 0; i < collection.length; i++){
            collection[i].drawBoarder(g2);
        }
    }
    public int clicked(int xCord, int yCord){
        for(int i = 0; i < collection.length; i++){
            if(collection[i].pileClicked(xCord, yCord)){
                return i + 1;
            }
        }
        return 0;
    }
    public void drawCards(Graphics2D g2){
        for(int i = 0; i < collection.length; i++){
            collection[i].drawCards(g2);
        }
    }
    private void populatePiles(){
        for(int i = 0; i < collection.length; i++){
            int x = startX + (i * (CARD_WIDTH + 50));
            Pile p = new Pile(x,startY);
            collection[i] = p;
        }
    }
    public void deal(){
        int a = 0;
        for(int i = 0; i < collection.length; i++){
            for(int j = i; j < collection.length; j++){
                int x = startX + (j * (CARD_WIDTH + 50));
                int y = startY + (i * 15);

                Card c = d.popTopCard();
                c.setXCord(x);
                c.setYCord(y);

                collection[j].addCard(c);
            }
        }
    }
    public String getPile(int i){
        return collection[i].toString();
    }
}