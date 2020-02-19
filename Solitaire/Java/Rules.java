/**
 * The following simple class, is used to validate if the user makes a valid move in Solitaire.
 * It contains no constructor, it's only two methods are accessed statically. 
 * 
 * There are two variants of valid moves which we need to check for (hence the two methods).
 * 
 * If we are moving a card to a buildPile, the card being moved onto the buildPile must be
 * the opposite color and one value less than the "bottom" most card in the cascade of Cards.
 * This is expressed by the first method in this class.
 * 
 * If we are moving a card to an acePile, the card being moved onto the acePile must be 
 * one value greater than the top card on the acePile and be the same suit as all other cards
 * in the Pile. The only exception is if an Ace is being moved onto an AcePile, in this case,
 * the the ace can be moved onto any empty Pile. This is is expressed by the second method in 
 * this class.
 */

public class Rules{

    /**
     * This static method takes two arguments and returns true if a move is valid, false otherwise.
     * Specifically, looks at the case where a card is moved onto a buildPile.
     * 
     * @param top - the pile a card(s) are being moved onto
     * @param bottom - the pile being moved from one location to another (can contain a single card)
     * 
     * @return true if a move is valid, false otherwise.
     */
    public static boolean validMove(BuildPile top, BuildPile bottom){
        if(top.getNumCards() > 0){
            if(!(top.getBottomCard().getColor().equals(bottom.getTopCard().getColor())) && top.getBottomCard().getVal() == bottom.getTopCard().getVal() + 1){
                return true;
            }
            //Checks to see if a King is moved onto an empty buildPile.
        }else if(bottom.getTopCard().getVal() == 13){
            return true;
        }
        return false;
    }
    /**
     * This static method takes two arguments and returns true if a move is valid, false otherwise.
     * Specifically, looks at the case where a card is moved 
     * 
     * @param top - the pile a card(s) are being moved onto
     * @param bottom - the pile being moved from one location to another (can contain a single card)
     * 
     * @return true if a move is valid, false otherwise.
     */
    public static boolean validMove(AcePile ap, BuildPile bp){
        //Check if the pileSuit is wild and can therefore take any suited ace
        if(ap.getSuit().equals("wild") && bp.getTopCard().getVal() == 1){
            ap.setSuit(bp.getTopCard().getSuit());
            return true;
            //Otherwise check that the value of the card being moved onto the pile is one greater
            //and the the same suit as the one below it.
        }else if(ap.getSuit().equals(bp.getTopCard().getSuit()) && ap.getTopCard().getVal() == bp.getTopCard().getVal() - 1){
            return true;
        }
        else{
            return false;
        }
    }
}