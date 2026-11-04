package edu.usfca.cs272.templates.servlets.adventure;

import org.eclipse.jetty.ee11.servlet.ServletContextHandler;
import org.eclipse.jetty.server.Server;

public class AdventureServer {
	public static void main(String[] args) throws Exception {
		ServletContextHandler sessions = null;

		// TODO

		Server server = new Server(8080);
		server.setHandler(sessions);
		server.start();
		server.join();
	}

	private AdventureServer() {
	}
}
