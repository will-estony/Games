public class Rules{
    public Rules(){

    }
    public boolean validMove(BuildPile bp, Card bottom){
        if(bp.getNumCards() > 0){
            if(!(bp.getBottomCard().getColor().equals(bottom.getColor())) && bp.getBottomCard().getVal() == bottom.getVal() + 1){
                return true;
            }
        }else if(bottom.getVal() == 13){
            return true;
        }
        return false;
    }
    public boolean validMove(AcePile ap, Card c){
        if(ap.getSuit().equals("wild") && c.getVal() == 1){
            ap.setSuit(c.getSuit());
            return true;
        }else if(ap.getSuit().equals(c.getSuit()) && ap.getTopCard().getVal() == c.getVal() - 1){
            return true;
        }
        else{
            return false;
        }
    }
}