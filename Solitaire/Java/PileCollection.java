import java.awt.Graphics2D;

public class PileCollection{

    private static final int CARD_WIDTH = 73;
    private static final int CARD_HEIGHT = 98;
    private static final int PILE_Y_BUFFER = 25;
    private static final int PILE_X_BUFFER = 50;
    private int startX;
    private int startY;
    private Pile[] collection;
    private Deck d;
    private int pileClicked;

    public PileCollection(int numPiles, int startX, int startY){
        pileClicked = -1;
        this.startX = startX;
        this.startY = startY;
        collection = new Pile[numPiles];
        populatePiles();
        d = new Deck();
        
    }

    public int getStartY(){ return startY; }
    public void drawBoarders(Graphics2D g2){
        for(int i = 0; i < collection.length; i++){
            collection[i].drawBoarder(g2);
        }
    }
    public int clicked(int xCord, int yCord){
        for(int i = 0; i < collection.length; i++){
            if(collection[i].pileClicked(xCord, yCord) && collection[i].getNumFaceUpCards() > 0){
                return i;
            }
        }
        return -1;
    }

    //The only difference between this method and clicked, is clicked requires at least 
    //one card to be in the pile so as to avoid an index out of bounds error
    //A card can be released on even an empty pile.
    public int released(int xCord, int yCord){
        for(int i = 0; i < collection.length; i++){
            if(collection[i].pileClicked(xCord, yCord)){
                return i;
            }
        }
        return -1;
    }
    public void drawCards(Graphics2D g2){
        for(int i = 0; i < collection.length; i++){
            collection[i].drawCards(g2);
        }
    }
    private void populatePiles(){
        for(int i = 0; i < collection.length; i++){
            int x = startX + (i * (CARD_WIDTH + PILE_X_BUFFER));
            Pile p = new Pile(x,startY);
            collection[i] = p;
        }
    }
    public void deal(){
        for(int i = 0; i < collection.length; i++){
            int x = startX + (i * (CARD_WIDTH + PILE_X_BUFFER));
            Card c = d.popTopCard();
            c.setXCord(x);
            c.setYCord(startY);
            c.flip();
            collection[i].addFaceUpCard(c);

            for(int j = i + 1; j < collection.length; j++){
                x = startX + (j * (CARD_WIDTH + PILE_X_BUFFER));
                c = d.popTopCard();
                c.setXCord(x);
                c.setYCord(startY);
                collection[j].addFaceDownCard(c);
            }
        }
    }
    public int getPileClicked(){ return pileClicked; }
    public void setPileClicked(int p) {pileClicked = p; }
    public Pile getPile(int i){ return collection[i];}
    public void printPileCounts(){
        int i = 1;
        for(Pile p: collection){
            System.out.println("Pile " + i + ": " + p.getNumCards());
            i++;
        }
    }
}