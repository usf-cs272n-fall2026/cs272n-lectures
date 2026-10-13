package edu.usfca.cs272.templates.debugging;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CharacterCompare {
	private static final Logger log = LogManager.getLogger();

	public static int compareSequentially(Path file1, Path file2, char character) {
		log.debug("Comparing {} and {} sequentially.", file1, file2);

		int count1 = 0;
		int count2 = 0;

		try {
			count1 = CharacterFinder.findCharacter(file1, character, true);
			count2 = CharacterFinder.findCharacter(file2, character, true);
		}
		catch (IOException e) {
			log.catching(Level.DEBUG, e);
		}

		log.debug("Files {} and {} have a difference of {} '{}' characters.", file1, file2, count1 - count2, character);
		return count1 - count2;
	}

	// TODO

	public static int compareConcurrently(Path file1, Path file2, char character) {
		log.debug("Comparing {} and {} concurrently.", file1, file2);

		// TODO

		try {
			log.debug("Waiting for threads to complete.");

			// TODO

			// once that happens, the worker threads are done
			log.debug("Threads finished.");
		}
		catch (Exception e) { // TODO
			log.catching(Level.DEBUG, e);
		}

//		String format = "Files {} and {} have a difference of {} '{}' characters.";
//		log.debug(format, file1, file2, counter1.count - counter2.count, character);
//		return counter1.count - counter2.count;

		return -1; // TODO
	}

	public static void main(String[] args) {
		Path sherlock = Path.of("src", "main", "resources", "text", "pg1661.txt");
		Path mobydick = Path.of("src", "main", "resources", "text", "pg2701.txt");

		if (!Files.isReadable(sherlock) || !Files.isReadable(mobydick)) {
			log.error("Unable to read {} and {}.", sherlock, mobydick);
			return;
		}

		char character = 'c';

		int countSequentially = compareSequentially(sherlock, mobydick, character);
		int countConcurrently = compareConcurrently(sherlock, mobydick, character);

		assert countSequentially == countConcurrently;

		log.info("The file {} has {} {} '{}' characters than {} does.", sherlock.getFileName(), Math.abs(countSequentially),
				countSequentially > 0 ? "more" : "less", character, mobydick.getFileName());
	}

}
