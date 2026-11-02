package edu.usfca.cs272.templates.servlets.cookies;

import org.eclipse.jetty.ee11.servlet.ServletContextHandler;
import org.eclipse.jetty.server.Server;

public class CookieServer {
	public static void main(String[] args) throws Exception {
		ServletContextHandler handler = new ServletContextHandler();
		handler.addServlet(CookieLandingServlet.class, "/");
		handler.addServlet(CookieVisitServlet.class, "/visits");

		Server server = new Server(8080);
		server.setHandler(handler);
		server.start();
		server.join();
	}
}
