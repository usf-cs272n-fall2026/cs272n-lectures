package edu.usfca.cs272.templates.servlets.adventure;

import static jakarta.servlet.http.HttpServletResponse.SC_OK;
import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.text.StringSubstitutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AdventureServlet extends HttpServlet {
	private static final long serialVersionUID = 202608;
	private static Logger log = LogManager.getLogger();

	private static final String TITLE = "Adventure!";

	private static final Path TEMPLATE_PATH = Path.of("src", "main", "resources", "adventure",  "adventure.html");

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> values = new HashMap<>();

		values.put("title", TITLE);
		values.put("url", request.getRequestURL().toString());
		values.put("path", request.getRequestURI());
		values.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
		values.put("thread", Thread.currentThread().getName());

		// TODO

		try {

		}
		catch (Exception e) {
			log.debug(e);
		}

		if (false) { // TODO
			// TODO
			// log.info("Starting new game for session {}", session.getId());
		}
		else {
			// TODO
			// log.info("Session {} moved from {} to {}", session.getId(), old, room.ordinal());
		}

		// TODO

		if (false) {
			// log.info("Game finished for session {}", session.getId());
			// TODO

			values.put("west", "disabled");
			values.put("east", "disabled");
			values.put("north", "disabled");
			values.put("south", "disabled");
		}
		else {
			// TODO
//			values.put("west", room.canMove(Direction.WEST) ? "" : "disabled");
//			values.put("east", room.canMove(Direction.EAST) ? "" : "disabled");
//			values.put("north", room.canMove(Direction.NORTH) ? "" : "disabled");
//			values.put("south", room.canMove(Direction.SOUTH) ? "" : "disabled");
		}

		String template = Files.readString(TEMPLATE_PATH, UTF_8);

		StringSubstitutor replacer = new StringSubstitutor(values);
		String html = replacer.replace(template);

		response.setContentType("text/html");
		response.setStatus(SC_OK);

		PrintWriter writer = response.getWriter();
		writer.write(html);

		response.flushBuffer();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
