import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Button extends JButton {

    private static final int PAD = 5;
    private static final int BUTTON_HEIGHT = 50;

    public Button(int width, int boardHeight){

        Font font = new Font("HelveticaNeue", Font.BOLD, 21);
        setText("Find Opponent");
        setFont(font);
        setBackground(new Color(236,198,86));
        setForeground(new Color(203,119,53));
        setOpaque(true);
        setFocusPainted(false);
        setPreferredSize(new Dimension(width - 2* PAD, BUTTON_HEIGHT));
        setBorder(new LineBorder(Color.black, 0));
    }

    public void update(int width){
        setPreferredSize(new Dimension(width - 2* PAD, BUTTON_HEIGHT));
    }
}
