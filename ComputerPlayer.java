package RPS;
/**
 * A class that represents computer player of the RPS game, this implements the abstract Player class.
 * @author KAI
 */

public class ComputerPlayer extends Player
{
    ThrowCalculator throwcalc=new RandomThrow();

    public ComputerPlayer()
    {
        stats=new Stats();
    }
  
    /**
     * This returns the throw for computer player
     * @return the throw for computer
     */
    @Override
    int getThrows()
    {
        return throwcalc.calculatethrow();
    }
    
    void setMatchRec(String str) 
    {
        throwcal.matchRec(str);
    }
}