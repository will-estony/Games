public class BuildPileCollection extends PileCollection{

    private static final int NUM_PILES = 7;
    
    
    public BuildPileCollection(int startX, int startY){ 
        super(NUM_PILES, startX, startY);
        populatePiles();
    }

    public int getStartY(){ return startY; }

    public int clicked(int xCord, int yCord){
        for(int i = 0; i < collection.length; i++){
            if(collection[i].pileClicked(xCord, yCord)){
                return i;
            }
        }
        return -1;
    }

    private void populatePiles(){
        for(int i = 0; i < collection.length; i++){
            int x = startX + (i * (CARD_WIDTH + PILE_X_BUFFER));
            Pile p = new BuildPile(x,startY);
            collection[i] = p;
        }
    }
    
    //The only difference between this method and clicked, is clicked requires at least 
    //one card to be in the pile so as to avoid an index out of bounds error
    //A card can be released on even an empty pile.
    public int released(int xCord, int yCord){
        for(int i = 0; i < collection.length; i++){
            if(collection[i].pileClicked(xCord, yCord)){
                if(((BuildPile)(collection[i])).getNumFaceDownCards() == 0 || ((BuildPile)(collection[i])).getNumFaceUpCards() > 0){
                    return i;
                }
            }
        }
        return -1;
    }
    
    public void deal(){
        System.out.println(d.size());
        for(int i = 0; i < collection.length; i++){
            int x = startX + (i * (CARD_WIDTH + PILE_X_BUFFER));
            Card c = d.popTopCard();
            c.setXCord(x);
            c.setYCord(startY);
            c.flip();
            collection[i].addCard(c);

            for(int j = i + 1; j < collection.length; j++){
                x = startX + (j * (CARD_WIDTH + PILE_X_BUFFER));
                c = d.popTopCard();
                c.setXCord(x);
                c.setYCord(startY);
                collection[j].addCard(c);
            }
        }
    }
    public BuildPile getPile(int i){ return (BuildPile)collection[i];}
    public void printPileCounts(){
        int i = 1;
        for(Pile p: collection){
            System.out.println("Pile " + i + ": " + p.getNumCards());
            i++;
        }
    }
}