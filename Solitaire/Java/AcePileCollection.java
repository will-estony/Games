public class AcePileCollection extends PileCollection{

    private static final int NUM_PILES = 4;
    
    public AcePileCollection(int startX, int startY){
        super(NUM_PILES,startX, startY);
    }

    public int clicked(int x, int y){
        return 0;
    }
}