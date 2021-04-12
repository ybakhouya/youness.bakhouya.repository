/**
 * 
 */
package org.kata.tennis;

/**
 * class tie break extends point
 * @author YOUBAKHO
 *
 */
public class TieBreakPoint extends Point {

	/**
	 * 
	 * @param iteration
	 * @param playerA
	 * @param scoreA
	 * @param playerB
	 * @param scoreB
	 */
	public TieBreakPoint(int iteration, Player playerA, int scoreA, Player playerB, int scoreB) {
		super(iteration, playerA, scoreA, playerB, scoreB);
	}

	/**
	 * has winner tie break
	 */
	@Override
	public boolean hasWinner() {
		return (this.getScoreA() > 6 || this.getScoreB() > 6) && Math.abs(this.getScoreA() - this.getScoreB()) > 1;
	}

	@Override
	public String toString() {
		StringBuilder tieBreakBuilder = new StringBuilder();

		tieBreakBuilder.append("########### Start Tie Break Round : " + getIteration()).append("\n");
		tieBreakBuilder.append(getNameOfWinner() + " Win 1 point Round " + getIteration()).append("\n");
		tieBreakBuilder.append(getPlayerA().getName() + " : " + getScoreA()).append("\n");
		tieBreakBuilder.append(getPlayerB().getName() + " : " + getScoreB()).append("\n");
		tieBreakBuilder.append("########### End Tie Break Round : " + getIteration()).append("\n");
		tieBreakBuilder.append("#################################################").append("\n");

		return tieBreakBuilder.toString();
	}
}
