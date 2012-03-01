/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rps;
import java.util.*;

/**
 *
 * @author Jason / Team Kai
 */
public class RPSFrontEnd
 {private int throwCount;
  Player player1=new HumanPlayer();
  Player player2=new ComputerPlayer();
  Scanner in=new Scanner(System.in);

 /**
  * @param args the command line arguments
  */
 public void main(String[] args)
   {if(args.length<2||null==Integer.getInteger(args[1]))
      {printString("No throw count found. Set to default, 20.");
       throwCount=20;
      }
    else
      {throwCount=Integer.getInteger(args[2]).intValue();
      }
    startRound();
    }

 /**
  * Begins a match.
  */
 private void startMatch()
   {Match current=new Match(throwCount);
    while(!current.matchIsOver())
      {int temp=player1.getThrow();
       if(temp==-1)
         {
         }
      }

   }
/**
 *
 * @return the String returned by the scanner. Later will be button presses.
 */
 private String getCommand()
   {return in.nextLine();
   }

 /**
  *
  * @param parceMe - a non-null String object
  * @return integer value for the choice selected. 0=rock, 1=paper,
  *       2=scissors. 3 is other command successfully executed.
  *       -1 is an error of any sort.
  */
 private int parceCommand(String parceMe)
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
    return -1; //if it got past return an error
   }
/**
 *
 * @param printMe the string to be printed.
 * @return true if non-null String was passed, false otherwise.
 */
 private boolean printString(String printMe)
   {if(printMe==null)
      {return false;}
    System.out.println(printMe);
    return true;
   }

/**
 * Displays a help message.
 */
 private void displayHelp()
   {printString("Not implemented yet!");
   }

 /**
  * Displays the score. Gotten from the match most likely.
  */
 private void displayScore()
   {printString("Not implemented yet!");
   }
}
