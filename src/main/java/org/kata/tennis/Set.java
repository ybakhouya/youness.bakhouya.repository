/**
 * 
 */
package org.kata.tennis;

import java.util.ArrayList;
import java.util.List;

/**
 * class set extends point
 * 
 * @author YOUBAKHO
 *
 */
public class Set extends Point {

	private List<Game> games;

	private List<TieBreakPoint> tieBreakPoints;

	public Set(int iteration, Player playerA, int scoreA, Player playerB, int scoreB) {
		super(iteration, playerA, scoreA, playerB, scoreB);
		this.games = new ArrayList<>();
		Game firstGame = new Game(0, playerA, 0, playerB, 0);
		games.add(firstGame);
	}

	/**
	 * start set
	 */
	@Override
	public void start() {
		boolean isPlaying = true;
		while (isPlaying) {
			Game lastGame = getLastGame();
			if (hasWinner() && this.updateWinner(lastGame.getScoreA(), lastGame.getScoreB())) {
				isPlaying = false;
			} else if (isTieBreakActive()) {
				isPlaying = startTieBreak();
			} else {
				Game nextGame = new Game(lastGame.getNextIteration(), getPlayerA(), lastGame.getScoreA(), getPlayerB(),
						lastGame.getScoreB());
				nextGame.start();
				games.add(nextGame);
			}
		}
	}

	/**
	 * start tie break
	 * 
	 * @param isPlaying
	 * @return boolean
	 */
	private boolean startTieBreak() {
		boolean isPlaying = true;
		TieBreakPoint lastTieBreakpoint = getLastTieBreakPoint();
		if (lastTieBreakpoint.hasWinner()
				&& this.updateWinner(lastTieBreakpoint.getScoreA(), lastTieBreakpoint.getScoreB())) {
			isPlaying = false;
		} else {
			TieBreakPoint nextPoint = new TieBreakPoint(lastTieBreakpoint.getNextIteration(), getPlayerA(),
					lastTieBreakpoint.getScoreA(), getPlayerB(), lastTieBreakpoint.getScoreB());
			nextPoint.start();
			tieBreakPoints.add(nextPoint);
		}
		return isPlaying;
	}

	/**
	 * has winner set
	 */
	@Override
	public boolean hasWinner() {
		Game lastGame = getLastGame();
		return (lastGame.getScoreA() > 5 || lastGame.getScoreB() > 5)
				&& Math.abs(lastGame.getScoreA() - lastGame.getScoreB()) >= 2;
	}

	/**
	 * is tie break active
	 * 
	 * @return boolean
	 */
	private boolean isTieBreakActive() {
		Game lastGame = getLastGame();
		return lastGame.getScoreA() == 6 && lastGame.getScoreB() == 6;
	}

	/**
	 * 
	 * @return
	 */
	private Game getLastGame() {
		return games.get(games.size() - 1);
	}

	/**
	 * 
	 * @return
	 */
	private TieBreakPoint getLastTieBreakPoint() {
		if (tieBreakPoints == null) {
			tieBreakPoints = new ArrayList<>();
			TieBreakPoint startTieBreak = new TieBreakPoint(0, getPlayerA(), 0, getPlayerB(), 0);
			tieBreakPoints.add(startTieBreak);
		}
		return tieBreakPoints.get(tieBreakPoints.size() - 1);
	}

	/**
	 * @return the gameProxies
	 */
	public List<Game> getGames() {
		return games;
	}

	/**
	 * @param gameProxies
	 *            the gameProxies to set
	 */
	public void setGames(List<Game> games) {
		this.games = games;
	}

	@Override
	public String toString() {
		if (getNameOfWinner() == null)
			return "";
		StringBuilder setBuilder = new StringBuilder();
		setBuilder.append("# Start Set : " + getIteration()).append("\n");

		games.forEach(setBuilder::append);

		if (tieBreakPoints != null) {
			tieBreakPoints.forEach(setBuilder::append);
		}

		setBuilder.append("\n").append(" Score Set : ( " + getScoreA() + " - " + getScoreB() + ")").append("\n");
		setBuilder.append("********* Set Status : " + getNameOfWinner() + " win").append("\n");
		setBuilder.append("****** END SET : " + getIteration()).append("\n").append("\n");

		return setBuilder.toString();
	}
}
