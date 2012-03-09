package RPS;
/**
 * A basic class that keeps track of a players score-related information
 *        within a rock paper scissors game.
 * @author KAI
 */
public class Stats
{
    private int wins,losses,ties=0; //various counters to keep track
                //of game record


    /**
     * This increments the amount of wins that a player has.
     */
    public void incrementWins()
    {
        wins++;
    }

    /**
     * This increments the amount of losses that a player has.
     */
    public void incrementLosses()
    {
        losses++;
    }

    /**
     * This increments the amount of ties that a player has.
     */
    public void incrementTies()
    {
        ties++;
    }

    /**
     * This returns the amount of ties that a player has.
     * @return the amount of ties that a player has.
     */
    public int getTies()
    {
        return ties;
    }

    /**
     * This returns the number of wins that a player has.
     * @return the amount of ties that a player has.
     */
    public int getWins()
    {
        return wins;
    }

    /**
     * This returns the number of losses that a player has.
     * @return the number of losses that a player has.
     */
    public int getLosses()
    {
        return losses;
    }

    /**
     * This resets the wins,ties, and losses counters to zero.
     */
    public void resetWinsLossesTies()
    {
        wins=0;
        ties=0;
        losses=0;
    }

    /**
     * This resets the wins counter to zero.
     */
    public void resetWins()
    {
        wins=0;
    }

    /**
     * This resets the ties counter to zero.
     */
    public void resetTies()
    {
        ties=0;
    }

    /**
     * This resets the losses counter to zero.
     */
    public void resetLosses()
    {
        losses=0;
    }


}