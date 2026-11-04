package edu.usfca.cs272.lectures.servlets.adventure;

import java.util.Arrays;

/// Represents the four cardinal directions. Points between the cardinal
/// directions form the points of the compass.
///
/// @author CS 272 Software Development (University of San Francisco)
/// @author Claude Opus 5.5 (Anthropic)
/// @version Fall 2026
public enum Direction {
	/// West cardinal direction.
	WEST,

	/// North cardinal direction.
	NORTH,

	/// East cardinal direction.
	EAST,

	/// South cardinal direction.
	SOUTH;

	/// Demonstrates simple enum types.
	///
	/// @param args unused
	public static void main(String[] args) {
		Direction direction = Direction.NORTH;

		System.out.println(direction.name());
		System.out.println(direction.ordinal());

		System.out.println(Arrays.toString(Direction.values()));
	}
}
