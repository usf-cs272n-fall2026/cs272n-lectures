package edu.usfca.cs272.templates.basics.mutability;

import java.util.Arrays;

public class HashCodeArrayDemo {
	public static void concat(String[] value) {
		printHash("INNER BEG", value);
		value[0].concat("apple");
		printHash("INNER END", value);
	}

	public static void append(StringBuilder[] value) {
		printHash("INNER BEG", value);
		value[0].append("apple");
		printHash("INNER END", value);
	}

	public static void equalConcat(String[] value) {
		printHash("INNER BEG", value);
		value[1] = value[1].concat("apple");
		printHash("INNER END", value);
	}

	public static void equalAppend(StringBuilder[] value) {
		printHash("INNER BEG", value);
		value[1] = value[1].append("apple");
		printHash("INNER END", value);
	}

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

	public static void printHash(String label, Object object) {
		Object[] args = { label, System.identityHashCode(object), object };
		System.out.format("%-9s : x%08X : %s %n", args);
	}

	public static void printHash(String label, Object[] object) {
		Object[] args = { label, System.identityHashCode(object), Arrays.toString(object) };
		System.out.format("%-9s : x%08X : %s %n", args);
	}
}
