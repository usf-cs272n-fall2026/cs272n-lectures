package edu.usfca.cs272.lectures.testing;

import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/// Parses an email into its local, domain, and top-level domain components.
/// Does not do full email validation. Demonstrates unit testing.
///
/// @author CS 272 Software Development (University of San Francisco)
/// @version Fall 2026
public class EmailParser {

	/// Stores the different components of an email.
	///
	/// @param email  the entire email address
	/// @param local  the local component of the email address (before the @ sign)
	/// @param domain the domain component of the email address (after the @ sign)
	/// @param tld    the top-level domain component of the email address
	public static record Email(String email, String local, String domain, String tld) {
		@Override
		public String toString() {
			String format = "Email: %s, Local: %s, Domain: %s, TLD: %s";
			return format.formatted(email, local, domain, tld);
		}
	}

	/// The regular expression used to match email addresses.
	private static final String EMAIL_REGEX = "(.+)@(.+)";

	// "(.+)@(.+)"; // (fails because no group for tld)
	// "(.+)@(.+(\\..*))"; // (fails because period in tld)
	// "(.+)@(.+\\.(.*))"; // (fails no period in domain test)
	// "(.+?)@(.+?(?:\\.([^.]+?))?)"; // (fails multiple @ symbols test)
	// "([^@]+)@([^@]+?(?:\\.([^@.]+))?)"; // (passes these tests)

	/// The pattern object used to represent the email regular expression.
	private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

	/// Parses a simple email into its local, domain, and top-level domain
	/// components. Does not do full email validation.
	///
	/// @param email the email address to parse into components
	/// @return the [Email] with local, domain, and top-level domain components
	/// @throws URISyntaxException if unable to parse the email
	public static Email parseEmail(String email) throws URISyntaxException {
		Matcher matcher = EMAIL_PATTERN.matcher(email);

		if (!matcher.matches()) {
			throw new URISyntaxException(email, "Unable to parse email.");
		}

		String match = matcher.group(0);
		String local = matcher.group(1);
		String domain = matcher.group(2);
		String tld = matcher.group(3);

		return new Email(match, local, domain, tld);
	}
}
