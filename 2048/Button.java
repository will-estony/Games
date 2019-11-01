import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;

public class Button extends JButton {

    public Button(String title, int width, int height){

        setText(title);
        setForeground(new Color(225,225,225));
        setBackground(new Color(100,100,100));
        setOpaque(true);
        setFocusPainted(false);
        setFocusable(false);
        setPreferredSize(new Dimension(width,height));
        setBorder(new LineBorder(Color.black, GamePanel.getBorderThickness()));
    }
}
