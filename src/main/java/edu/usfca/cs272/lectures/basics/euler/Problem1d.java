package edu.usfca.cs272.lectures.basics.euler;

import java.util.Arrays;

/**
 * Project Euler Problem 1 is stated as follows:
 *
 * <blockquote> If we list all the natural numbers below 10 that are multiples
 * of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23. Find the
 * sum of all the multiples of 3 or 5 below 1000. </blockquote>
 *
 * This example illustrates a more reusable and generalized approach, also
 * allowing the multiples to be specified by the user as well. This is just one
 * of many approaches, all with different space and time requirements.
 *
 * @author CS 272 Software Development (University of San Francisco)
 * @version Fall 2026
 */
public class Problem1d {

	/**
	 * Sums together non-negative multiples less than the maximum value.
	 *
	 * @param max       maximum value to consider
	 * @param multiples the multiples to consider (such as 3 and 5)
	 *
	 * @return sum of multiples less than the maximum value
	 */
	public static int sumMultiples(int max, int[] multiples) {
		int sum = 0;

		for (int i = 0; i < max; i++) {
			for (int multiple : multiples) {
				if (i % multiple == 0) {
					sum += i;
					break;
				}
			}
		}

		return sum;
	}

	/**
	 * Prints the sum of multiples less than a maximum value to the console. All
	 * values are hard-coded.
	 *
	 * @param args unused
	 */
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

	/*
	 * Now we can specify multiples too! But, we removed the ability for users to
	 * enter those from the console since that would take quite a bit of code to
	 * validate.
	 *
	 * So, you can see how much object-oriented design can increase the size of
	 * programs. Why in the world would we want to do this?
	 *
	 * It is only useful when (a) you have large and complex problems, and (b) there
	 * is ample opportunity to reuse your solutions to those problems. The more
	 * often you reuse your code, the more you get out of the object-oriented
	 * design. But, when have you EVER reused code so far?
	 *
	 * Guess what... you will now! Almost all of the classes you create in this
	 * class you will reuse across homework and project assignments. And, we have a
	 * problem that is complex and large enough to warrant object-oriented design: a
	 * search engine.
	 */

	/** Prevents creating an instance of this class. */
	private Problem1d() {}
}
