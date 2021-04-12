/**
 * 
 */
package org.kata.tennis;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YOUBAKHO
 *
 */
public class Match extends Point {

	private List<Set> sets;

	public Match(int iteration, Player playerA, int scoreA, Player playerB, int scoreB) {
		super(iteration, playerA, scoreA, playerB, scoreB);
		this.sets = new ArrayList<>();
		Set firstSet = new Set(iteration, playerA, scoreA, playerB, scoreB);
		this.sets.add(firstSet);
	}

	/**
	 * start the game
	 */
	@Override
	public void start() {
		boolean isPlaying = true;
		while (isPlaying) {
			Set lastSet = getLastSet();
			if (hasWinner() && this.updateWinner(lastSet.getScoreA(), lastSet.getScoreB())) {
				isPlaying = false;
			} else {
				Set nextSet = new Set(lastSet.getNextIteration(), getPlayerA(), lastSet.getScoreA(), getPlayerB(),
						lastSet.getScoreB());
				nextSet.start();
				sets.add(nextSet);
			}
		}
	}

	/**
	 * has winner set
	 */
	@Override
	public boolean hasWinner() {
		Set lastSet = getLastSet();
		return (lastSet.getScoreA() > 2 || lastSet.getScoreB() > 2);
	}

	/**
	 * 
	 * @return
	 */
	private Set getLastSet() {
		return sets.get(sets.size() - 1);
	}

	public List<Set> getSets() {
		return sets;
	}

	public void setSets(List<Set> sets) {
		this.sets = sets;
	}

	@Override
	public String toString() {

		StringBuilder matchBuilder = new StringBuilder();
		matchBuilder.append("Start Match : " + getPlayerA().getName() + " VS "
				+ getPlayerB().getName()).append("\n");

		sets.forEach(matchBuilder::append);

		matchBuilder.append("Match Status : " + getNameOfWinner() + " wins ");

		return matchBuilder.toString();
	}
}
