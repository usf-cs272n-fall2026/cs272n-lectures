package edu.usfca.cs272.templates.inheritance.gadget;

// TODO Fix declaration
public class Gadget {
	private final int id;
	private final String name;

	public Gadget(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int id() {
		return id;
	}

	public String name() {
		return name;
	}

	// TODO Implement Comparable interface
}
