import java.awt.Graphics2D;

public class Board{
    private PileCollection pc;
    private Pile drawPile;
    private static final int CARD_WIDTH = 73;
    private static final int CARD_HEIGHT = 98;
    
    public Board(){

        pc = new PileCollection(7, 625 - 896/2, 300 - CARD_HEIGHT*2);
        //need pc.shuffle
        pc.deal();
    }

    public void drawBoard(Graphics2D g2){
        pc.drawBoarders(g2);
        pc.drawCards(g2);
    }

    public PileCollection getPC(){ return pc; }

}