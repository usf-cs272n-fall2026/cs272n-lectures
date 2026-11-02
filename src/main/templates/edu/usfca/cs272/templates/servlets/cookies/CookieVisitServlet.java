package edu.usfca.cs272.templates.servlets.cookies;

import static jakarta.servlet.http.HttpServletResponse.SC_OK;
import static java.nio.charset.StandardCharsets.UTF_8;
import static java.time.format.DateTimeFormatter.ISO_DATE_TIME;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.text.StringSubstitutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookieVisitServlet extends HttpServlet {
	private static final long serialVersionUID = 202608;
	private static final Logger log = LogManager.getLogger();
	private static final String TITLE = "Cookies!";

	private static final String COOKIES_OK = "Cookies";
	private static final String VISIT_DATE = "Visited";
	private static final String VISIT_COUNT = "Count";

	private static final String DATE_FORMAT = "hh:mm a 'on' EEEE, MMMM dd yyyy";
	private static final Path TEMPLATE_PATH = Path.of("src", "main", "resources", "cookies",  "cookie_visits.html");

	private final String template;

	public CookieVisitServlet() throws IOException {
		template = Files.readString(TEMPLATE_PATH, UTF_8);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info(request);

		if (request.getRequestURI().endsWith("favicon.ico")) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		Map<String, String> values = new HashMap<>();

		values.put("title", TITLE);
		values.put("url", request.getRequestURL().toString());
		values.put("path", request.getRequestURI());
		values.put("timestamp", LocalDateTime.now().format(ISO_DATE_TIME));
		values.put("thread", Thread.currentThread().getName());

		values.put("visit_count", "<em>unknown</em>");
		values.put("visit_date", "<em>unknown</em>");
		values.put("enable_on", "");
		values.put("disable_on", "");

		// TODO

		if (false) {
			log.info("Cookies are enabled.");
			// TODO
		}
		else {
			log.info("Cookies are disabled.");
			// TODO
		}

		String html = StringSubstitutor.replace(template, values);
		PrintWriter out = response.getWriter();
		out.write(html);

		response.setContentType("text/html");
		response.setStatus(SC_OK);
		response.flushBuffer();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info(request);

		if (false) {
			log.info("Saving cookie approval...");
			// TODO
		}

		if (false) {
			log.info("Clearing cookies...");
			// TODO
		}

		// TODO
	}

	public static Map<String, Cookie> getCookieMap(HttpServletRequest request) {
		HashMap<String, Cookie> map = new HashMap<>();

		// TODO

		return map;
	}

	public static void clearCookies(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				// TODO
			}
		}
	}
}
