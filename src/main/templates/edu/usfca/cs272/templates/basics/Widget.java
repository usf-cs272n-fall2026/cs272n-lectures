package edu.usfca.cs272.templates.basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Widget {
	private String widgetName;
	private final int widgetID;

	private static int numWidgets = 0;
	private static final ArrayList<String> widgetNames = new ArrayList<>();

	public static boolean debug = false;

	public Widget(String widgetName) {
		this.widgetName = widgetName;
		this.widgetID = ++numWidgets;

		Widget.widgetNames.add(widgetName);

		if (debug) {
			System.out.println("Created widget #" + widgetID + " named " + widgetName + ".");
		}
	}

	public Widget() {
		this("Widget");
	}

	public static int numWidgets() {
		return Widget.numWidgets;
	}

	public static List<String> getNamesUnsafe() {
		return widgetNames;
	}

	public static List<String> getNames() {
		return Collections.unmodifiableList(widgetNames);
	}

	public String getName() {
		return this.widgetName;
	}

	private static boolean validName(String name) {
		return name != null && !name.strip().isBlank();
	}

	public boolean setName(String newName) {
		boolean valid = validName(newName);

		if (valid) {
			this.widgetName = newName;
		}
		else if (debug) {
			System.out.println("Failed to change name for widget " + this);
		}

		return valid;
	}

	@Override
	public String toString() {
		return widgetName + " (" + widgetID + ")";
	}
}
