package edu.usfca.cs272.templates.servlets.cookies;

import static jakarta.servlet.http.HttpServletResponse.SC_OK;
import static java.nio.charset.StandardCharsets.UTF_8;
import static java.time.format.DateTimeFormatter.ISO_DATE_TIME;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookieLandingServlet extends HttpServlet {
	private static final long serialVersionUID = 202608;
	private static final Logger log = LogManager.getLogger();
	private static final String TITLE = "Cookies!";
	private static final Path TEMPLATE_PATH = Path.of("src", "main", "resources", "cookies",  "cookie_landing.html");

	private final String template;

	public CookieLandingServlet() throws IOException {
		template = Files.readString(TEMPLATE_PATH, UTF_8);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info(request);

		Map<String, String> values = new HashMap<>();

		values.put("title", TITLE);
		values.put("url", request.getRequestURL().toString());
		values.put("path", request.getRequestURI());
		values.put("timestamp", LocalDateTime.now().format(ISO_DATE_TIME));
		values.put("thread", Thread.currentThread().getName());

		// TODO

		response.setContentType("text/html");
		response.setStatus(SC_OK);
		response.flushBuffer();
	}
}
