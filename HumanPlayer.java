/**
 * A class that represents one player of the RPS game, this implements the abstract Player class.
 * @author KAI
 */
public class HumanPlayer extends Player
{

    /**
     * This returns the throw for this player, or a -1 if the throw is read from 
     * another location or an error occurs.
     * @return the throw for this player or -1.
     */
    int getThrows()
    {
        return -1;
    }

}
