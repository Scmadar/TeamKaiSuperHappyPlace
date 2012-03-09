package RPS;
import java.util.*;

/**
 *
 * @author KAI
 */
public class RPSFrontEnd
 {private static int throwCount;
  static Player player1=new HumanPlayer();
  static Player player2=new ComputerPlayer();
  static Scanner in=new Scanner(System.in);
  static Match current=null;
  static Parser parser=new ParseCommandLine();

 /**
  * @param args the command line arguments
  */
 public static void main(String[] args)
   {if(args.length<2||null==Integer.getInteger(args[1]))
      {printString("No throw count found. Set to default, 20.\n");
       throwCount=20;
      }
    else
      {throwCount=Integer.getInteger(args[2]).intValue();
       if(throwCount<=0)
         {printString("Invalid throw count. Set to default, 20\n");
          throwCount=20;
         }
      }
    printString("   ROCK - PAPER - SCISSORS   \n");
    printString("         Team KAI            \n");
    int command=-1;
    while(command==-1)
      {printString("\n\t MAIN MENU\n");
       printString("Enter 1 or 'match' to start a match\n");
       printString("Enter 2 or 'help' display help\n");
       printString("Enter 3 or 'score' to display score\n");
       printString("Enter 4 or 'quit' to quit the game\n");
       printString("Enter your choice: ");
       command=parceMenuCommand(getCommand());
      }
    }


 /**
  * Begins a match.
  */
 private static void startMatch()
   {
    int winner;
    current=new Match(throwCount);
    while(!current.matchIsOver())
      {winner=0;
       int p1Throw=player1.getThrows();
       while(p1Throw==-1)
         {printString("Enter your throw: ");
          p1Throw=parser.parceCommand(getCommand());
          if(p1Throw==-1)
            {printString("Invalid command. Please enter rock, paper,"
                                +" or scissors.\n");}
          if(p1Throw==3)
          {
                  displayHelp();
                  p1Throw = -1;
          }
          if(p1Throw==4)
          {
              displayScore();
              p1Throw = -1;
          }
          if(p1Throw==5)
          {
              printString("Goodbye!\n");
              System.exit(0);
          }
              
         }
       printString("You chose ");
       switch (p1Throw)
         {case 0: printString("Rock\n");
              break;
          case 1: printString("Paper\n");
              break;
          case 2: printString("Scissors\n");
              break;
          default: printString("This should be impossibble.\n");
         }


       int p2Throw=player2.getThrows();
       
       // This code is for 2 players
       /*while(p2Throw==-1)
         {printString("Enter your throw: ");
          p2Throw=parser.parceCommand(getCommand());
          if(p2Throw==-1)
            {printString("Invalid command. Please enter rock, paper,"
                                +" or scissors.\n");}
          if(p2Throw==3)
          {
                  displayHelp();
                  p2Throw = -1;
          }
          if(p2Throw==4)
          {
              displayScore();
              p2Throw = -1;
          }
          if(p2Throw==5)
              System.exit(0);
         }*/
       
       printString("The computer chose ");
       switch (p2Throw)
         {case 0: printString("Rock\n");
              break;
          case 1: printString("Paper\n");
              break;
          case 2: printString("Scissors\n");
              break;
          default: printString("This should be impossibble.\n");
         }

       winner=current.checkRound(p1Throw, p2Throw);
       if(winner==0)//tie
         {printString("The round ended in a tie!\n");
          player1.incrementTies();
         // player2.incrementTies();
         }
       else if(winner==-1)//p1 wins
         {printString("You won the round!\n");
          player1.incrementWins();
          //player2.incrementLosses();
       }
       else if(winner==1)
         {printString("The computer won the round!\n");
          player1.incrementLosses();
          //player2.incrementWins();
         }
       else
         {printString("Something went horribly wrong.");}

      }
    displayScore();
    current=null;

   }

/**
 *
 * @return the String returned by the scanner. Later will be button presses.
 */
 private static String getCommand()
   {
     return in.nextLine();
   }


/**
 * This handles the initial menu command
 * @param parceMe the input from the player
 * @return a -1 to continue the loop if nothing is changed
 */
 private static int parceMenuCommand(String parceMe)
   {
     if(parceMe==null)
      {return -1;}
    if(parceMe.equals("1")|| parceMe.equalsIgnoreCase("match"))
      {startMatch();
       return -1;
      }
    if(parceMe.equals("2")|| parceMe.equalsIgnoreCase("help"))
      {displayHelp();
       return -1;
      }
    if(parceMe.equals("3")|| parceMe.equalsIgnoreCase("score"))
      {displayScore();
       return -1;
      }
    if(parceMe.equals("4")|| parceMe.equalsIgnoreCase("quit"))
      {printString("Thanks for playing!\n\n");
       System.exit(0);
      }

    printString("Command not understood. Please try again.\n");
    return -1;
   }


/**
 *
 * @param printMe the string to be printed.
 * @return true if non-null String was passed, false otherwise.
 */
 private static boolean printString(String printMe)
   {if(printMe==null)
      {return false;}
    System.out.print(printMe);
    return true;
   }

/**
 * Displays a help message.
 */
 private static void displayHelp()
   {printString("==========HELP PAGE==========\n");
    printString("A match consists of one or more rounds.\n");
    printString("To play a round, select either Rock, Paper, or Scissors.\n");
    printString("The computer will choose one of the same choices at random.\n");
    printString("The winner is determined as follows:\n");
    printString("  -Rock crushes Scissors\n");
    printString("  -Scissors cuts Paper\n");
    printString("  -Paper covers Rock\n");
    printString("The player with the most wins at the end of "
            + "the round is the winner!\n\n");
   }

 /**
  * Displays the score. Gotten from the match most likely.
  */
 private static void displayScore()
   {if(current!=null)//if current is null it's not inside a match, so don't
                           //display the match-specific stats
      {int[] temp=current.getStats();
       printString("===Stats for the current match===\n");
       printString("Player 1 wins: "+temp[0]+"\n");
       printString("Player 2 wins: "+temp[1]+"\n");
       printString("Ties: "+temp[2]+"\n\n");
       printString("Current match progress: "+current.getThrowCount()
                +" of "+throwCount+" throws left.\n\n");
      }
    Stats temp=player1.getStats();
    printString("===Player stats===\n");
    printString("Wins: "+temp.getWins()+"\n");
    printString("Losses: "+temp.getLosses()+"\n");
    printString("Ties: "+temp.getTies()+"\n\n");

    /*
    temp=player2.getStats();
    printString("===Player 2 stats===\n");
    printString("Wins: "+temp.getWins()+"\n");
    printString("Losses: "+temp.getLosses()+"\n");
    printString("Ties: "+temp.getTies()+"\n\n");
     *
     */
   }
}