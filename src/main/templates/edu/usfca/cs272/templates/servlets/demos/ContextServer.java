package edu.usfca.cs272.templates.servlets.demos;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.server.Server;

public class ContextServer {
	public static final int PORT = 8080;
	public static Logger log = LogManager.getLogger();

	public static void main(String[] args) throws Exception {
		Server server = new Server(PORT);

		// TODO

		server.start();

		log.info("Server: {} with {} threads", server.getState(), server.getThreadPool().getThreads());
		server.join();

		/*
		 * Examples:
		 *
		 * http://localhost:8080/resources
		 * http://localhost:8080/resources/src
		 * http://localhost:8080/resources/nowhere
		 * http://localhost:8080/resources/hello
		 *
		 * http://localhost:8080/servlets/hello
		 * http://localhost:8080/servlets/today
		 * http://localhost:8080/servlets/nowhere
		 * http://localhost:8080/servlets/src/
		 * http://localhost:8080/servlets/
		 *
		 * http://localhost:8080/
		 * http://localhost:8080/favicon.ico
		 * http://localhost:8080/nowhere
		 * http://localhost:8080/hello
		 */
	}
}
