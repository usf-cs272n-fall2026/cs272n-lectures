package edu.usfca.cs272.templates.servlets.adventure;

import org.eclipse.jetty.ee11.servlet.ServletContextHandler;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.DefaultHandler;

public class AdventureServer {
	public static void main(String[] args) throws Exception {
		ServletContextHandler servletContext = null;

		// TODO

		DefaultHandler defaultHandler = new DefaultHandler();
		defaultHandler.setServeFavIcon(true);

		ContextHandler defaultContext = new ContextHandler("/favicon.ico");
		defaultContext.setHandler(defaultHandler);

		Handler.Sequence handlers = new Handler.Sequence(defaultContext, servletContext);

		Server server = new Server(8080);
		server.setHandler(handlers);
		server.start();
		server.join();
	}

	private AdventureServer() {
	}
}
