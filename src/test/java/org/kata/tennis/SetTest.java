package org.kata.tennis;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SetTest {

	private final String NADAL = "NADAL";
	private final String FEDERER = "FEDERER";

	private Player playerA = new Player(NADAL);
	private Player playerB = new Player(FEDERER);

	@Test
	public void testHasWinner() {
		Set set = new Set(0, playerA, 0, playerB, 0);
		Game game = new Game(10, playerA, 6, playerB, 4);
		set.getGames().add(game);

		assertTrue(set.hasWinner());
	}

	@Test
	public void testNoWinner() {
		Set set = new Set(0, playerA, 0, playerB, 0);
		Game game = new Game(11, playerA, 6, playerB, 5);
		set.getGames().add(game);

		assertFalse(set.hasWinner());
	}

	@Test
	public void testStart() {
		Set set = new Set(0, playerA, 0, playerB, 0);

		set.start();

		assertNotNull(set.getNameOfWinner());
		assertTrue(set.getScoreA() > 0 || set.getScoreB() > 0);
		assertTrue(set.getNextIteration() > 0);
	}
}
