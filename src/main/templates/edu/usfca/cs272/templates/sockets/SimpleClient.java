package edu.usfca.cs272.templates.sockets;

import java.io.IOException;

public class SimpleClient {
	public static void main(String[] args) throws IOException {
		// TODO

		System.out.println("Client: Started...");
		System.out.println("Client: Ending client...");
		System.out.println("Client: Shutting down server...");
		System.out.println("Client: Client disconnected.");
	}

	/// Prevent instantiating this class of static methods.
	private SimpleClient() {}
}
