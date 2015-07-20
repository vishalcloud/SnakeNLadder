import static org.junit.Assert.*;

import org.junit.Test;


public class TestDice {

	@Test
	public void testDiceOut() {
				int n = Dice.diceOut();
		assertTrue(n<7 && n>0);
		
	}

}
