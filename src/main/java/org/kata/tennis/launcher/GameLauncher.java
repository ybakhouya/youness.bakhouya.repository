package org.kata.tennis.launcher;

import org.kata.tennis.Game;
import org.kata.tennis.Player;

public class GameLauncher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Game game = new Game(0, new Player("FEDERER"), 0, new Player("NADAL"), 0);
		game.start();
		System.out.println(game);
	}
}
