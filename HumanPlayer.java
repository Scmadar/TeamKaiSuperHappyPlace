package RPS;

import java.util.Scanner;

/**
 * A class that represents human player of the RPS game, this implements the abstract Player class.
 * @author KAI
 */
public class HumanPlayer extends Player
{
    Scanner in=new Scanner(System.in);
    Parser parser = new ParseCommandLine();
  public HumanPlayer()
    {stats=new Stats();
    }

    /**
     * This returns the throw for this player, or a -1 if the throw is read from
     * another location or an error occurs.
     * @return the throw for this player.
     */
    @Override
    int getThrows()
    {
        return parser.parceCommand(getCommand());
    }

     private String getCommand()
   {
     return in.nextLine();
   }
}