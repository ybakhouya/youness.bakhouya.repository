/**
 * 
 */
package org.kata.tennis;

import org.kata.tennis.enumeration.PointEnum;
import org.kata.tennis.interfaces.PointTemplateInterface;

/**
 * Class Point
 * 
 * @author YOUBAKHO
 *
 */
public class Point implements PointTemplateInterface {

	private int iteration;
	private Player playerA;
	private int scoreA;
	private Player playerB;
	private int scoreB;
	private String nameOfWinner;

	/**
	 * @param iteration
	 * @param playerA
	 * @param scoreA
	 * @param playerB
	 * @param scoreB
	 */
	public Point(int iteration, Player playerA, int scoreA, Player playerB, int scoreB) {
		super();
		this.iteration = iteration;
		this.playerA = playerA;
		this.scoreA = scoreA;
		this.playerB = playerB;
		this.scoreB = scoreB;
	}

	/**
	 * start point
	 */
	@Override
	public void start() {
		boolean isPlaying = true;
		if (getPlayerA() != null && getPlayerB() != null) {
			while (isPlaying) {
				if (hasWinner() && updateWinner(getPlayerA().shootBall(), getPlayerB().shootBall())) {
					isPlaying = false;
				}
			}
		} else {
			System.out.println("les deux joueurs doivent être sur le terain");
		}
	}

	/**
	 * Update the winner
	 * 
	 * @param scorePlayerA
	 * @param scorePlayerB
	 */
	@Override
	public boolean updateWinner(int scorePlayerA, int scorePlayerB) {
		if (scorePlayerA > scorePlayerB) {
			setScoreA(getScoreA() + 1);
			setNameOfWinner(getPlayerA().getName());
			return true;
		} else if (scorePlayerA < scorePlayerB) {
			setScoreB(getScoreB() + 1);
			setNameOfWinner(getPlayerB().getName());
			return true;
		}
		return false;
	}

	/**
	 * get label of score player A
	 * 
	 * @return String
	 */
	public String getLabelOfScoreA() {
		return getScore(getScoreA(), true);
	}

	/**
	 * get label of score player A
	 * 
	 * @return String
	 */
	public String getLabelOfScoreB() {
		return getScore(getScoreB(), false);
	}

	/**
	 * get label of score
	 * 
	 * @param score
	 * @return String
	 */
	private String getScore(int score, boolean isScoreA) {
		switch (score) {
		case 0:
			return PointEnum.ZERO.valurOf();
		case 1:
			return PointEnum.FIFTEEN.valurOf();
		case 2:
			return PointEnum.THIRTY.valurOf();
		case 3:
			return PointEnum.FORTY.valurOf();
		default:
			return getScoreAfterForty(isScoreA);
		}
	}

	/**
	 * @param isScoreA
	 * @return
	 */
	private String getScoreAfterForty(boolean isScoreA) {
		if (isDeuce()) {
			return PointEnum.DEUCE.valurOf();
		} else if (hasAdv()) {
			return getScoreAdvOrForty(isScoreA);
		} else {
			return getScoreWinOrLos(isScoreA);
		}
	}

	/**
	 * @param isScoreA
	 * @return
	 */
	private String getScoreWinOrLos(boolean isScoreA) {
		if (isScoreA) {
			if (getScoreA() > getScoreB()) {
				return PointEnum.WINNER.valurOf();
			} else {
				return PointEnum.LOSER.valurOf();
			}
		} else {
			if (getScoreA() < getScoreB()) {
				return PointEnum.WINNER.valurOf();
			} else {
				return PointEnum.LOSER.valurOf();
			}
		}
	}

	/**
	 * @param isScoreA
	 * @return
	 */
	private String getScoreAdvOrForty(boolean isScoreA) {
		if (isScoreA) {
			if (getScoreA() > getScoreB()) {
				return PointEnum.ADVANTAGE.valurOf();
			} else {
				return PointEnum.FORTY.valurOf();
			}
		} else {
			if (getScoreA() < getScoreB()) {
				return PointEnum.ADVANTAGE.valurOf();
			} else {
				return PointEnum.FORTY.valurOf();
			}
		}
	}

	/**
	 * 
	 * @return
	 */
	private boolean isDeuce() {
		return getScoreA() == getScoreB() && getScoreA() > 3;
	}

	/**
	 * 
	 * @return
	 */
	private boolean hasAdv() {
		return Math.abs(getScoreA() - getScoreB()) == 1 && (getScoreA() > 3 || getScoreB() > 3);
	}

	/**
	 * 
	 * @return
	 */
	public boolean hasWinner() {
		return Math.abs(getPlayerA().shootBall() - getPlayerB().shootBall()) > 0;
	}

	/**
	 * 
	 * @return
	 */
	public int getNextIteration() {
		return getIteration() + 1;
	}

	/**
	 * @return the iteration
	 */
	public int getIteration() {
		return iteration;
	}

	/**
	 * @param iteration
	 *            the iteration to set
	 */
	public void setIteration(int iteration) {
		this.iteration = iteration;
	}

	/**
	 * @return the playerA
	 */
	public Player getPlayerA() {
		return playerA;
	}

	/**
	 * @param playerA
	 *            the playerA to set
	 */
	public void setPlayerA(Player playerA) {
		this.playerA = playerA;
	}

	/**
	 * @return the scoreA
	 */
	public int getScoreA() {
		return scoreA;
	}

	/**
	 * @param scoreA
	 *            the scoreA to set
	 */
	public void setScoreA(int scoreA) {
		this.scoreA = scoreA;
	}

	/**
	 * @return the playerB
	 */
	public Player getPlayerB() {
		return playerB;
	}

	/**
	 * @param playerB
	 *            the playerB to set
	 */
	public void setPlayerB(Player playerB) {
		this.playerB = playerB;
	}

	/**
	 * @return the scoreB
	 */
	public int getScoreB() {
		return scoreB;
	}

	/**
	 * @param scoreB
	 *            the scoreB to set
	 */
	public void setScoreB(int scoreB) {
		this.scoreB = scoreB;
	}

	/**
	 * @return the nameOfWinner
	 */
	public String getNameOfWinner() {
		return nameOfWinner;
	}

	/**
	 * @param nameOfWinner
	 *            the nameOfWinner to set
	 */
	public void setNameOfWinner(String nameOfWinner) {
		this.nameOfWinner = nameOfWinner;
	}

	@Override
	public String toString() {
		if (getNameOfWinner() == null)
			return "";

		StringBuilder pointBuilder = new StringBuilder();
		pointBuilder.append("Score : " + getLabelOfScoreA() + " - " + getLabelOfScoreB()).append("\n");
		pointBuilder.append("*** Point Status : " + getNameOfWinner() + " win").append("\n");

		return pointBuilder.toString();
	}

}
