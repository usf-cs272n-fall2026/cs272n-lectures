package edu.usfca.cs272.templates.threads.management;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SerialDirectoryListing {
	public static final Logger log = LogManager.getLogger();

	public static Set<Path> list(Path path) throws IOException {
		Set<Path> paths = new HashSet<>();

		if (Files.exists(path)) {
			paths.add(path);

			if (Files.isDirectory(path)) {
				// TODO
			}
		}

		log.debug("Returning {} paths", paths.size());
		return paths;
	}

	// TODO

	public static void main(String[] args) throws IOException {
		list(Path.of("src")).forEach(System.out::println);
	}

	private SerialDirectoryListing() {}
}
