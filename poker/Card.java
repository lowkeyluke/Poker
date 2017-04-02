
/**
 * Card constructed with String[]
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Card
{
    // instance variables - replace the example below with your own
    private String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    private String[] suits = {"Hearts", "Spades", "Diamonds", "Clubs"};
    private int rank;
    private int suit;
    
    /**
     * Constructor for objects of class Card
     */
    public Card(int rank, int suit)
    {
        // initialise instance variables
        this.rank = rank;
        this.suit = suit;
    }
    
    //getters and setters
    public int getRank()
    {
        return rank;
    }
    
    public int getSuit()
    {
        return suit;
    }
    
    public void setRank(int rank)
    {
        this.rank = rank;
    }
    
    public void setSuit(int suit)
    {
        this.suit = suit;
    }
    
    //print card
    public String toString()
    {
        String temp = "";
        
        temp = ranks[rank-2] + " of " + suits[suit];
        
        return temp;
    }
    
    public String printCard()
    {
        return ranks[rank] + " of " + suits[suit];
    }
}
