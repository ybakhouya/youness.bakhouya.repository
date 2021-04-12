package org.kata.tennis;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void testShootBall() {
		Player player = new Player("NADAL");

		assertTrue(player.shootBall() >= 50);
	}
}
