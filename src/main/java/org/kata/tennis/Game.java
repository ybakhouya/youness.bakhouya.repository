/**
 * 
 */
package org.kata.tennis;

import java.util.ArrayList;
import java.util.List;

/**
 * class game extends point
 * 
 * @author YOUBAKHO
 *
 */
public class Game extends Point {

	private List<Point> points;

	/**
	 * 
	 * @param iteration
	 * @param playerA
	 * @param scoreA
	 * @param playerB
	 * @param scoreB
	 * @param points
	 */
	public Game(int iteration, Player playerA, int scoreA, Player playerB, int scoreB) {
		super(iteration, playerA, scoreA, playerB, scoreB);
		this.points = new ArrayList<>();
		Point firstPoint = new Point(0, playerA, 0, playerB, 0);
		points.add(firstPoint);
	}

	/**
	 * start the game
	 */
	@Override
	public void start() {
		boolean isPlaying = true;
		while (isPlaying) {
			Point lastPoint = getLastPoint();
			if (hasWinner() && this.updateWinner(lastPoint.getScoreA(), lastPoint.getScoreB())) {
				isPlaying = false;
			} else {
				Point nextPoint = new Point(lastPoint.getNextIteration(), getPlayerA(), lastPoint.getScoreA(),
						getPlayerB(), lastPoint.getScoreB());
				nextPoint.start();
				points.add(nextPoint);
			}
		}
	}

	/**
	 * has winner this game
	 * 
	 * @return boolean
	 */
	@Override
	public boolean hasWinner() {
		Point lastPoint = getLastPoint();
		return (lastPoint.getScoreA() > 3 || lastPoint.getScoreB() > 3)
				&& Math.abs(lastPoint.getScoreA() - lastPoint.getScoreB()) >= 2;
	}

	/**
	 * get the last point in the game
	 * 
	 * @return Point
	 */
	private Point getLastPoint() {
		return points.get(points.size() - 1);
	}

	/**
	 * @return the pointProxies
	 */
	public List<Point> getPoints() {
		return points;
	}

	/**
	 * @param pointProxies
	 *            the pointProxies to set
	 */
	public void setPoints(List<Point> points) {
		this.points = points;
	}

	@Override
	public String toString() {
		if (getNameOfWinner() == null)
			return "";
		StringBuilder gameBuilder = new StringBuilder();

		points.forEach(gameBuilder::append);

		gameBuilder.append("\n").append("Score Game : " + getScoreA() + " - " + getScoreB()).append("\n");
		gameBuilder.append("****** Game Status : " + getNameOfWinner() + " win").append("\n");
		gameBuilder.append("****** END GAME : " + getIteration()).append("\n").append("\n");

		return gameBuilder.toString();
	}
}
