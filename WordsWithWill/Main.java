public class Main {

    private static Frame frame;
    private static Game game;
    private static Player player1;
    private static Player player2;
    private final static int HEIGHT = 800;
    private final static int WIDTH = 525;


    public static void main(String[] arguments) {

        player1 = new Player("Will");
        player2 = new Player("Ellie");
        game = new Game(player1, player2);
        frame = new Frame(game);
        frame.setVisible(true);
    }
}
