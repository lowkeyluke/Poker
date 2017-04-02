
/**
 * Demo/beta version of the game
 * Notes:
 * Hand Evaluation class needed
 * Neural network needed
 * 
 * @author (Luke Do) 
 * @version (3/14/17)
 */
import java.util.Scanner;
public class Beta
{
    public static void main(String[] args)
    {
        //int chips1 = 1000; //create chips
        //int chips2 = 1000;
        Player player1 = new Player(true);
        Player player2 = new Player(true);
        int sb = 10;
        int bb = 20;
        boolean assign=false;
        boolean dealer=true;
        int count = 6; //count equals 1 more than "raise blind interval"
        int bet = 0;
        int pot = 0;
        Deck deck = new Deck(); //create deck
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Name? ");
        String name = scan.nextLine();
        
        System.out.println("Print deck? (type true for yes, false for no)");
        boolean print = scan.nextBoolean();
        if(print==true)
            deck.printDeck();
            
        deck.shuffle();//shuffle deck
        System.out.println("Assigning dealer...");
        while(assign == false)
        {
            System.out.println(name + ": " + deck.getCard(0));
            System.out.println("Bot: " + deck.getCard(1));
            if(deck.getCard(0).getRank() > deck.getCard(1).getRank())
            {
                System.out.println("Dealer: " +name);
                player1 = new Player(true);
                player2 = new Player(false);
                assign=true;
                dealer=true;
            }
            else if(deck.getCard(1).getRank() > deck.getCard(0).getRank())
            {
                System.out.println("Dealer: Bot");
                player1 = new Player(false);
                player2 = new Player(true);
                assign=true;
                dealer=false;
            }
            deck.shuffle();
        }
            
        while(player1.getChips() > 0 && player2.getChips() > 0) {
        deck.shuffle(); //shuffle deck
        if(count%5 == 0) //raise blinds every %x turns
        {
            sb *= 2;
            bb *= 2;
            System.out.println("BLINDS RAISED: SB: " +sb+ ", BB: " +bb);
        }
        
        //switch dealers
        if(count>6) //count greater than initial count, switches after first turn
        {
            if(dealer==true)
            dealer=false;
            if(dealer==false)
            dealer=true;
        }
        
        //deal
        Hole nondealercards = new Hole(deck.getCard(0), deck.getCard(2)); //deal 1
        Hole dealercards = new Hole(deck.getCard(1), deck.getCard(3)); //deal 2
        if(dealer==true)
        {
            player1.setHole(dealercards);
            player2.setHole(nondealercards);
            System.out.print(name + ": ");
            dealercards.printHole();
            player1.blind(sb);
            player2.blind(bb);
            pot += sb + bb;
            System.out.println("sb/dealer");
        }
        else if(dealer==false)
        {
            player1.setHole(nondealercards);
            player2.setHole(dealercards);
            System.out.print(name + ": ");
            nondealercards.printHole();
            player1.blind(bb);
            player2.blind(sb);
            pot += sb + bb;
            System.out.println("bb");
        }
        
        /**
         * Prompt bet
         */
        System.out.print("Bet: ");
        bet = scan.nextInt();
        while(bet>player1.getChips())
        {
            System.out.println("Insufficient chips.");
            System.out.print("bet: ");
            bet = scan.nextInt();
        }
        player1.placeBet(bet);
        player2.placeBet(bet);
        pot += bet*2;
        System.out.println("Pot: " + pot);
        System.out.println("--------------------------------------------");
        
        //board
        //board array = 5,6,7, 9, 11
        Card[] cards = new Card[5];
        cards[0] = deck.getCard(5);
        cards[1] = deck.getCard(6);
        cards[2] = deck.getCard(7);
        cards[3] = deck.getCard(9);
        cards[4] = deck.getCard(11);
        Board board = new Board(cards); //set board
        
        board.printFlop(); //deal flop
        /**
         * Prompt bet
         */
        System.out.print("Bet: ");
        bet = scan.nextInt();
        while(bet>player1.getChips())
        {
            System.out.println("Insufficient chips.");
            System.out.print("bet: ");
            bet = scan.nextInt();
        }
        player1.placeBet(bet);
        player2.placeBet(bet);
        pot += bet*2;
        System.out.println("Pot: " + pot);
        System.out.println("--------------------------------------------");
        
        board.printTurn(); //deal turn
        /**
         * Prompt bet
         */
        System.out.print("Bet: ");
        bet = scan.nextInt();
        while(bet>player1.getChips())
        {
            System.out.println("Insufficient chips.");
            System.out.print("bet: ");
            bet = scan.nextInt();
        }
        player1.placeBet(bet);
        player2.placeBet(bet);
        pot += bet*2;
        System.out.println("Pot: " + pot);
        System.out.println("--------------------------------------------");
        
        board.printRiver(); //deal river
        /**
         * Prompt bet
         */
        System.out.print("Bet: ");
        bet = scan.nextInt();
        while(bet>player1.getChips())
        {
            System.out.println("Insufficient chips.");
            System.out.print("bet: ");
            bet = scan.nextInt();
        }
        player1.placeBet(bet);
        player2.placeBet(bet);
        pot += bet*2;
        System.out.println("Pot: " + pot);
        System.out.println("--------------------------------------------");
        
        //evaluate hands/winner
        System.out.print ("Bot: ");
        
        if(dealer==true)
        nondealercards.printHole();
        if(dealer==false)
        dealercards.printHole();
        
        board.printBoard();
        System.out.println("Did you win? (type true for yes, false for no)");
        boolean win = scan.nextBoolean();
        if(win==true)
        {
            player1.collectPot(pot);
            pot = 0;
        }
        else
        {
            player2.collectPot(pot);
            pot = 0;
        }
        System.out.println(name + "'s chips: " + player1.getChips()); //print chips
        System.out.println("Bot's chips: " + player2.getChips());
        count++;
        if(player2.getChips() < 1)
        {
            System.out.println("GG " +name+ " YOU WIN!!");
        }
        if(player1.getChips() < 1)
        {
            System.out.println("You lose. Better luck next time!");
        }
    }
       
        /**
         * break
         */
        
        //chips
        //assign blinds
        //shuffle
        //deal hands
        //bet
        
        //board
        //deal flop
        //bet
        //deal turn
        //bet
        //deal river
        //bet
        
        //show hands
        //rank hands
        
        //assign winner
        //add pot to winner
        //END TURN
        
        //(repeat)
        //assign blinds
        //shuffle
        //deal hands
    }
}
