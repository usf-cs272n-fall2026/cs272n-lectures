package edu.usfca.cs272.templates.debugging;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CharacterFinder {
	private static final Logger log = LogManager.getLogger();

	// TODO
	public static int findCharacter(Path file, char character, boolean ignoreCase) throws IOException {
		int count = 0;

		try (BufferedReader reader = Files.newBufferedReader(file, UTF_8);) {
			String line;

			while ((line = reader.readLine()) != null) {
				if (ignoreCase) {
					line = line.toLowerCase();
				}

				for (char current : line.toCharArray()) {
					if (current == character) {
						count++;
					}
				}
			}
		}

		return count;
	}

	public static void main(String[] args) {
		Path sherlock = Path.of("src", "main", "resources", "text", "pg1661.txt");

		char lower = 'c';
		char upper = Character.toUpperCase(lower);

		try {
			int countLowers = findCharacter(sherlock, lower, false);
			int countUppers = findCharacter(sherlock, upper, false);
			int countIgnore = findCharacter(sherlock, lower, true);

			// TODO

			findCharacter(Path.of("nowhere"), lower, true);
		}
		catch (IOException e) {
			// TODO
		}
	}
}
