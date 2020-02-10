public class AcePileCollection extends PileCollection{

    private static final int NUM_PILES = 4;
    
    public AcePileCollection(int startX, int startY){
        super(NUM_PILES,startX, startY);
        populatePiles();
    }
    protected void populatePiles(){
        for(int i = 0; i < collection.length; i++){
            int x = startX + (i * (CARD_WIDTH + PILE_X_BUFFER));
            Pile p = new AcePile(x,startY);
            collection[i] = p;
        }
    }
    public AcePile getPile(int i){
        return (AcePile)collection[i];
    }
}