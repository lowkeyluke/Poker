
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player
{
    // instance variables - replace the example below with your own
    private int chips;
    private Hole cards;
    private boolean dealer;

    /**
     * Constructor for objects of class Player
     */
    public Player(boolean dealer)
    {
        // initialise instance variables
        chips = 1000;
        this.dealer=dealer;
        cards = null;
    }
    
    public int getChips()
    {
        return chips;
    }
    
    public void blind(int b)
    {
        chips -= b;
    }
    
    public void placeBet(int bet)
    {
        if(bet<=chips)
        chips -= bet;
    }
    
    public void collectPot(int pot)
    {
        chips += pot;
    }
    
    public void setHole(Hole cards)
    {
        this.cards = cards;
    }
    
    public Hole getHole()
    {
        return this.cards;
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void sampleMethod(int y)
    {
        // put your code here
    }
}
