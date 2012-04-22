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
    private Random rng=new Random();
    
    /**
     * Constructor, initializes throwrec to the empty string.
     */
    public SmartThrow()
      {
       //System.out.println("Hi there.");//debugging statement
       throwrec="";
      }
    
    
    /**
     * Method to calculate computer throw using smart algorithm
     * @Return computer throw
     */
    @Override
    public int calculatethrow() 
      {
          int results[]={0,0,0};
          for(n=2;n<=5;n++)
          {
              int[] temp=splitAndWeight(n);
              for(int i=0;i<results.length;i++)
              {
                  temp[i]*=n; //sorry about your foreach loop
              results[i]+=temp[i];
              }
          }
          if(results[0]==results[1]&&results[1]==results[2])
          {
              prediction=-1;
              return rng.nextInt(3); //0-2 inclusive
          }
          int max=Math.max(results[0],results[1]);
          int indexOfMax;
          if(results[0]==max)
          {
             indexOfMax=0;
          }
          else
          {
              indexOfMax=1;
          }
          max=Math.max(max,results[2]);
          if(results[indexOfMax]!=max)
          {
              indexOfMax=2;
          }
          for(int i=0;i<results.length;i++)  //There's probably a cleaner way to
          {                                         //do this
              if(results[i]==max&&i!=indexOfMax)
              {
                  int temp=rng.nextInt(2); //0-1 inclusive
                  if(temp==0)
                  {
                      prediction=indexOfMax;
                      return prediction;
                  }
                  else
                  {
                      prediction=i;
                      return prediction;
                  }
              }
         }
          prediction=indexOfMax;
          return prediction;
      }
    ///I'm not convinced this is working properly, in a 30 round match I got
       /// a score of 11/15/4 W/L/T, while spamming rock. Perhaps it just isn't
       /// too smart after all, but still... I'll debug it later.
    private int[] splitAndWeight(int n)
    {
        int[] results={0,0,0};
        if(throwrec.length()<n)
        {
            //System.out.println("Too short. "+throwrec.length()+" "+n); //debugging statement
            return results;
        }
        for(int i=0;i<3;i++)
        {
            String theEnd=throwrec.substring(throwrec.length()+1-n,
                                  throwrec.length());
            String charToAdd;
            switch(i)
               {
                case 0: charToAdd="r";
                    break;
                case 1: charToAdd="p";
                    break;
                case 2: charToAdd="s";
                    break;
                default: charToAdd="?";
               }
            theEnd+=charToAdd;
            //System.out.println("theEnd: "+theEnd); //debugging statement
            int bionicImmortalZombieMonkeys=n%2;
            //System.out.println(bionicImmortalZombieMonkeys); //debugging statement
            while(bionicImmortalZombieMonkeys!=-1)
               {
               //System.out.println("bizm: "+bionicImmortalZombieMonkeys); //debugging statement
                int temp=throwrec.indexOf(theEnd,
                         bionicImmortalZombieMonkeys);
                //System.out.println("indexof: "+temp+" "+theEnd+" "+throwrec); //debugging statement
                bionicImmortalZombieMonkeys=temp;
                if(bionicImmortalZombieMonkeys==-1)
                  {
                   //System.out.println("No occurences found."); //debugging statement
                   break;
                  }
                //finds the index of the next match. ^^
                if(true) ///check this bionicImmortalZombieMonkeys%2==n%2
                {//if bizm is the same... even/odd-ness as n, the result should
                  // be that the last char in the matched string has an odd
                  // index, meaning it was the other player's choice.
                    //System.out.println("Updated the array!~"); //debugging statement
                    results[i]++;
                    //System.out.println(results[i]); //debugging statement
                    bionicImmortalZombieMonkeys+=2;
                }
                else //if they aren't the same, skip it and go on to the next.
                {
                    bionicImmortalZombieMonkeys++;
                }
            }
        }
        return results;
    }
}
