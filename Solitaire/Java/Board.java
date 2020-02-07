import java.awt.Graphics2D;

public class Board{
    private BuildPileCollection buildPiles;
    private AcePileCollection aceSlots;
    private DrawPileCollection drawPile;
    private static final int CARD_WIDTH = 73;
    private static final int CARD_HEIGHT = 98;
    
    public Board(){

        buildPiles = new BuildPileCollection(625 - 896/2, 400 - CARD_HEIGHT*2);
        aceSlots = new AcePileCollection((625 - 896/2) + 220, 50);
        drawPile = new DrawPileCollection((625 - 896/2) + 343, 650);
        //need pc.shuffle
        buildPiles.deal();
        drawPile.deal();
    }

    public void drawBoard(Graphics2D g2){
        buildPiles.drawBorders(g2);
        buildPiles.drawCards(g2);

        //aceSlots.drawBorders(g2);
        drawPile.drawBorders(g2);
        drawPile.drawCards(g2);
    }

    public BuildPileCollection getBuildPiles(){ return buildPiles; }
    public DrawPileCollection getDrawPile(){ return drawPile; }

}