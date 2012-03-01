/**
 * This is an abstract class that defines shared behavior for both the Computer and Human players.
 * @author KAI
 */
public abstract class Player
{
    private Stats stats;


    /**
     * Returns the status object associated with the player class.
     * @return the status object associated with the player class.
     */
    public Stats getStats()
    {
        return this.stats;
    }

    /**
     * A method that returns a players throw, or choice of move for a round.
     * @return a player's throw or choice of a move for a round. -1 if there is an error.
     */
    abstract int getThrows();



}
