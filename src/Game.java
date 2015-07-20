import java.util.HashMap;
import java.util.Map;

public class Game {
    int turn=1;
    Map<Integer, Integer> playerLocation = new HashMap<Integer, Integer>();
	
    public void play()	
	{
		playerLocation.put(1, 0); // initial location of player 1
		playerLocation.put(2, 0); // initial location of player 2
		
		while(isGameOver(playerLocation)==99999)
		   checkTurnNMove(playerLocation);
	}

    protected int isGameOver(Map<Integer, Integer> loc1) {					//check for winner
        if((int)loc1.get(1)>=100)
        {
			System.out.println("Player 1 Wins");
        	return turn;
		
        }
         else if((int)loc1.get(2)>=100)
         {
             System.out.println("Player 2 Wins");
             return turn;
         }
        return 99999;
    }

	protected int checkTurnNMove(Map<Integer, Integer> loc1) {
		
		int loc=0;		
		if(turn==1)			// player 1's turn
		{
			int x= Dice.diceOut();
			System.out.println("Player: " +turn + " Dice Output: "+x );
			loc1.put(1, (int) loc1.get(1)+x);
			loc=(int) loc1.get(1);
			System.out.println("Player: " +turn +" at position: "+loc);
		    loc = checkSnake(loc);
		    loc = checkLadder(loc);
			loc1.put(turn, loc);
			turn=2;
		}
		else if(turn==2)    // player 2's turn
		{
			int y= Dice.diceOut();
	        System.out.println("Player: " +turn + " Dice Output: "+y );
			loc1.put(2, (int)loc1.get(2)+y);
			loc=(int) loc1.get(2);
			System.out.println("Player: " +turn +" at position: "+loc);
            loc = checkSnake(loc);
            loc = checkLadder(loc);
            loc1.put(turn, loc);
			turn=1;
		}
		return loc;
	}
			
	protected int checkLadder(int currentPosition) {				//checking for ladder at obtained position
		Map<Integer, Integer> ladder = new HashMap<Integer, Integer>();
		ladder.put(4, 14);
		ladder.put(9, 31);
		ladder.put(20, 38);
		ladder.put(28, 84);
		ladder.put(40, 59);
		ladder.put(51, 67);
		ladder.put(63, 81);
		ladder.put(71, 91);
		
		if (ladder.containsKey(currentPosition))
		{
			currentPosition=(int) ladder.get(currentPosition);
			System.out.println("Climbing Ladder, Moved up at Position : "+currentPosition );
			playerLocation.put(turn, currentPosition);
			return currentPosition;
		}
		return currentPosition;
	}

	protected int checkSnake(int currentPosition) {				//checking for Snake at obtained position
		Map<Integer, Integer> snake = new HashMap<Integer, Integer>();
		snake.put(17, 7);
		snake.put(54, 34);
		snake.put(62, 19);
		snake.put(64, 60);
		snake.put(87, 24);
		snake.put(93, 73);
		snake.put(95, 75);
		snake.put(99, 78);
		if (snake.containsKey(currentPosition))
		{	

			currentPosition=(int) snake.get(currentPosition);
			System.out.println("Snake Bitten, Moved Down to Position : "+currentPosition );
			playerLocation.put(turn, currentPosition);
			return currentPosition;
		}
		return currentPosition;	
	}

	public static void main (String args[])
		{
			Game game =new Game();
			game.play();
		}	
}
