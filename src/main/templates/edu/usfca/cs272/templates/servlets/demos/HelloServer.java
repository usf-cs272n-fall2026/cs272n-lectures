package edu.usfca.cs272.templates.servlets.demos;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.ee11.servlet.ServletContextHandler;
import org.eclipse.jetty.server.Server;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloServer {
	public static final int PORT = 8080;
	public static Logger log = LogManager.getLogger();

	public static void main(String[] args) throws Exception {
		Server server = new Server(PORT);

		ServletContextHandler handler = new ServletContextHandler();
		// TODO

		server.setHandler(handler);
		server.start();

		log.info("Server: {} with {} threads", server.getState(), server.getThreadPool().getThreads());
		server.join();
	}

	public static String dayOfWeek() {
		return LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
	}

	public static class HelloServlet extends HttpServlet {
		private static final long serialVersionUID = 202608;
		private static final String TITLE = "Hello";

		// https://duckduckgo.com/?q=hello world

		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			log.info(request.toString());

			String html = """
					<!DOCTYPE html>
					<html lang="en">

					<head>
					  <meta charset="utf-8">
					  <title>%1$s</title>
					</head>

					<body>
					<h1>%1$s</h1>
					<p>Hello, %2$s!</p>
					<p>Thank you for visiting on this fine %3$s.</p>
					</body>
					</html>
					""";

			// TODO

			PrintWriter out = response.getWriter();
			out.println(html); // TODO

			response.setContentType("text/html");
			response.setStatus(HttpServletResponse.SC_OK);
		}
	}

	// http://localhost:8080/hello?name=Sophie
	// http://localhost:8080/hello?name=<marquee>Sophie</marquee>
	// http://localhost:8080/hello?name=<script>window.open("http://www.usfca.edu/");</script>
	// http://localhost:8080/hello?name=<script>alert("Mwahaha");</script>
}
