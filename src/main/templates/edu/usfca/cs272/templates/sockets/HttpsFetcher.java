package edu.usfca.cs272.templates.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://developer.mozilla.org/en-US/docs/Web/HTTP/Guides/Session
public class HttpsFetcher {

	public static Map<String, List<String>> fetch(URI uri) throws IOException {
		//TODO
		return null;
	}

	public static Socket openConnection(URI uri) throws UnknownHostException, IOException {
		// TODO
		return null;
	}

	public static void printGetRequest(PrintWriter writer, URI uri) throws IOException {
		// TODO
	}

	public static Map<String, List<String>> processHttpHeaders(BufferedReader response) throws IOException {
		Map<String, List<String>> results = new HashMap<>();

		// TODO

		return results;
	}

	public static Map<String, List<String>> fetch(String uri) throws URISyntaxException, IOException {
		return fetch(new URI(uri));
	}

	public static Map<String, List<String>> fetch(HttpClient client, URI uri) throws IOException, InterruptedException {
		Map<String, List<String>> results = new HashMap<>();

		// TODO

		return results;
	}

	public static void main(String[] args) throws Exception {
		String[] urls = new String[] { "http://www.cs.usfca.edu/", // 302 -> https
				"https://www.cs.usfca.edu/", // 302 -> myusf
				"https://www.cs.usfca.edu/~cs272/", // 200
				"https://www.cs.usfca.edu/~cs272/simple/double_extension.html.txt", // text/plain
				"https://www.cs.usfca.edu/~cs272/nowhere.html" // 404
		};

		HttpClient.Builder builder = HttpClient.newBuilder().followRedirects(Redirect.NEVER);

		try (HttpClient client = builder.build();) {
			for (String url : urls) {
				URI uri = URI.create(url);
				System.out.println(uri);

				var clientResults = fetch(client, uri);
				System.out.println(clientResults);

				var socketResults = fetch(uri);
				System.out.println(socketResults);

				System.out.println();
			}
		}
	}
}
