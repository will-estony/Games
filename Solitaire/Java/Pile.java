import java.awt.Graphics2D;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.BasicStroke;
import java.awt.Rectangle;
public class Pile{
    
    private ArrayList<Card> faceUpCards;
    private ArrayList<Card> faceDownCards;
    private int xCord;
    private int yCord;
    private static final int CARD_WIDTH = 73;
    private static final int CARD_HEIGHT = 98;
    private static final int PILE_Y_BUFFER = 25;
    private Rectangle cardOutline, pileOutline;  
    private boolean isSelected;

    public Pile(int xCord, int yCord){
        this.xCord = xCord;
        this.yCord = yCord;
        faceUpCards = new ArrayList<Card>();
        faceDownCards = new ArrayList<Card>();
        pileOutline = new Rectangle(xCord, yCord, CARD_WIDTH, CARD_HEIGHT);
        cardOutline = new Rectangle(xCord, yCord, CARD_WIDTH, CARD_HEIGHT);
    }
    public void addFaceUpCard(Card c){
        faceUpCards.add(c);
    }
    public void addFaceDownCard(Card c){
        faceDownCards.add(c);
    }

    public void updateRect(){
        
        Rectangle r = new Rectangle(xCord, yCord, CARD_WIDTH, getPileLength());
        pileOutline.setRect(r);
    }

    //Returns just the number of face up cards
    public int getNumFaceUpCards(){ return faceUpCards.size(); }

    //Returns the total number of cards in the pile, both face up and face down
    public int getNumCards(){ return faceDownCards.size() + faceUpCards.size(); }

    public void drawBoarder(Graphics2D g2){
        g2.setColor(Color.black);
        g2.setStroke(new BasicStroke(5));
        g2.draw(cardOutline);
    }
    public Card getCard(int i){ return faceUpCards.get(i); }

    public boolean pileClicked(int xCord, int yCord){
        if(pileOutline.contains(xCord, yCord)){
            return true;
        }else{
            return false;
        }
    }

    private int getPileLength(){
        return CARD_HEIGHT + ((faceUpCards.size() - 1) * PILE_Y_BUFFER); //length of the entire pile
    }
    public Card checkCards(int x, int y){
        Card r = faceUpCards.get(faceUpCards.size() - 1);
        
        for(int i = faceUpCards.size() - 1 ; i >= 0; i--){
            if(faceUpCards.get(i).cardClicked(x, y)){
                r = faceUpCards.get(i); 
            }
        }
        return r;
        
    }
    public void highlight(Graphics2D g2, int subPileIndex){
        g2.setColor(Color.RED);
        g2.drawRect(xCord, yCord + (subPileIndex * 25), CARD_WIDTH, CARD_HEIGHT +  ((faceUpCards.size() - 1) - subPileIndex) * 25);

    }

    //returns the index of the highest most card selected in a pile
    public int getSubPileIndex(int y, int startY){
        for(int i = getNumFaceUpCards() - 1; i > 0; i--){
            if(y >= i * PILE_Y_BUFFER + startY){
                return i;
            }
        }
        return 0;
    }
    //returns a pile of all the cards that have been selected
    public Pile getSubPile(int subPileIndex){
        Pile p = new Pile(xCord, yCord);
        int pileSize = faceUpCards.size();
        for(Card c: faceUpCards.subList(subPileIndex, faceUpCards.size())){
            p.addFaceUpCard(c);
        }
        for(int i = pileSize -1; i >= subPileIndex; i--){
            faceUpCards.remove(i);
        }
        return p;
    }

    private void clear(){
        for(int i = faceUpCards.size() -1; i >= 0; i--){
            faceUpCards.remove(i);
        }
    }

    public void append(Pile p){
        for(Card c: p.faceUpCards){
            c.setXCord(xCord);
            c.setYCord(yCord + getNumFaceUpCards() * PILE_Y_BUFFER);
            this.faceUpCards.add(c);
            this.updateRect();
        }
        p.clear();
    }

    public void popFaceDownCard(){
        if(faceUpCards.size() == 0 && faceDownCards.size() > 0){
            faceUpCards.add(faceDownCards.remove(faceDownCards.size() - 1));
        }
    }

    public int getXCord(){ return xCord; }
    public int getYCord(){ return yCord; }
    public void drawCards(Graphics2D g2){
        
        for(int j = 0; j < faceDownCards.size(); j++){
            faceDownCards.get(j).drawCard(g2);
        }

        for(int i = 0; i < faceUpCards.size(); i++){
            faceUpCards.get(i).drawCard(g2);
        }
    }
    public String toString(){
        String ret = "";
        for(int i = 0; i < faceUpCards.size(); i++){
            ret = ret + faceUpCards.get(i) + "\n";
        }
        return ret;
    }
}