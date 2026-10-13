package edu.usfca.cs272.templates.threads.basics;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.TreeSet;

public class RandomArrayTotal {
	// TODO

	public static long total(int[] numbers) {
		long total = 0;

		for (int i = 0; i < numbers.length; i++) {
			total = total + numbers[i];
		}

		return total;
	}

	public static long total(int[] numbers, int threads) throws InterruptedException {
		// TODO

//		int chunk = numbers.length / workers.length;
//		int remainder = numbers.length % workers.length;
//		int last = workers.length - 1;
//
//		long total = 0;
//
//		assert chunk > 0;
//		assert remainder >= 0;

		return -1;
	}

	public static void main(String[] args) throws InterruptedException {
		int[] numbers = new Random().ints(10, 0, 100).toArray();

		System.out.println(Arrays.toString(numbers));
		System.out.println();

		System.out.println(total(numbers));
		System.out.println(total(numbers, 5));
		System.out.println();

//		int size = 100;
//		benchmark(100);
	}

	public static void benchmark(int size) throws InterruptedException {
		TreeSet<Integer> threads = new TreeSet<>();
		int processors = Runtime.getRuntime().availableProcessors();
		Collections.addAll(threads, 1, 2, processors, processors * 2);

		if (processors > 3) {
			threads.add(processors - 2);
			threads.add(processors / 2);
		}

		System.out.printf("calculating sum for %d random numbers...%n", size);

		double minBestTime = Double.MAX_VALUE;
		int minThreads = 0;

		for (Integer thread : threads) {
			double bestTime = benchmark(size, thread);

			if (bestTime < minBestTime) {
				minBestTime = bestTime;
				minThreads = thread;
			}
		}

		System.out.println();

		for (Integer thread : threads.descendingSet()) {
			double bestTime = benchmark(size, thread);

			if (bestTime < minBestTime) {
				minBestTime = bestTime;
				minThreads = thread;
			}
		}

		System.out.printf("%nFastest minimum: %02d threads in %.06f seconds", minThreads, minBestTime);
		System.out.printf("%n   Java runtime: %02d available processors", processors);
	}

	private static double benchmark(int size, int threads) throws InterruptedException {
		Runtime.getRuntime().gc();

		int warmup = 10;
		int runs = 30;

		int[] numbers = new Random().ints(size, 0, 100).toArray();

		long placeholder = 0;
		double average = 0;

		Instant start;
		Duration elapsed;
		Duration minimum = ChronoUnit.FOREVER.getDuration();

		for (int i = 0; i < warmup; i++) {
			placeholder = Math.max(placeholder, total(numbers, threads));
		}

		for (int i = 0; i < runs; i++) {
			start = Instant.now();
			placeholder = Math.max(placeholder, total(numbers, threads));
			elapsed = Duration.between(start, Instant.now());
			minimum = minimum.compareTo(elapsed) > 0 ? elapsed : minimum;
			average += elapsed.toNanos();
		}

		average /= runs;
		average /= Duration.ofSeconds(1).toNanos();

		double seconds = (double) minimum.toNanos() / Duration.ofSeconds(1).toNanos();

		String format = "%02d threads: %.06f min, %.06f avg seconds (sum: %d) %n";
		System.out.printf(format, threads, seconds, average, placeholder);

		return seconds;
	}
}
