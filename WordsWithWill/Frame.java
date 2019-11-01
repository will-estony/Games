import javax.swing.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class Frame extends JFrame implements ComponentListener {

    private int width;
    private int height;
    private Game game;
    private static final int titleBarPad = 22;
    private final static int HEIGHT = 800;
    private final static int WIDTH = 525;
    private MainMenu mainMenu;
    private Board board;

    Frame(Game game, int width, int height){
        this.width = width;
        this.height = height + titleBarPad;
        this.game = game;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(this.width, this.height);
        setTitle("Words With Will");
        mainMenu = new MainMenu(this, width, height);
        board = new Board(this, game, width, height);
        addComponentListener(this);
        //add(mainMenu);
        add(board);
    }
    public Frame(Game game){ this(game, WIDTH, HEIGHT); }
    public void componentHidden(ComponentEvent ce){}
    public void componentShown(ComponentEvent ce){}
    public void componentMoved(ComponentEvent ce){}
    public void componentResized(ComponentEvent ce){
        height = this.getHeight();
        width = this.getWidth();
        mainMenu.update(width, height);
        board.update(width, height);
    }
    public void drawBoard(){
        remove(mainMenu);
        add(board);
        repaint();
        revalidate();
        board.requestFocus();
    }
}
