package edu.usfca.cs272.lectures.inheritance.gadget;

/**
 * A simple record that knows how to compare against other objects of this type
 * by implementing the {@link Comparable} interface. For more details, visit the
 * <a href="https://docs.oracle.com/en/java/javase/25/language/records.html">
 * Record Classes</a> documentation.
 *
 * @author CS 272 Software Development (University of San Francisco)
 * @version Fall 2026
 *
 * @param id the gadget it
 * @param name the gadget name
 */
record Gadget(int id, String name) implements Comparable<Gadget> {
	/**
	 * By default, {@link #Gadget} objects will be sorted by the gadget id.
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo(Gadget other) {
		return Integer.compare(this.id, other.id);
	}
}
