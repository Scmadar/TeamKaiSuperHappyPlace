package RPS;
import java.util.Random;
/**
 * This class extends ThrowCalculator and calculate computer choice by random
 * @author KAI
 */
public class RandomThrow extends ThrowCalculator {

     Random random=new Random();

    @Override
    int calculatethrow()
    {
        int computerChoice=random.nextInt(3);
        return computerChoice;
    }
}
