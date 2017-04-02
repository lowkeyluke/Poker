
/**
 * Run to test outputs of methods
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test
{
    public static void main (String[] args)
    {
        Card example = new Card(2, 0);
        System.out.println(example.toString());
        
        example.setRank(3);
        example.setSuit(1);
        System.out.println(example.getRank() + " of " + example.getSuit());
        
        Deck example2 = new Deck(); //create deck
        example2.printDeck(); // print deck
        System.out.println(example2.getCard(6));
        
        for(int i=0; i<1; i++)
        {
            example2.shuffle(); //shuffle deck
            example2.printDeck(); //print deck
        }
        
        //deal
        Hole player1 = new Hole(example2.getCard(0), example2.getCard(2)); //deal player 1
        Hole player2 = new Hole(example2.getCard(1), example2.getCard(3)); //deal player 2
        player1.printHole(); //print player 1 hole cards
        player2.printHole(); //print player 2 hole cards (hide)
        
        //prompt bet
        
        //board
        //board array = 5,6,7, 9, 11
        Card[] cards = new Card[5];
        cards[0] = example2.getCard(5);
        cards[1] = example2.getCard(6);
        cards[2] = example2.getCard(7);
        cards[3] = example2.getCard(9);
        cards[4] = example2.getCard(11);
        Board board = new Board(cards); //set board
        board.printFlop(); //deal flop
        //prompt bet
        board.printTurn(); //deal turn
        //prompt bet
        board.printRiver(); //deal river
        //prompt bet
        
        //evaluate hands
        //declare winner
        //give pot to winner
    }
}
