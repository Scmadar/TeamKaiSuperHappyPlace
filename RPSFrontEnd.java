package RPS;
import java.util.*;
import solomonClientLib.proxy.RemotePlayer;
import solomonserver.Gesture;
import solomonserver.Scorecard;

/**
 *
 * @author KAI
 */
public class RPSFrontEnd
 {
    private static final int defaultThrowCount=50;
    private static int throwCount;
    static Player player1=new HumanPlayer();
    static Player player2=new ComputerPlayer();
    static Scanner in=new Scanner(System.in);
    static Match current=null;
    private static final int defaultAiType=1; //for testing default to 1
    private static int aiType=defaultAiType;
    
    
    private static boolean solomon=false; //flag for the Solomon server things
    
  
 /**
  * @param args the command line arguments
  */
 public static void main(String[] args)
   {boolean commandline=false;
       for(int i=0;i<args.length;i++)
           {if(args[i].equalsIgnoreCase("-c")) //c for command line
             {commandline=true;
              break;}
           }
       for(String s : args)
         {if(s.equalsIgnoreCase("-s")) //s for solomon (server battles)
           {solomon=true;
            break;
           }
          
         }
       if(!commandline)
         {
             
                //c for command line
               {/*
              * Set the Nimbus look and feel
              */
             //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
            
              /*
               * Create and display the form
               */
              java.awt.EventQueue.invokeLater(new Runnable()
                {

                  @Override
                  public void run() {
                    
                  
                      new NewJFrame().setVisible(true);
                  }
                 });
              }
           return;
           }// end command line parsing.
       
       /**
        * It should be noted that currently the -c option is the only way to 
        *    start in command-line mode, and if it is not found all other
        *    arguments will be ignored (and the gui should start).
        * 
       */
   
   
   
       int index=args.length-1;
       //get throw count and ai level from the command line argument
       //ai level is the last argument, throw count is the second to last.
       //throw count is assumed before ai level, if there is only one arg
       //throw count will be it, not ai level. The exception is if you enter
       //a zero or one as the sole argument, it will assume you meant the
       //ai level (currently, subject to changes)

       if(index<0)
       {
           printString("No throw count found. Set to default, "+
                                   defaultThrowCount+".\n");
           throwCount=defaultThrowCount;
           printString("No AI type selected, default set to random.\n");
           aiType=defaultAiType;
           ((ComputerPlayer) player2).setAI(aiType);
       }
       else if (index==0)
       {
           try{throwCount=Integer.decode(args[0]).intValue();}
           catch(NumberFormatException e)
             {throwCount=0;}
           if(throwCount<=2)           
           {
               printString("Invalid throw count. Set to default, "
                                          +defaultThrowCount+"\n");
               throwCount=defaultThrowCount;
               printString("No AI type selected, default set to random.\n");
               aiType=defaultAiType;
               ((ComputerPlayer) player2).setAI(aiType);
           }
           else if(throwCount==1||throwCount==0)
           {
               aiType=throwCount;
               throwCount=defaultThrowCount;
               ((ComputerPlayer) player2).setAI(aiType);
               printString("No throw count found. Set to default, "+
                              defaultThrowCount+"\n");
           }
           else
           {
               printString("No throw count found. Set to default, "
                             +defaultThrowCount+"\n");
               printString("No AI type selected, default set to random.\n");
               aiType=defaultAiType;
               throwCount=defaultThrowCount;
           }


       }
       else// if (index==1)
       {
           try{throwCount=Integer.decode(args[0]).intValue();}
           catch(NumberFormatException e)
             {throwCount=0;}
           try{aiType=Integer.decode(args[index]).intValue();}
           catch(NumberFormatException e)
             {aiType=-1;}
           if(throwCount<=0)
           {
               printString("Invalid throw count. Set to default, "
                                         +defaultThrowCount+"\n");
               throwCount=defaultThrowCount;
           }
           if((aiType!=1)&&(aiType!=0))
           {
               printString("Invalid AI type. Set to random.\n");
               aiType=defaultAiType;
           }
           ((ComputerPlayer) player2).setAI(aiType);
       }
       //System.out.println(throwCount);
       /**
       else
       {
           throwCount=Integer.decode(args[index]).intValue();
           if(throwCount<=0)
           {
               printString("Invalid throw count. Set to default, "
                               +defaultThrowCount+"\n");
               throwCount=defaultThrowCount;
           }
       }    
       **/
       
       if(solomon)
         {RemotePlayer.getInstance().register( "Team Kai", null );}

       printString("   ROCK - PAPER - SCISSORS   \n");
       printString("         Team KAI            \n");
       int command=-1;
       while(command==-1)
       {
           printString("\n\t MAIN MENU\n");
           printString("Enter 1 or 'match' to start a match\n");
           printString("Enter 2 or 'help' display help\n");
           printString("Enter 3 or 'score' to display score\n");
           printString("Enter 4 for more options\n");
           printString("Enter 5 or 'quit' to quit the game\n");
           printString("Enter your choice: ");
           command = parceMenuCommand(in.nextLine());
       }
   }


 /**
  * Begins a match.
  */
 private static void startMatch()
 {
     int winner;
     
     if(solomon)
       {RemotePlayer.getInstance().startMatch( throwCount );}
     
     current=new Match(throwCount);
     while(!current.matchIsOver())
     {
         String results="";
         
         //CPU's turn
         int p2Throw=player2.getThrows();
         if(solomon)
           {
            RemotePlayer.getInstance().doGesture(intToGesture(p2Throw));
           }

         //Player's turn
         int p1Throw = -1;
         if(solomon)
           {Scorecard score = RemotePlayer.getInstance().getScore();
            Gesture gesture=score.myGesture;
            p1Throw=gestureToInt(gesture);
           }
         else
           {while(p1Throw==-1)
              {printString("Enter your throw: ");
               p1Throw =player1.getThrows();
               if(p1Throw==-1)
                 {printString("Invalid command. Please enter rock, paper,"
                                 +" or scissors.\n");
                 }
               if(p1Throw==3)
                 {displayHelp();
                  p1Throw = -1;
                 }
               if(p1Throw==4)
                 {displayScore();
                  p1Throw = -1;
               }
               if(p1Throw==5)
                 {printString("Goodbye!\n");
                  System.exit(0);
                 }
              }
           }
         
         //Print results
         printString("You chose ");
         switch (p1Throw)
         {
             case 0: printString("Rock\n");
                results=results+"r";
                break;
             case 1: printString("Paper\n");
                results=results+"p";
                break;
             case 2: printString("Scissors\n");
                results=results+"s";
                break;
             default: printString("This should be impossible.\n");
                results=results+"?";
         }
         printString("The computer chose ");
         switch (p2Throw)
         {
             case 0: printString("Rock\n");
                results=results+"R";
                break;
             case 1: printString("Paper\n");
                results=results+"P";
                break;
             case 2: printString("Scissors\n");
                results=results+"S";
                break;
             default: printString("This should be impossibble.\n");
                results=results+"?";
         }
         
         
       // This code is for 2 players, in place of the call to player2.getThrows()
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
         
         
         //print the winner
         winner=current.checkRound(p1Throw, p2Throw);
         if(winner==0)//tie
         {
             printString("The round ended in a tie!\n");
             player1.incrementTies();
             // player2.incrementTies();
         }
         else if(winner==-1)//p1 wins
         {
             printString("You won the round!\n");
             player1.incrementWins();
             //player2.incrementLosses();
         }
         else if(winner==1)
         {
             printString("The computer won the round!\n");
             player1.incrementLosses();
             //player2.incrementWins();
         }
         else
         {
             printString("Something went horribly wrong.");
             System.exit(1);
         }
       
         player1.setMatchRec(results); //This may be an issue when trying to put
         player2.setMatchRec(results);  //two cpu's against each other, since 
             //the order of throws matters (p1's comes after p2's currently).
     }
     displayScore();
     current=null;
   }


/**
 * This handles the initial menu command
 * @param parceMe the input from the player
 * @return a -1 to continue the loop if nothing is changed
 */
 private static int parceMenuCommand(String parceMe)
   {
     if(parceMe==null)
      {
          return -1;
      }
    if(parceMe.equals("1")|| parceMe.equalsIgnoreCase("match"))
      {
          //printString("Set AI level (1-random 2-smart):");
          //Scanner sc = new Scanner(System.in);
          //String level = sc.nextLine();
          //if (player2 instanceof ComputerPlayer)
            //  ((ComputerPlayer) player2).setAI(level);
          /*input throwCount
          printString("Enter the number of throws per match: ");
          try 
          {
              throwCount = Integer.parseInt(sc.nextLine());
              if(throwCount<=0 || (int) throwCount != throwCount)
              {
                  printString("Invalid throw count. Set to default, 20\n");
                  throwCount=20;
              }
          }
          catch(NumberFormatException nFE)
          {
              printString("Invalid throw count. Set to default, 20\n");
              throwCount=20;
          }
          */
          startMatch();
          return -1;
      }
    if(parceMe.equals("2")|| parceMe.equalsIgnoreCase("help"))
      {
          displayHelp();
          return -1;
      }
    if(parceMe.equals("3")|| parceMe.equalsIgnoreCase("score"))
      {
          displayScore();
          return -1;
      }
    if(parceMe.equals("4"))
      {
          while(true)
            {printString("Enter ai level - random or smart: ");
             boolean temp=setAiType(in.nextLine());
             if(temp)
               {break;}
             printString("Invalid AI type.\n");
            } 
          while(true)
            {printString("Enter the throw count: ");
             boolean temp=setThrowCount(in.nextLine());
             if(temp)
               {break;}
             printString("Invalid value. Enter a positive, nonzero integer value.\n");
            }
       return -1;
      }
    if(parceMe.equals("5")|| parceMe.equalsIgnoreCase("quit"))
      {
          printString("Thanks for playing! Goodbye!\n\n");
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
   {
       if(printMe==null)
      {
          return false;
      }
        System.out.print(printMe);
        return true;
   }

/**
 * Displays a help message.
 */
 private static void displayHelp()
   {
       printString("==========HELP PAGE==========\n");
       printString("A match consists of one or more rounds.\n");
       printString("To play a round, select either Rock, Paper, or Scissors.\n");
       printString("The computer will choose one of the same choices at random.\n");
       printString("The winner is determined as follows:\n");
       printString("  -Rock crushes Scissors\n");
       printString("  -Scissors cuts Paper\n");
       printString("  -Paper covers Rock\n");
       printString("The player with the most wins at the end of "
            + "the match is the winner!\n\n");
   }

 /**
  * Displays the score. Gotten from the match most likely.
  */
 private static void displayScore()
   {
     if(current!=null)//if current is null it's not inside a match, so don't
                           //display the match-specific stats
      {
           int[] temp=current.getStats();
           printString("\n===Stats for the current match===\n");
           printString("Player 1 wins: "+temp[0]+"\n");
           printString("Computer wins: "+temp[1]+"\n");
           printString("Ties: "+temp[2]+"\n");
           printString("Current match progress: "+current.getThrowCount()
                +" of "+throwCount+" throws left.\n");
           
      }
    else
    {
        printString("\nMatch length: "+throwCount+"\n");
    }
    printString("AI type: ");
    switch(aiType)
    {
        case 0: printString("Random");
               break;
        case 1: printString("Smart");
               break;
        case 2: printString("Genius");
               break;
        default: printString("This is impossible. Fix this.");
    }
    printString("\n");
    
    Stats temp=player1.getStats();
    printString("\n===Player stats===\n");
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
 private void throwStore(Queue t, ComputerPlayer p) 
 {
     String temp = "";
     while (t.peek() != null)
     {
         temp += t.poll();
     }
 }
 
 static private boolean setAiType(String s)
   {
    boolean success=false;
    if(s.equalsIgnoreCase("RANDOM"))
      {
       ((ComputerPlayer) player2).setAI(0);
       success=true;
      }
    if(s.equalsIgnoreCase("SMART"))
      {((ComputerPlayer) player2).setAI(0);
       success=true;
      }
    return success;
   }
 
 static private boolean setThrowCount(String s)
   {boolean success=false;
    int number;
    try{number=Integer.parseInt(s);}
    catch(Exception e)
      {number=0;}
    if (number>0)
      {throwCount=number;
       success=true;
      }
    return success;
   }
 
 private static int gestureToInt(Gesture g)
   {
    if(g.name().equals("ROCK"))
      {return 0;
      }
    else if(g.name().equals("PAPER"))
      {return 1;
      }
    else if(g.name().equals("SCISSORS"))
      {return 2;
      }
    else
      {return -1;
      }
   }
 
 private static Gesture intToGesture(int i)
   {switch(i)
     {case 0:return Gesture.ROCK;
      case 1:return Gesture.PAPER;
      case 2:return Gesture.SCISSORS;
      
      default: return Gesture.NONE;
     }
   }
}
