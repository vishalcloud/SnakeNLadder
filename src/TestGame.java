import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import junit.framework.TestCase;


public class TestGame extends TestCase {
	Map<Integer, Integer> loc = new HashMap<Integer, Integer>();
	@Test
	public void testCheckLadder(){
		Game newGame =new Game();
		assertEquals(14, newGame.checkLadder(4));
		assertEquals(31, newGame.checkLadder(9));
		assertEquals(38, newGame.checkLadder(20));
		assertEquals(84, newGame.checkLadder(28));
		assertEquals(59, newGame.checkLadder(40));
		assertEquals(67, newGame.checkLadder(51));
		assertEquals(81, newGame.checkLadder(63));
		assertEquals(91, newGame.checkLadder(71));
	}
	
	@Test
	public void testcheckSnake(){
		Game newGame =new Game();
		assertEquals(7, newGame.checkSnake(17));
		assertEquals(34, newGame.checkSnake(54));
		assertEquals(19, newGame.checkSnake(62));
		assertEquals(60, newGame.checkSnake(64));
		assertEquals(24, newGame.checkSnake(87));
		assertEquals(73, newGame.checkSnake(93));
		assertEquals(75, newGame.checkSnake(95));
		assertEquals(78, newGame.checkSnake(99));
		
	}
	

	@Test
	public void testplayer1Wins(){
		Game newGame =new Game();
		loc.put(1, 102);
		loc.put(2, 44);
			assertEquals(1, newGame.isGameOver(loc));
	}
	
	@Test
	public void testplayer2Wins(){
		Game newGame =new Game();
		newGame.turn=2;
		loc.put(2, 102);
		loc.put(1, 45);
		System.out.println(loc);
			assertEquals(2, newGame.isGameOver(loc));
			
	}
	@Test
	public void testNobodyWins(){
		Game newGame =new Game();
		loc.put(1, 88);
		loc.put(2, 40);
			assertEquals(99999, newGame.isGameOver(loc));
	}
		
}
	

