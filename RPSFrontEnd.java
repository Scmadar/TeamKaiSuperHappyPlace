/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RPS;
import java.util.*;

/**
 *
 * @author Jason / Team Kai
 */
public class RPSFrontEnd
 {private static int throwCount;
  static Player player1=new HumanPlayer();
  static Player player2=new ComputerPlayer();
  static Scanner in=new Scanner(System.in);

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
      }
    printString("   ROCK - PAPER - SCISSORS   \n");
    printString("         Team KAI            \n");
    int command=-1;
    while(command==-1)
      {printString("\n\t MAIN MENU\n");
       printString("Enter 1 to start a match\n");
       printString("Enter 2 to display help\n");
       printString("Enter 3 to display score\n");
       printString("Enter 4 to quit the game\n");
       command=parceMenuCommand(getCommand());
      }
    }


 /**
  * Begins a match.
  */
 private static void startMatch()
   {int winner;
    Match current=new Match(throwCount);
    while(!current.matchIsOver())
      {winner=0;
       int p1Throw=player1.getThrows();
       while(p1Throw==-1)
         {printString("Enter your throw: ");
          p1Throw=parceCommand(getCommand());
          if(p1Throw==-1)
            {printString("Invalid command. Please enter rock, paper,"
                                +" or scissors.\n");}
          if(p1Throw==3)
            {p1Throw=-1;}
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
       while(p2Throw==-1)
         {printString("Enter your throw: ");
          p2Throw=parceCommand(getCommand());
          if(p2Throw==-1)
            {printString("Invalid command. Please enter rock, paper,"
                                +" or scissors.\n");}
          if(p2Throw==3)
            {p2Throw=-1;}
         }
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
          player2.incrementTies();
         }
       if(winner==-1)//p1 wins
         {printString("You won the round!\n");
          player1.incrementWins();
          player2.incrementLosses();
       }
       if(winner==-2)
         {printString("The computer won the round!");
          player1.incrementLosses();
          player2.incrementWins();
         }
       
      }

   }
 
/**
 *
 * @return the String returned by the scanner. Later will be button presses.
 */
 private static String getCommand()
   {return in.nextLine();
   }

 
 
 private static int parceMenuCommand(String parceMe)
   {if(parceMe==null)
      {return -1;}
    if(parceMe.equals("1"))
      {startMatch();
       return -1;
      }
    if(parceMe.equals("2"))
      {displayHelp();
       return -1;
      }
    if(parceMe.equals("3"))
      {displayScore();
       return -1;
      }
    if(parceMe.equals("4"))
      {printString("Thanks for playing!");
       System.exit(0);
      }
    printString("Command not understood. Please try again.\n");
    
    return -1;
   }
 
 
 
 /**
  *
  * @param parceMe - a non-null String object
  * @return integer value for the choice selected. 0=rock, 1=paper,
  *       2=scissors. 3 is other command successfully executed.
  *       -1 is an error of any sort.
  */
 private static int parceCommand(String parceMe)
   {if(parceMe==null)
      {return -1;
      }
    if(parceMe.equalsIgnoreCase("rock"))
      {return 0;
      }
    else if(parceMe.equalsIgnoreCase("paper"))
      {return 1;
      }
    else if(parceMe.equalsIgnoreCase("scissors"))
      {return 2;
      }
    else if(parceMe.equalsIgnoreCase("HELP")||
          parceMe.equalsIgnoreCase("H"))
      {displayHelp();
       return 3;
      }
    else if(parceMe.equalsIgnoreCase("score"))
      {displayScore();
       return 3;
      }
    else if(parceMe.equalsIgnoreCase("quit"))
      {printString("Goodbye!");
       System.exit(0);
      }
    return -1; //if it got past return an error
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
   {printString("Not implemented yet!");
   }

 /**
  * Displays the score. Gotten from the match most likely.
  */
 private static void displayScore()
   {printString("Not implemented yet!");
   }
}
