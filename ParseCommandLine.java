package RPS;

/**
 * This class extends Parser and get human player choice from command prompt
 * @author KAI
 */
public class ParseCommandLine extends Parser
{

    @Override
    int parceCommand(String parceMe)
    
    {
       if(parceMe==null)
      {
          return -1;
      }
    if(parceMe.equalsIgnoreCase("rock"))
      {
          return 0;
      }
    else if(parceMe.equalsIgnoreCase("paper"))
      {
          return 1;
      }
    else if(parceMe.equalsIgnoreCase("scissors"))
      {
          return 2;
      }
    else if(parceMe.equalsIgnoreCase("HELP")||
          parceMe.equalsIgnoreCase("H"))
      {
          return 3;
      }
    else if(parceMe.equalsIgnoreCase("score"))
      {
          return 4;
      }
    else if(parceMe.equalsIgnoreCase("quit"))
      {
          return 5;
      }
    return -1; //if it got past return an error
    }    
}
