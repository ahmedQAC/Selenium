import static org.junit.Assert.*;

import org.junit.Test;

public class BlackJackTest {

	BlackJack blackjack = new BlackJack();
	@Test
	public void test() {
		
		
//		assertEquals(10, blackjack.play(10,22));
//		assertEquals(9, blackjack.play(22,9));
//		assertEquals(0, blackjack.play(22,22));
//		assertEquals(10, blackjack.play(10,7));
//		assertEquals(19, blackjack.play(1,19));	
	}
	
	@Test
	public void test1() {
		assertEquals("Player beat dealer, dealer > 21", 21, blackjack.play(21,23));
	}
	
	@Test
	public void test2() {
		assertEquals("Player beat dealer, dealer < player", 18, blackjack.play(18, 16));
	}
	
	@Test
	public void test3() {
		assertEquals("Player value > 21, dealer value > 21", 0, blackjack.play(15, 20));
	}
	
	@Test
	public void test4() {
		assertEquals("Player value > 21, dealer value <21", 15, blackjack.play(25, 15));
	}
	
	@Test
	public void test5() {
		assertEquals("Player value < dealer value", 20, blackjack.play(15, 20));
	}
	
	@Test
	public void test6() {
		assertEquals("Invalid entry", -1, blackjack.play(-30, 10));
	}
}

	
