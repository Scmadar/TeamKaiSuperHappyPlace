package RPS;
/**
 * This abstract class calculates computer throw by random or by a specific 
 * algorithm
 * @author KAI
 */
public abstract class ThrowCalculator
{
    private int historyLength=50; //
    String throwrec = "";
    int prediction=-1;
    /**
     * Factory method to create object of RandomThrow or SmartThrow at run time
     * @param level AI level, either random or smart
     * @return new object of either Random or SmartThrow
     */
    public static ThrowCalculator makeCalculator(int level) 
    {
        switch(level)
        {
            case 0:
                //System.out.println("\nAI Level 1 (Random).");
                return new RandomThrow();

            case 1:
                //System.out.println("\nAI Level 2 (Smart).");
                return new SmartThrow();

            case 2:
                return new GeniusThrow();
              
              
            default:
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
        if(throwrec.length()>historyLength)
          {throwrec=throwrec.substring(throwrec.length()-historyLength,throwrec.length());
          }
        //System.out.println(throwrec); //debugging statement
    }
     
    public int getPrediction()
      {return prediction;}
    
    public void setHistoryLength(int setMe)
      {if(setMe>0)
         {historyLength=setMe;}
      }
}