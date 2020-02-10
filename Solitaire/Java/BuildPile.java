import java.awt.Graphics2D;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Rectangle;

public class BuildPile extends Pile{
    
    private ArrayList<Card> faceUpCards;
    private ArrayList<Card> faceDownCards;

    public BuildPile(int xCord, int yCord){
        super(xCord, yCord);
        faceUpCards = new ArrayList<Card>();
        faceDownCards = new ArrayList<Card>();
        pileOutline = new Rectangle(xCord, yCord, CARD_WIDTH, CARD_HEIGHT);
    }


    public void addCard(Card c){
        if(c.getFaceUp()){
            faceUpCards.add(c);
        }else{
            faceDownCards.add(c);
        }
    }
    public void updateRect(){
        Rectangle r = new Rectangle(xCord, yCord, CARD_WIDTH, getPileLength());
        pileOutline.setRect(r);
    }
    //Returns just the number of face up cards
    public int getNumFaceUpCards(){ return faceUpCards.size(); }
    public Card getTopCard(){
        return faceUpCards.get(0);
    }
    public Card getBottomCard(){
        return faceUpCards.get(faceUpCards.size() -1);
    }
    //Returns the total number of cards in the pile, both face up and face down
    public int getNumCards(){ return faceDownCards.size() + faceUpCards.size(); }
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
    public BuildPile getSubPile(int subPileIndex){
        BuildPile p = new BuildPile(xCord, yCord);
        int pileSize = faceUpCards.size();
        for(Card c: faceUpCards.subList(subPileIndex, faceUpCards.size())){
            p.addCard(c);
        }
        for(int i = pileSize -1; i >= subPileIndex; i--){
            faceUpCards.remove(i);
        }
        return p;
    }
    public void clear(){
        for(int i = faceUpCards.size() -1; i >= 0; i--){
            faceUpCards.remove(i);
        }
    }
    public void append(BuildPile p){
        for(Card c: p.faceUpCards){
            c.setXCord(xCord);
            c.setYCord(yCord + getNumFaceUpCards() * PILE_Y_BUFFER);
            this.faceUpCards.add(c);
            this.updateRect();
        }
        p.clear();
    }
    public void append(Card c){
        c.setXCord(xCord);
        c.setYCord(yCord + getNumFaceUpCards() * PILE_Y_BUFFER);
        this.faceUpCards.add(c);
        this.updateRect();
    }
    public void popFaceDownCard(){
        if(faceUpCards.size() == 0 && faceDownCards.size() > 0){
            faceUpCards.add(faceDownCards.remove(faceDownCards.size() - 1));
            faceUpCards.get(0).flip();
        }
    }
    public void drawCards(Graphics2D g2){
        for(int j = 0; j < faceDownCards.size(); j++){
            faceDownCards.get(j).drawCard(g2);
        }
        for(int i = 0; i < faceUpCards.size(); i++){
            faceUpCards.get(i).drawCard(g2);
        }
    }
    public int getNumFaceDownCards(){ return faceDownCards.size(); }
    public String toString(){
        String ret = "";
        for(int i = 0; i < faceUpCards.size(); i++){
            ret = ret + faceUpCards.get(i) + "\n";
        }
        return ret;
    }
}