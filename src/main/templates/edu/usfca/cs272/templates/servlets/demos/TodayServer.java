package edu.usfca.cs272.templates.servlets.demos;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TodayServer {
	public static final int PORT = 8080;
	public static Logger log = LogManager.getLogger();

	public static final String FORMAT = "hh:mm:ss a 'on' EEEE, MMMM dd yyyy";
	public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(FORMAT);

	public static void main(String[] args) throws Exception {
		// TODO
		// log.info("Server: {} with {} threads", server.getState(), server.getThreadPool().getThreads());
	}

	public static class TodayServlet extends HttpServlet {
		private static final long serialVersionUID = 202608;
		private static final String TITLE = "Today";

		public TodayServlet() {}

		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			log.info(request.toString());

/*
					<!DOCTYPE html>
					<html lang="en">

					<head>
						<meta charset="utf-8">
						<title>Today</title>
					</head>

					<body>
					<h1>Today</h1>
					<p>It is 12:00:00 pm on Monday, January, 1, 2018.</p>
					</body>
					</html>
*/

			// TODO
		}
	}

	public static String getDate() {
		LocalDateTime today = LocalDateTime.now();
		return today.format(FORMATTER);
	}

	private TodayServer() {}
}
