/**
 * 
 */
package org.kata.tennis.enumeration;

/**
 * Enumeration point
 * @author YOUBAKHO
 *
 */
public enum PointEnum {
	ZERO("0"),FIFTEEN("15"), THIRTY("30"), FORTY("40"), ADVANTAGE("ADV"), DEUCE("DEUCE"), WINNER("WIN"), LOSER("LOS");

	/*
	 * 
	 */
	String name;

	/**
	 * 
	 * @param name
	 */
	private PointEnum(String name) {
		this.name = name;
	}

	/**
	 * 
	 */
	public String valurOf() {
		return name;
	}
}
