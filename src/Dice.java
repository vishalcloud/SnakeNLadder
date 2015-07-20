import java.util.Random;

public class Dice {
    public static int diceOut()              //Rolling dice to get any one random output from 1 to 6 
  	{
        Random throwDice = new Random();
        int outputNumber = throwDice.nextInt(6)+1;
        return outputNumber;
	}
}


