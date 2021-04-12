/**
 * 
 */
package org.kata.tennis.interfaces;

/**
 * Template point 
 * @author YOUBAKHO
 *
 */
public interface PointTemplateInterface {

	/**
	 * start point or game or set
	 */
	public void start();

	/**
	 * has winner point or game or set
	 * 
	 * @return boolean
	 */
	public boolean hasWinner();

	/**
	 * Update the winner
	 * 
	 * @param scorePlayerA
	 * @param scorePlayerB
	 * @return
	 */
	public boolean updateWinner(int scorePlayerA, int scorePlayerB);

}
