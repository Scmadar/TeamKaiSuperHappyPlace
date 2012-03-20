package RPS;
/**
 * This abstract class calculates computer throw by random or by a specific 
 * algorithm
 * @author KAI
 */
public abstract class ThrowCalculator
{
    private String throwrec = "";
    abstract int calculatethrow();
    
    void matchRec(String str)
    {
        throwrec += str;
    }
}
