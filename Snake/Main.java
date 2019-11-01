public class Main {

   public static void main(String args[]){

       BackgroundPanel panel = new BackgroundPanel();
       Board board = new Board();
       panel.setFocusable(true);
       board.getContentPane().add(panel);



   }
}
