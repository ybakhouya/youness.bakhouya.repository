/**
 * 
 */
package org.kata.tennis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.kata.tennis.enumeration.PointEnum;

/**
 * @author CGFIDS-E
 *
 */
public class PointTest {

	private final String NADAL = "NADAL";
	private final String FEDERER = "FEDERER";

	private Player playerA = new Player(NADAL);
	private Player playerB = new Player(FEDERER);

	@Test
	public void testNewPointShouldReturnZero() {
		Point point = new Point(0, playerA, 0, playerB, 0);

		assertEquals(PointEnum.ZERO.valurOf(), point.getLabelOfScoreA());
		assertEquals(PointEnum.ZERO.valurOf(), point.getLabelOfScoreB());
	}

	@Test
	public void testGameShouldReturnFifteen() {

		Point point = new Point(1, playerA, 1, playerB, 0);
		assertEquals(PointEnum.FIFTEEN.valurOf(), point.getLabelOfScoreA());
		assertEquals(PointEnum.ZERO.valurOf(), point.getLabelOfScoreB());

		point = new Point(2, playerA, 1, playerB, 1);
		assertEquals(PointEnum.FIFTEEN.valurOf(), point.getLabelOfScoreA());
		assertEquals(PointEnum.FIFTEEN.valurOf(), point.getLabelOfScoreB());

	}

	@Test
	public void testGameShouldReturnThirty() {
		Point point = new Point(4, playerA, 2, playerB, 2);

		assertEquals(PointEnum.THIRTY.valurOf(), point.getLabelOfScoreA());
		assertEquals(PointEnum.THIRTY.valurOf(), point.getLabelOfScoreB());
	}

	@Test
	public void testGameShouldReturnForty() {
		Point point = new Point(6, playerA, 3, playerB, 3);

		assertEquals(PointEnum.FORTY.valurOf(), point.getLabelOfScoreA());
		assertEquals(PointEnum.FORTY.valurOf(), point.getLabelOfScoreB());
	}

	@Test
	public void testGameShouldReturnAdvantageA() {
		Point point = new Point(7, playerA, 4, playerB, 3);

		assertEquals(PointEnum.ADVANTAGE.valurOf(), point.getLabelOfScoreA());
		assertEquals(PointEnum.FORTY.valurOf(), point.getLabelOfScoreB());
	}

	@Test
	public void testGameShouldReturnDeuce() {
		Point point = new Point(8, playerA, 4, playerB, 4);

		assertEquals(PointEnum.DEUCE.valurOf(), point.getLabelOfScoreA());
		assertEquals(PointEnum.DEUCE.valurOf(), point.getLabelOfScoreB());
	}

	@Test
	public void testGameShouldReturnAdvantageB() {
		Point point = new Point(9, playerA, 4, playerB, 5);

		assertEquals(PointEnum.FORTY.valurOf(), point.getLabelOfScoreA());
		assertEquals(PointEnum.ADVANTAGE.valurOf(), point.getLabelOfScoreB());
	}

	@Test
	public void testGameShouldReturnWinB() {
		Point point = new Point(10, playerA, 4, playerB, 6);

		assertEquals(PointEnum.LOSER.valurOf(), point.getLabelOfScoreA());
		assertEquals(PointEnum.WINNER.valurOf(), point.getLabelOfScoreB());
	}

	@Test
	public void testGameShouldReturnWinA() {
		Point point = new Point(4, playerA, 4, playerB, 0);

		assertEquals(PointEnum.WINNER.valurOf(), point.getLabelOfScoreA());
		assertEquals(PointEnum.ZERO.valurOf(), point.getLabelOfScoreB());
	}

	@Test
	public void testHasWinner() {
		Point point = new Point(0, playerA, 0, playerB, 0);
		assertTrue(point.hasWinner());
	}

	@Test
	public void testUpdateWinnerPlayerA() {
		Point point = new Point(0, playerA, 0, playerB, 0);

		assertTrue(point.updateWinner(1, 0));
		assertTrue(point.getScoreA() == 1);
		assertTrue(point.getScoreB() == 0);
		assertEquals(NADAL, point.getNameOfWinner());
	}

	@Test
	public void testUpdateWinnerPlayerB() {
		Point point = new Point(2, playerA, 1, playerB, 1);

		assertTrue(point.updateWinner(1, 2));
		assertTrue(point.getScoreA() == 1);
		assertTrue(point.getScoreB() == 2);
		assertEquals(FEDERER, point.getNameOfWinner());
	}

	@Test
	public void testStart() {
		Point point = new Point(0, playerA, 0, playerB, 0);

		point.start();

		assertNotNull(point.getNameOfWinner());
		assertTrue(point.getScoreA() > 0 || point.getScoreB() > 0);
		assertTrue(point.getNextIteration() > 0);
	}
}
