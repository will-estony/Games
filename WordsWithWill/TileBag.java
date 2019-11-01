/**
 * @author Will Estony
 * @version 0.0.1
 *
 * Class to model a Pot object, which is a collection of every Tile found in a game of WordsWithWill
 *
 */

import java.util.Collections;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class TileBag {

    private HashMap<Tile, Integer> tilesDistribution; //Key is a Tile object that holds a char and point value, value is an integer representing the number of that tile in the pot.
    private ArrayList<Tile> bag;
    public TileBag(){

        tilesDistribution = new HashMap<Tile, Integer>();
        bag = new ArrayList<Tile>();

        populateTileValues();
        for(Tile t: tilesDistribution.keySet()){
            for(int i = 0; i < tilesDistribution.get(t); i++){
                bag.add(t);
            }
        }
    }

    private void populateTileValues(){

        tilesDistribution.put(new Tile('A',1), 9);
        tilesDistribution.put(new Tile('B', 3), 2);
        tilesDistribution.put(new Tile('C',3), 2);
        tilesDistribution.put(new Tile('D', 2), 4);
        tilesDistribution.put(new Tile('E', 1), 12);
        tilesDistribution.put(new Tile('F', 4), 2);
        tilesDistribution.put(new Tile('G', 2), 3);
        tilesDistribution.put(new Tile('H', 4), 2);
        tilesDistribution.put(new Tile('I',1), 9);
        tilesDistribution.put(new Tile('J', 8), 1);
        tilesDistribution.put(new Tile('K', 5), 1);
        tilesDistribution.put(new Tile('L', 1), 4);
        tilesDistribution.put(new Tile('M',3), 2);
        tilesDistribution.put(new Tile('N', 1), 6);
        tilesDistribution.put(new Tile('O', 1), 8);
        tilesDistribution.put(new Tile('P', 3), 2);
        tilesDistribution.put(new Tile('Q', 10), 1);
        tilesDistribution.put(new Tile('R', 1), 6);
        tilesDistribution.put(new Tile('S', 1), 4);
        tilesDistribution.put(new Tile('T', 1), 6);
        tilesDistribution.put(new Tile('U', 1), 4);
        tilesDistribution.put(new Tile('V', 4), 2);
        tilesDistribution.put(new Tile('W', 4), 2);
        tilesDistribution.put(new Tile('X', 8), 1);
        tilesDistribution.put(new Tile('Y',4), 2);
        tilesDistribution.put(new Tile('Z', 10), 1);
        tilesDistribution.put(new Tile(' ', 0), 2);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("There are " + bag.size() + " tiles in the pot\n");
        sb.append("-------------\n");
        for(int i = 0; i < bag.size(); i++){
            sb.append(bag.get(i));
            sb.append("-------------\n");
        }

        return sb.toString();
    }

    public void shuffle(){
        Collections.shuffle(bag);
    }

    public void printBag(){
        for(int i = 0; i < bag.size(); i++){
            System.out.print("|" + bag.get(i).getC() + "|");
        }
    }

    /**
     * Removes and returns a tile from a random index of the ArrayList
     * @return
     */
    public Tile getTile(){
        Random rand = new Random();
        int i = rand.nextInt(bag.size());
        return bag.remove(i);
    }
}
