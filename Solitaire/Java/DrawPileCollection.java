public class DrawPileCollection extends PileCollection{
    
    private static final int NUM_PILES = 2;

    public DrawPileCollection(int startX, int startY){
        super(NUM_PILES, startX, startY);
        populatePiles();
    }

    public void deal(){
        int remainingCards = d.size();
        for(int i = 0; i < remainingCards; i++){
            Card c = d.popTopCard();
            c.setXCord(startX);
            c.setYCord(startY);
            collection[0].addCard(c);
        }
    }
    public void draw3(){
        if(collection[0].getNumCards() > 0){
            ((DrawPile)(collection[1])).append(((DrawPile)(collection[0])).getSubPile());
        }else{
            //Put all the cards back in the draw pile.
            ((DrawPile)(collection[1])).flipPile();
            for(int i = collection[1].getNumCards() - 1; i >= 0; i--){
                ((DrawPile)(collection[0])).append(((DrawPile)(collection[1])).getCard(i));
                
            }
            ((DrawPile)(collection[1])).clear();
        }
    }


    
    public DrawPile getPile(int i){ return (DrawPile)collection[i];}

    protected void populatePiles(){
        for(int i = 0; i < collection.length; i++){
            int x = startX + (i * (CARD_WIDTH + PILE_X_BUFFER));
            Pile p = new DrawPile(x,startY);
            collection[i] = p;
        }
    }
}