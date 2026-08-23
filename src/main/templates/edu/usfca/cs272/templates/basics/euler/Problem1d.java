package edu.usfca.cs272.templates.basics.euler;

import java.util.Arrays;

import edu.usfca.cs272.lectures.basics.euler.Problem1b;

public class Problem1d {
	public static int sumMultiples(int max, int[] multiples) {
		// TODO Fill in solution
		throw new UnsupportedOperationException("Not yet implemented.");
	}

	public static void main(String[] args) {
		int max = 1000;
		int[] original = { 3, 5 };
		int[] only10 = { 10 };
		int[] primes = { 11, 23, 37 };

		String format = "The sum of multiples %s below %d is %d.%n";

		System.out.printf(format, Arrays.toString(original), max, Problem1b.sumMultiples(max));
		System.out.printf(format, Arrays.toString(original), max, sumMultiples(max, original));

		System.out.println();

		System.out.printf(format, Arrays.toString(only10), max, sumMultiples(max, only10));
		System.out.printf(format, Arrays.toString(primes), max, sumMultiples(max, primes));
	}

	private Problem1d() {}
}
