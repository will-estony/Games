/**
 * @author Will Estony
 * @version 0.0.1
 *
 * Class to model a game object
 *
 */

public class Game {

    private Player player1;
    private Player player2;
    private TileBag tileBag;
    private static final short MAX_TILES_ON_RACK = 7;


    public Game(Player player1, Player player2){

        this.player1 = player1;
        this.player2 = player2;

        tileBag = new TileBag();

        populateTileRacks();

    }

    public Player getPlayer1(){ return player1; }
    public Player getPlayer2(){ return player2; }

    //To be used in final implementation
    public void setPlayer1(Player p1){ this.player1 = p1; }
    public void setPlayer2(Player p2){ this.player2 = p2; }

    private void populateTileRacks(){
        for(int i = 0; i < MAX_TILES_ON_RACK; i++){
            if(player1 != null && player2 != null) {
                player1.pick(tileBag.getTile());
                player2.pick(tileBag.getTile());
            }
        }
    }
}
