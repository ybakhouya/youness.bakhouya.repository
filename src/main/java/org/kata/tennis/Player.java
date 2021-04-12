/**
 * 
 */
package org.kata.tennis;

import java.util.Random;

/**
 * class player
 * @author YOUBAKHO
 *
 */
public class Player {

	private String name;
	
	private Random power;

	/**
	 * @param name
	 */
	public Player(String name) {
		this.name = name;
		power = new Random();
	}

	/**
	 * 
	 * @return
	 */
	public int shootBall() {
		return 50 + Math.abs(getPower().nextInt(50));
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the power
	 */
	public Random getPower() {
		return power;
	}

	/**
	 * @param power the power to set
	 */
	public void setPower(Random power) {
		this.power = power;
	}

	
}
