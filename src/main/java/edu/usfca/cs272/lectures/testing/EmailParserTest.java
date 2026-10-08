package edu.usfca.cs272.lectures.testing;

import java.net.URISyntaxException;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import edu.usfca.cs272.lectures.testing.EmailParser.Email;

public class EmailParserTest {

	// TODO
	public void testSimple() throws URISyntaxException {
		String testCase = "simple@example.com";

		// TODO
	}

	// TODO
	public class ValidTests {

		// TODO
//		@ValueSource(strings = { "email@example.com", "email@subdomain.example.com", "first.last@example.org",
//				"first-last@example.net", "first+last@example.net", "1234567890@example.com", "a@example.com",
//				"email@localhost" })
		public void testValid(String email) {
			// TODO
		}

		// TODO
//		@ValueSource(strings = { "", "hello", "example.com", "@example.com", "example@", "a@b@c", "@" })
		public void testInvalid(String email) {
			// TODO
		}
	}

	@Nested
	public class SimpleTest {
		private String email;
		private String local;
		private String domain;
		private String tld;

		public void setupTest(String email, String local, String domain, String tld) throws URISyntaxException {
			this.email = email;
			this.local = local;
			this.domain = domain;
			this.tld = tld;
		}

		// TODO
		public void setup() throws URISyntaxException {
			setupTest("simple@example.com", "simple", "example.com", "com");
		}

		@Test
		public void testEmail() throws URISyntaxException {
			Email test = EmailParser.parseEmail(email);
			String expect = email;
			String actual = test.email();

			// TODO
		}

		@Test
		public void testLocal() throws URISyntaxException {
			Email test = EmailParser.parseEmail(email);
			String expect = local;
			String actual = test.local();

			// TODO
		}

		@Test
		public void testDomain() throws URISyntaxException {
			Email test = EmailParser.parseEmail(email);
			String expect = domain;
			String actual = test.domain();

			// TODO
		}

		@Test
		public void testTLD() throws URISyntaxException {
			Email test = EmailParser.parseEmail(email);
			String expect = tld;
			String actual = test.tld();

			// TODO
		}
	}

	// TODO
	public class ComplexTest {

	}

}
