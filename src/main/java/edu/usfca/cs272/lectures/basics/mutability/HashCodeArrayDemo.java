package edu.usfca.cs272.lectures.basics.mutability;

import java.util.Arrays;

/**
 * Demonstrates how parameter passing works in Java, including the difference in
 * behavior for immutable versus mutable objects.
 *
 * This version focuses on arrays with immutable vs mutable items.
 *
 * @author CS 272 Software Development (University of San Francisco)
 * @version Fall 2026
 * @see HashCodeDemo
 */
public class HashCodeArrayDemo {
	/**
	 * Used to demonstrate how the identity hash code is or is not modified within a
	 * method call with an attempted modification (and no re-assignment).
	 *
	 * @param value the value passed in from main method
	 */
	public static void concat(String[] value) {
		printHash("INNER BEG", value);
		value[0].concat("apple");
		printHash("INNER END", value);
	}

	/**
	 * Used to demonstrate how the identity hash code is or is not modified within a
	 * method call with an attempted modification (and no re-assignment).
	 *
	 * @param value the value passed in from main method
	 */
	public static void append(StringBuilder[] value) {
		printHash("INNER BEG", value);
		value[0].append("apple");
		printHash("INNER END", value);
	}

	/**
	 * Used to demonstrate how the identity hash code is or is not modified within a
	 * method call with an attempted assignment and modification.
	 *
	 * @param value the value passed in from main method
	 */
	public static void equalConcat(String[] value) {
		printHash("INNER BEG", value);
		value[1] = value[1].concat("apple");
		printHash("INNER END", value);
	}

	/**
	 * Used to demonstrate how the identity hash code is or is not modified within a
	 * method call with an attempted assignment and modification.
	 *
	 * @param value the value passed in from main method
	 */
	public static void equalAppend(StringBuilder[] value) {
		printHash("INNER BEG", value);
		value[1] = value[1].append("apple");
		printHash("INNER END", value);
	}

	/**
	 * Demonstrates the methods in this class.
	 *
	 * @param args unused
	 */
	public static void main(String[] args) {
		String[] array1 = new String[] { "pine", "crab" };

		printHash("OUTER BEG", array1);
		concat(array1);
//		equalConcat(array1);
		printHash("OUTER END", array1);
		System.out.println();

		StringBuilder[] array2 = new StringBuilder[] {
				new StringBuilder("pine"),
				new StringBuilder("crab")
		};

		printHash("OUTER BEG", array2);
		append(array2);
//		equalAppend(array2);
		printHash("OUTER END", array2);
		System.out.println();
	}

	/**
	 * Shows the identity hash codes and the String representation of the array.
	 *
	 * @param label the label to use in output
	 * @param objects the array of objects to display
	 */
	public static void printHash(String label, Object[] objects) {
		Object[] args = { label, System.identityHashCode(objects), Arrays.toString(objects) };
		System.out.format("%-9s : x%08X : %s %n", args);
	}

	/** Prevent instantiating this class of static methods. */
	private HashCodeArrayDemo() {}
}
