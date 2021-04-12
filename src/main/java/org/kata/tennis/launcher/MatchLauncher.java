package org.kata.tennis.launcher;

import org.kata.tennis.Match;
import org.kata.tennis.Player;

public class MatchLauncher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Match match = new Match(0, new Player("FEDERER"), 0, new Player("NADAL"), 0);
		match.start();
		System.out.println(match);
	}

}
