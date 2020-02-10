import java.awt.Graphics2D;

public class Board{
    private BuildPileCollection buildPiles;
    private AcePileCollection acePiles;
    private DrawPileCollection drawPiles;
    private static final int CARD_HEIGHT = 98;
    
    public Board(){

        buildPiles = new BuildPileCollection(625 - 896/2, 400 - CARD_HEIGHT*2);
        acePiles = new AcePileCollection((625 - 896/2) + 220, 50);
        drawPiles = new DrawPileCollection((625 - 896/2) + 343, 650);
        buildPiles.deal();
        drawPiles.deal();
    }

    public void drawBoard(Graphics2D g2){
        buildPiles.drawBorders(g2);
        buildPiles.drawCards(g2);

        acePiles.drawBorders(g2);
        
        drawPiles.drawBorders(g2);
        drawPiles.drawCards(g2);
    }

    public BuildPileCollection getBuildPiles(){ return buildPiles; }
    public DrawPileCollection getDrawPile(){ return drawPiles; }
    public AcePileCollection getAcePiles(){ return acePiles; }

}