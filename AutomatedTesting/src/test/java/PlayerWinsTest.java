import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PlayerWinsTest {
	
	BlackJack blackjack = new BlackJack();
	
	@Test
	public void dealerBust() {
		assertEquals("Player beat dealer, dealer > 21", 21, blackjack.play(21,23));
	}
	
	@Test
	public void PlayerGreaterThanDealer() {
		assertEquals("Player beat dealer, dealer < player", 18, blackjack.play(18, 16));
	}
	
}
