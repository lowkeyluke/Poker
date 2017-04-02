
/**
 * deal 2 hole cards
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hole
{
    // instance variables - replace the example below with your own
    private Card[] holeCards = new Card[2];

    /**
     * Constructor for objects of class Hole
     */
    public Hole(Card card1, Card card2)
    {
        holeCards[0] = card1;
        holeCards[1] = card2;
    }
    
    public void setCard(int cardNum, Card card)
    {
        holeCards[cardNum] = card;
    }
    
    public Card getCard(int cardNum)
    {
        return holeCards[cardNum];
    }
    
    //maybe add playerNum as a parameter
    public void printHole()
    {
        System.out.println(holeCards[0].printCard() + ", " + holeCards[1].printCard());
    }
    
}
