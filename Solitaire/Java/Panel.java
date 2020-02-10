import javax.swing.JPanel;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Graphics;

public class Panel extends JPanel implements MouseListener, MouseMotionListener{

    private boolean pressed;
    private Board board;
    private int buildPileSelected;
    private int drawPileSelected;
    private int acePileSelected;
    private int subPileIndex;
    private BuildPile subPile;
    private static final int PILE_Y_BUFFER = 25;
    private int startX;
    private int startY;
    private boolean flip = false;
    private boolean draw3 = false;
    private boolean playDrawCard = false;
    private boolean playAceCard = false;
    private Card drawCard;
    private Rules rules;

    public Panel(){
        board = new Board();
        buildPileSelected = -1;
        acePileSelected = -1;
        rules = new Rules();
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    protected void paintComponent(Graphics g) {
        setBackground(Color.white);
        Graphics2D g2 = (Graphics2D) g;
        board.drawBoard(g2);
        board.getBuildPiles().drawCards(g2);
        board.getDrawPile().drawCards(g2);
        board.getAcePiles().drawCards(g2);

        if(buildPileSelected > -1){
            subPile.drawCards(g2);
        }
        if(drawPileSelected == 1 || acePileSelected > -1){
            drawCard.drawCard(g2);
        }
    }
    public void mousePressed(MouseEvent e) {
        buildPileSelected = board.getBuildPiles().clicked(e.getX(), e.getY());
        drawPileSelected = board.getDrawPile().clicked(e.getX(), e.getY());
        acePileSelected = board.getAcePiles().clicked(e.getX(), e.getY());

        if(buildPileSelected > -1){
            if(board.getBuildPiles().getPile(buildPileSelected).getNumFaceUpCards() > 0){ //at least one face up card
                subPileIndex = board.getBuildPiles().getPile(buildPileSelected).getSubPileIndex(e.getY(), board.getBuildPiles().getStartY());
                subPile = board.getBuildPiles().getPile(buildPileSelected).getSubPile(subPileIndex);
                startX = e.getX() - subPile.getXCord();
                startY = e.getY() - subPile.getYCord();
                pressed = true;
            }else if(board.getBuildPiles().getPile(buildPileSelected).getNumCards() > 0){ //at least one face down card
                flip = true;
            }
        }else if(drawPileSelected > -1){
            if(drawPileSelected == 0){
                draw3 = true;
            }else{
                drawCard = board.getDrawPile().getPile(1).popTopCard();
                startX = e.getX() - board.getDrawPile().getPile(1).xCord;
                startY = e.getY() - board.getDrawPile().getPile(1).yCord;
                playDrawCard = true;
            }
        }else if(acePileSelected > -1){
            if(board.getAcePiles().getPile(acePileSelected).getNumCards() > 0){
                drawCard = board.getAcePiles().getPile(acePileSelected).popTopCard();
                startX = e.getX() - board.getAcePiles().getPile(acePileSelected).xCord;
                startY = e.getY() - board.getAcePiles().getPile(acePileSelected).yCord;
                playAceCard = true;
            }
        }
        repaint();
    }
    public void mouseReleased(MouseEvent e) {
        
        int buildPileReleasedOn = board.getBuildPiles().released(e.getX(), e.getY());
        int acePileReleasedOn = board.getAcePiles().clicked(e.getX(), e.getY());
        if(pressed){
            /* Get rid of the subPile by appending it to one of the 7 piles in PC */
            if(buildPileReleasedOn > -1){
                if(subPile.getNumFaceUpCards() + board.getBuildPiles().getPile(buildPileReleasedOn).getNumFaceUpCards() <= 13){
                    if(rules.validMove(board.getBuildPiles().getPile(buildPileReleasedOn).getBottomCard(), subPile.getTopCard())){
                        System.out.println("Bottom Card of build Pile: " + board.getBuildPiles().getPile(buildPileReleasedOn).getBottomCard());
                        System.out.println("Top Card of subPile: " + subPile.getTopCard());
                        board.getBuildPiles().getPile(buildPileReleasedOn).append(subPile);
                        
                    }else{
                        board.getBuildPiles().getPile(buildPileSelected).append(subPile);
                    }
                    
                }else{
                    board.getBuildPiles().getPile(buildPileSelected).append(subPile);
                }
            }else if(acePileReleasedOn > -1 && subPile.getNumFaceUpCards() == 1){
                if(board.getAcePiles().getPile(acePileReleasedOn).getNumCards() < 13){
                    board.getAcePiles().getPile(acePileReleasedOn).addCard(subPile);
                }else{
                    board.getBuildPiles().getPile(buildPileSelected).append(subPile);
                }
            }else{
                board.getBuildPiles().getPile(buildPileSelected).append(subPile);
            }
            pressed = false;
        }else if(flip){
            board.getBuildPiles().getPile(buildPileSelected).popFaceDownCard();
            flip = false;
        }else if(draw3){
            board.getDrawPile().draw3();
            draw3 = false;
        }else if(playDrawCard){
            if(buildPileReleasedOn > -1){
                if(board.getBuildPiles().getPile(buildPileReleasedOn).getNumFaceUpCards() + 1 <= 13){
                    board.getBuildPiles().getPile(buildPileReleasedOn).append(drawCard);
                }else{
                    board.getDrawPile().getPile(1).addCard(drawCard);
                }
            }else if(acePileReleasedOn > -1){
                if(board.getAcePiles().getPile(acePileReleasedOn).getNumCards() < 13){
                    board.getAcePiles().getPile(acePileReleasedOn).addCard(drawCard);
                }else{
                    board.getDrawPile().getPile(1).addCard(drawCard);
                }
            }else{
                board.getDrawPile().getPile(1).addCard(drawCard);
            }
            playDrawCard = false;   
        }else if(playAceCard){
            if(buildPileReleasedOn > -1){
                if(board.getBuildPiles().getPile(buildPileReleasedOn).getNumFaceUpCards() + 1 <= 13){
                    board.getBuildPiles().getPile(buildPileReleasedOn).append(drawCard);
                }else{
                    board.getDrawPile().getPile(1).addCard(drawCard);
                }
            }else{
                board.getAcePiles().getPile(acePileSelected).addCard(drawCard);
            }
            playAceCard = false;
        }
        repaint();
    }
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseDragged(MouseEvent e) {
        /* Loop through each card that's selected and change their location to 
         * match where the mouse is.
         * */
        if(pressed){
            for(int i = 0; i < subPile.getNumFaceUpCards(); i++){
                subPile.getCard(i).setXCord(e.getX() - startX);
                subPile.getCard(i).setYCord((e.getY() - startY) + (i * PILE_Y_BUFFER) + (subPileIndex * PILE_Y_BUFFER));  
            }
        }else if(playDrawCard){
            drawCard.setXCord(e.getX() - startX);
            drawCard.setYCord(e.getY() - startY);
        }else if(playAceCard){
            drawCard.setXCord(e.getX() - startX);
            drawCard.setYCord(e.getY() - startY);
        }
        repaint();
    }
    public void mouseMoved(MouseEvent e){}
}