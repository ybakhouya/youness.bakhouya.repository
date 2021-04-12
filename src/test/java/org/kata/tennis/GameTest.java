/**
 * 
 */
package org.kata.tennis;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author CGFIDS-E
 *
 */
public class GameTest {

	private final String NADAL = "NADAL";
	private final String FEDERER = "FEDERER";

	private Player playerA = new Player(NADAL);
	private Player playerB = new Player(FEDERER);

	@Test
	public void testHasWinner() {
		Game game = new Game(0, playerA, 0, playerB, 0);
		Point point = new Point(6, playerA, 4, playerB, 2);
		game.getPoints().add(point);

		assertTrue(game.hasWinner());
	}

	@Test
	public void testNoWinner() {
		Game game = new Game(0, playerA, 0, playerB, 0);
		Point point = new Point(6, playerA, 4, playerB, 3);
		game.getPoints().add(point);

		assertFalse(game.hasWinner());
	}
	
	@Test
	public void testStart() {
		Game game = new Game(0, playerA, 0, playerB, 0);
		
		game.start();

		assertNotNull(game.getNameOfWinner());
		assertTrue(game.getScoreA() > 0 || game.getScoreB() > 0);
		assertTrue(game.getNextIteration() > 0);
	}
}
