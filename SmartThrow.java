package RPS;
import java.util.*;
/**
 * This class extends ThrowCalculator and calculates the computer's choice 
 *    using a fancy algorithm
 * @author KAI
 */
public class SmartThrow extends ThrowCalculator 
{
    private int n;
    private String throwRecord;
    private Random rng=new Random();
    
    /**
     * Constructor, initializes throwRecord to zero. Should work.
     */
    public SmartThrow()
      {throwRecord="";}
    
    
    /**
     * Method to calculate computer throw using smart algorithm
     * @Return computer throw
     */
    @Override
    public int calculatethrow() 
      {int results[]={0,0,0};
       for(n=2;n<=5;n++)
         {int[] temp=splitAndWeight(n);
          for(int i=0;i<results.length;i++)
            {temp[i]*=n; //sorry about your foreach loop
             results[i]+=temp[i];
            }
         }
       if(results[0]==results[1]&&results[1]==results[2])
         {return rng.nextInt(3); //0-2 inclusive
         }
       int max=Math.max(results[0],results[1]);
       int indexOfMax;
       if(results[0]==max)
         {indexOfMax=0;}
       else
         {indexOfMax=1;}
       max=Math.max(max,results[2]);
       if(results[indexOfMax]!=max)
         {indexOfMax=2;}
       for(int i=0;i<results.length;i++)  //There's probably a cleaner way to
         {if(results[i]==max&&i!=indexOfMax)   //do this
           {int temp=rng.nextInt(2); //0-1 inclusive
            if(temp==0)
              {return indexOfMax;}
            else
              {return i;}
           }
         }
       return indexOfMax;
      }
    
    private int[] splitAndWeight(int n)
      {int[] results={0,0,0};
       if(throwRecord.length()<n)
         {return results;}
       for(int i=0;i<3;i++)
         {String theEnd=throwRecord.substring(throwRecord.length()+1-n,
                                  throwRecord.length());
          String charToAdd;
          switch(i)
            {case 0:charToAdd="R";
                break;
             case 1:charToAdd="P";
                break;
             case 2:charToAdd="S";
                break;
             default: charToAdd="";
            }
          theEnd+=charToAdd;
          int bionicImmortalZombieMonkeys=n%2;
          while(bionicImmortalZombieMonkeys!=-1)
            {bionicImmortalZombieMonkeys=throwRecord.indexOf(theEnd,
                         bionicImmortalZombieMonkeys);
             if(bionicImmortalZombieMonkeys%2==n%2) ///check this
               {results[i]++;
                bionicImmortalZombieMonkeys+=2;
               }
             else
               {bionicImmortalZombieMonkeys++;
               }
            }
         }
       return results;
      }
}
