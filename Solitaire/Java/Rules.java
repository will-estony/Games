public class Rules{
    public Rules(){

    }
    public boolean validMove(Card top, Card bottom){
        if(!(top.getColor().equals(bottom.getColor())) && top.getVal() == bottom.getVal() + 1){
            return true;
        }else{
            return false;
        }
    }
}