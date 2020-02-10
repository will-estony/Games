import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class DrawPile extends Pile{

    private ArrayList<Card> cards;

    public DrawPile(int x, int y){
        super(x,y);
        cards = new ArrayList<>();
        pileOutline = new Rectangle(xCord, yCord, CARD_WIDTH, CARD_HEIGHT);
    }
    public void drawCards(Graphics2D g2){
        for(Card c: cards){
            c.drawCard(g2);
        }
    }
    public int getNumCards(){
        return cards.size();
    }
    public void addCard(Card c){
        cards.add(c);
    }
    public Card getCard(int i){
        return cards.get(i);
    }
    public boolean pileClicked(int x, int y){
        if(pileOutline.contains(x, y)){
            return true;
        }else{
            return false;
        }
    }
    public void append(DrawPile p){
        for(Card c: p.cards){
            c.setXCord(xCord);
            c.setYCord(yCord);
            this.cards.add(c);
        }
        p.clear();
    }
    public void append(Card c){
        c.setXCord(xCord);
        c.setYCord(yCord);
        this.cards.add(c);
    }
    public DrawPile getSubPile(){
        DrawPile p = new DrawPile (xCord, yCord);
        int pileSize = cards.size();

        if(pileSize >= 3){
            for(int i = pileSize - 1 ; i >= pileSize - 3; i--){
                Card c = cards.get(i);
                c.flip();
                p.addCard(c);
                cards.remove(i);
            }
        }else{
            for(int i = pileSize - 1 ; i >= 0; i--){
                Card c = cards.get(i);
                c.flip();
                p.addCard(c);
                cards.remove(i);
            } 
        }
        return p;
    }
    public void clear(){
        for(int i = cards.size() -1; i >= 0; i--){
            cards.remove(i);
        }
    }
    public void removeTopCard(){
        cards.remove(cards.size() - 1);
    }
    public Card popTopCard(){
        return cards.remove(cards.size() -1);
    }
    //Flips every card in the pile
    public void flipPile(){
        for(Card c: cards){
            c.flip();
        }
    }
}