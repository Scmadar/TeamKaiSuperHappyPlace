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
        if (Integer.parseInt(level) == 1)
        {
            System.out.println("\nAI Level 1 (Random).");
            return new RandomThrow();
        }           
        else if (Integer.parseInt(level) == 2)
        {
            System.out.println("\nAI Level 2 (Smart).");
            return new SmartThrow();
        }
        else
        {
            System.out.println("Invalid input. AI level is set to default.");
            System.out.println("\nAI Level 1 (Random).");
        }
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
