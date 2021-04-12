/**
 * 
 */
package org.kata.tennis.launcher;

import org.kata.tennis.Player;
import org.kata.tennis.Set;

/**
 * class main for execution
 * @author YOUBAKHO
 *
 */
public class SetLauncher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set set = new Set(1, new Player("FEDERER"), 0, new Player("NADAL"), 0);
		set.start();
		System.out.println(set);
	}

}
