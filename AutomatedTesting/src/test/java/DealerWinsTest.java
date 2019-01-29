import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DealerWinsTest {

	BlackJack blackjack = new BlackJack();

	@Test
	public void bothBust() {
		assertEquals("Player value > 21, dealer value > 21", 23, blackjack.play(22, 23));
	}
	
	@Test
	public void playerBust() {
		assertEquals("Player value > 21, dealer value <21", 15, blackjack.play(25, 15));
	}
	
	@Test
	public void playerValueLessThanDealer() {
		assertEquals("Player value < dealer value", 20, blackjack.play(15, 20));
	}
}
