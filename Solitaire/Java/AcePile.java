import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;

public class AcePile extends Pile{

    private ArrayList<Card> cards = new ArrayList<>();
    private String suit;
    private static final String[] validSuits = {"Spades", "Clubs", "Hearts", "Diamonds"};

    public AcePile(int x, int y){
        super(x, y);
        pileOutline = new Rectangle(xCord, yCord, CARD_WIDTH, CARD_HEIGHT);
        suit = "wild";
    }
    public ArrayList<Card> getCards(){
        return cards;
    }

    public String getSuit(){ return suit; }
    public void setSuit(String suit){
        if(Arrays.asList(validSuits).contains(suit)){
            this.suit = suit;
        }
    }

    public void drawCards(Graphics2D g2){
        for(int i = 0; i < cards.size(); i++){
            cards.get(i).drawCard(g2);
        }   
    }
    public int getNumCards(){
        return cards.size();
    }
    public void addCard(Card c){
        c.setXCord(xCord);
        c.setYCord(yCord);
        cards.add(c);
    }
    public void append(Pile p){

        p.popBottomCard().setXCord(xCord);
        p.popBottomCard().setYCord(yCord);
        cards.add(p.popBottomCard());
        p.clear();
    }
    public void clear(){
        cards.clear();
    }
    public boolean pileClicked(int x, int y){
        if(pileOutline.contains(x, y)){
            return true;
        }else{
            return false;
        }
    }
    public Card popBottomCard(){
        return cards.remove(0);
    }
    public Card popTopCard(){
        return cards.remove(cards.size() - 1);
    }
    public Card getTopCard(){
        return cards.get(cards.size() - 1);
    }
}