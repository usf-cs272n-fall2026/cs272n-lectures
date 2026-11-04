package edu.usfca.cs272.lectures.servlets.adventure;

import org.eclipse.jetty.ee11.servlet.ServletContextHandler;
import org.eclipse.jetty.server.Server;

/// Demonstrates how to use session tracking and enum types to create a simple
/// adventure game.
///
/// @see AdventureServer
/// @see AdventureServlet
/// @see AdventureRoom
/// @see Direction
///
/// @author CS 272 Software Development (University of San Francisco)
/// @author Claude Opus 5.5 (Anthropic)
/// @version Fall 2026
public class AdventureServer {
	/// Initializes and starts the adventure game server.
	///
	/// @param args unused
	/// @throws Exception in unable to start or run server
	public static void main(String[] args) throws Exception {
		// type of handler that supports sessions
		ServletContextHandler sessions = null;

		// turn on sessions and set context
		sessions = new ServletContextHandler(ServletContextHandler.SESSIONS);
		sessions.setContextPath("/");
		sessions.addServlet(AdventureServlet.class, "/");

		// setup jetty server
		Server server = new Server(8080);
		server.setHandler(sessions);
		server.start();
		server.join();
	}

	/// Prevent instantiating this class of static methods.
	private AdventureServer() {
	}
}
