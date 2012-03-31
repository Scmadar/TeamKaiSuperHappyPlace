package RPS;
/**
 * A class that represents computer player of the RPS game, this implements the abstract Player class.
 * @author KAI
 */

public class ComputerPlayer extends Player
{
    ThrowCalculator throwcalc;
    
    
    public ComputerPlayer()
    {
        stats=new Stats();
    }
    /**
     * Set the AI level
     * @param level AI level, either random or smart
     */
    
    public void setAI(String level)
    {
        throwcalc = ThrowCalculator.makeCalculator(level);
    }
    
    /**
     * This returns the throw for computer player
     * @return the throw for computer
     */
    @Override
    int getThrows()
    {
        int choice=throwcalc.calculatethrow();
        choice++;
        if(choice==3)
          {choice=0;}
        return choice;
    }
    
    @Override
    void setMatchRec(String str) 
    {
        throwcalc.matchRec(str);
    }
}