
/**
 * Write a description of class Deck here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Deck
{
    // instance variables - replace the example below with your own
    private Card[] deck = new Card[52];

    /**
     * Constructor for objects of class Deck
     */
    public Deck()
    {
        // initialise instance variables
        int cardnum = 0;
        for (int j=0; j<4; j++)
        {
            for (int k=0; k<13; k++)
            {
                deck[cardnum++] = new Card(k, j);
            }
        }
    }
    
    public void printDeck()
    {
        for (int i=0; i < deck.length; i++)
        {
            System.out.println(i+1 + ": " + deck[i].printCard());
        }
    }
    
    /**
     * Return specified card from deck 
     */
    public Card getCard(int cardNum)
    {
        // put your code here
        return deck[cardNum];
    }
    
    //shuffle deck
    public void shuffle()
    {
        for(int c=0; c < 3; c++)
        {
            for (int i=0; i < deck.length; i++)
            {
                int ran = (int)(Math.random() *52);
                Card temp = deck[i];
                deck[i] = deck[ran];
                deck[ran] = temp;
            }
        }
    }
}
