package edu.usfca.cs272.templates.servlets.demos;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.ee11.servlet.ServletContextHandler;
import org.eclipse.jetty.server.Server;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ReverseServer {
	public static final int PORT = 8080;
	public static Logger log = LogManager.getLogger();

	public static void main(String[] args) throws Exception {
		Server server = new Server(PORT);

		ServletContextHandler handler = new ServletContextHandler();
		handler.addServlet(ReverseGetServlet.class, "/get_reverse");
		handler.addServlet(ReversePostServlet.class, "/post_reverse");

		server.setHandler(handler);
		server.start();

		log.info("Server: {} with {} threads", server.getState(), server.getThreadPool().getThreads());
		server.join();
	}

	// NOTE: Use the "Network" view of Developer Tools in browser.

	public static class ReverseGetServlet extends HttpServlet {
		private static final long serialVersionUID = 202608;
		private static final String TITLE = "Reverse";

		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			log.info(request);

			String html = """
					<!DOCTYPE html>
					<html lang="en">

					<head>
					  <meta charset="utf-8">
					  <title>%1$s</title>
					</head>

					<body>
					<h1>%1$s</h1>

					TODO

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

	public static class ReversePostServlet extends HttpServlet {
		private static final long serialVersionUID = 202608;
		private static final String TITLE = "Reverse";

		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			log.info(request);

			String html = """
					<!DOCTYPE html>
					<html lang="en">

					<head>
					  <meta charset="utf-8">
					  <title>%1$s</title>
					</head>

					<body>
					<h1>%1$s</h1>

					TODO

					</body>
					</html>
					""";

			// TODO

			PrintWriter out = response.getWriter();
			out.println(html); // TODO

			response.setContentType("text/html");
			response.setStatus(HttpServletResponse.SC_OK);
		}

		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			log.info(request);

			String html = """
					<!DOCTYPE html>
					<html lang="en">

					<head>
					  <meta charset="utf-8">
					  <title>%1$s</title>
					</head>

					<body>
					<h1>%1$s</h1>

					TODO

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
}
