import javax.swing.JFrame;
public class Frame extends JFrame{
    public Frame(){
        Panel panel = new Panel();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1250,1000);
        add(panel);
        setVisible(true);
    }
}