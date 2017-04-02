
/**
 * Write a description of class Board here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Board
{
    // instance variables - replace the example below with your own
    private Card[] board = new Card[5];
    private Card[] muck = new Card[3];

    /**
     * Constructor for objects of class Board
     */
    public Board(Card[] cards)
    {
        for(int i=0; i<board.length; i++)
        {
            board[i] = cards[i];
        }
    }
    
    public void setBoardCard(int cardNum, Card card)
    {
        board[cardNum] = card;
    }
    
    public Card getBoardCard(int cardNum)
    {
        return board[cardNum];
    }
    
    public void setBurnCard(int cardNum, Card card)
    {
        muck[cardNum] = card;
    }
    
    public Card getBurnCard(int cardNum)
    {
        return muck[cardNum];
    }
    
    public void printBoard()
    {
        //System.out.println("Board: ");
        for (int i=0; i<board.length; i++)
        {
            System.out.println(i+1 + ": " + getBoardCard(i).printCard());
        }
    }
    
    public void printFlop()
    {
        for (int i=0; i<3; i++)
        {
            System.out.println(i+1 + ": " + getBoardCard(i).printCard());
        }
    }
    
    public void printTurn()
    {
        System.out.println("4: " + getBoardCard(3).printCard());
    }
    
    public void printRiver()
    {
        System.out.println("5: " + getBoardCard(4).printCard());
    }
    
    public void printMuck()
    {
        System.out.println("Muck: ");
        for (int i=0; i<muck.length; i++)
        {
            System.out.println(i+1 + ": " + getBurnCard(i).printCard());
        }
    }
}
