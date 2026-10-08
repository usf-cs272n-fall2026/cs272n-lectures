package edu.usfca.cs272.templates.testing;

import java.net.URISyntaxException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import edu.usfca.cs272.templates.testing.EmailParser.Email;

/// Demonstrates how to create unit tests. Note: Test code is usually placed in
/// the src/test folder in maven projects!
///
/// @see EmailParser
///
/// @author CS 272 Software Development (University of San Francisco)
/// @version Fall 2026
public class EmailParserTest {
	/// A simple JUnit test of a simple example email.
	///
	/// @throws URISyntaxException if unable to parse email
	@Test
	public void testSimple() throws URISyntaxException {
		String testCase = "simple@example.com";
		Email parsedEmail = EmailParser.parseEmail(testCase);

		String expectedEmail = "simple@example.com";
		String actualEmail = parsedEmail.email();

//		Assertions.assertEquals(expectedEmail, actualEmail);
//		Assertions.assertEquals(expectedEmail, actualEmail, parsedEmail.toString());

		Assertions.assertEquals(expectedEmail, actualEmail, () -> parsedEmail.toString());
	}

	/// Tests if emails are valid or invalid. Demonstrates nested classes.
	@Nested
	public class ValidTests {
		/// Tests that the provided emails can be parsed without throwing an exception.
		///
		/// @param email the email test case
		@ParameterizedTest
		@ValueSource(strings = { "email@example.com", "email@subdomain.example.com", "first.last@example.org",
				"first-last@example.net", "first+last@example.net", "1234567890@example.com", "a@example.com",
				"email@localhost" })
		public void testValid(String email) {
			Executable test = () -> EmailParser.parseEmail(email);
			Assertions.assertDoesNotThrow(test);
		}

		/// Tests that the email parameter can be parsed without throwing any
		/// exceptions.
		///
		/// @param email the email test case
		/// @see Assertions#assertAll(Executable...)
		@ParameterizedTest(name = "Email #{index}: {0}") // Customized name
		@ValueSource(strings = { "", "hello", "example.com", "@example.com", "example@", "a@b@c", "@" })
		public void testInvalid(String email) {
			// Asserts that an exception IS thrown instead of NOT thrown
			Executable test = () -> EmailParser.parseEmail(email);
			Assertions.assertThrows(URISyntaxException.class, test);
		}
	}

	/// Tests all components of a simple test case. Demonstrates how inheritance can
	/// be used with test classes (and interfaces).
	@Nested
	public class SimpleTest {
		/// The email to test.
		private String email;

		/// The expected local value.
		private String local;

		/// The expected domain value. *
		private String domain;

		/// The expected top-level domain value.
		private String tld;

		/// Sets up the parser and expected values for these unit tests.
		///
		/// @param email  the email to test
		/// @param local  the expected local value
		/// @param domain the expected domain value
		/// @param tld    the expected tld value
		/// @throws URISyntaxException if unable to parse the email
		public void setupTest(String email, String local, String domain, String tld) throws URISyntaxException {
			this.email = email;
			this.local = local;
			this.domain = domain;
			this.tld = tld;
		}

		/// Runs setup operations before each test is run. It is called for every test
		/// so that each test has a clean setup.
		///
		/// @throws URISyntaxException if unable to parse email
		///
		/// @see BeforeEach
		@BeforeEach
		public void setup() throws URISyntaxException {
			setupTest("simple@example.com", "simple", "example.com", "com");
		}

		/// A simple unit test to make sure the email parses successfully.
		///
		/// @throws URISyntaxException unable to parse the email
		/// @see Assertions#assertEquals(Object, Object)
		@Test
		public void testEmail() throws URISyntaxException {
			Email test = EmailParser.parseEmail(email);
			String expect = email;
			String actual = test.email();

			// Use the side-by-side comparison to see differences
			Assertions.assertEquals(expect, actual);
		}

		/// A simple unit test for the local component of an email.
		///
		/// @throws URISyntaxException unable to parse the email
		/// @see Assertions#assertEquals(Object, Object)
		@Test
		public void testLocal() throws URISyntaxException {
			Email test = EmailParser.parseEmail(email);
			String expect = local;
			String actual = test.local();

			// We have one assert statement per test, even though it is on the same test
			// case.
			// Can specify what the debug output should look like
			Assertions.assertEquals(expect, actual, test.toString());
		}

		/// A simple unit test for the domain component of an email.
		///
		/// @throws URISyntaxException unable to parse the email
		/// @see Assertions#assertEquals(Object, Object, String)
		@Test
		public void testDomain() throws URISyntaxException {
			Email test = EmailParser.parseEmail(email);
			String expect = domain;
			String actual = test.domain();

			// Better to use a lambda expression so toString is not called unless needed
			Assertions.assertEquals(expect, actual, () -> test.toString());
		}

		/// A simple unit test for the TLD component of an email.
		///
		/// @throws URISyntaxException unable to parse the email
		/// @see Assertions#assertEquals(Object, Object, java.util.function.Supplier)
		@Test
		public void testTLD() throws URISyntaxException {
			Email test = EmailParser.parseEmail(email);
			String expect = tld;
			String actual = test.tld();

			Assertions.assertEquals(expect, actual, () -> test.toString());
		}

		// Note the repetition here. There must be a better way...
	}

	/// Tests a more complex email and demonstrate how to reuse other classes for
	/// test cases.
	@Nested
	public class ComplexTest extends SimpleTest {
		@BeforeEach
		@Override
		public void setup() throws URISyntaxException {
			setupTest("first.last@subdomain.example.com", "first.last", "subdomain.example.com", "com");
		}

		// Inherit the other test methods and annotations
	}

}
