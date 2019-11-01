import javax.swing.*;
import java.awt.*;

public class TextBox extends JTextField {

    public static final int PAD = 5;
    public static final int BUTTON_HEIGHT = 50;

    public TextBox(int width, int boardHeight){

        Font font = new Font("HelveticaNeue", Font.BOLD, 21);
        setText("Enter Your Username");

        // Center the text
        setHorizontalAlignment(JTextField.CENTER);
        setFont(font);
        setPreferredSize(new Dimension(width - (2*PAD), BUTTON_HEIGHT));

    }

    public void update(int width){
        setPreferredSize(new Dimension(width - (2*PAD), BUTTON_HEIGHT));
    }
}
