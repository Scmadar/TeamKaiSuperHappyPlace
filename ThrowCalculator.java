package RPS;
/**
 * This abstract class calculates computer throw by random or by a specific 
 * algorithm
 * @author KAI
 */
public abstract class ThrowCalculator
{
    private String throwrec = "";
    /**
     * Factory method to create object of RandomThrow or SmartThrow at run time
     * @param level AI level, either random or smart
     * @return new object of either Random or SmartThrow
     */
    public static ThrowCalculator makeCalculator(String level) 
    {
        if (level.equalsIgnoreCase("random"))
            return new RandomThrow();
        else if (level.equalsIgnoreCase("smart"))
            return new SmartThrow();
        //default is random
        return new RandomThrow();
    }
    /**
     * Abstract method to calculate computer throw
     */
    abstract int calculatethrow();
    
    void matchRec(String str)
    {
        throwrec += str;
    }
}
