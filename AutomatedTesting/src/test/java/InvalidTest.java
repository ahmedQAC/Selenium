import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class InvalidTest {
	
	BlackJack blackjack = new BlackJack();

	@Test
	public void negativeEntry() {
		assertEquals("Invalid entry", -1, blackjack.play(-30, 10));
	}
}
