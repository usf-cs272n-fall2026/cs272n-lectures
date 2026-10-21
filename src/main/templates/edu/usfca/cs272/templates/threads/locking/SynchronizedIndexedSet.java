package edu.usfca.cs272.templates.threads.locking;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

public class SynchronizedIndexedSet<E> extends IndexedSet<E> {
	public SynchronizedIndexedSet() {
		// TODO
	}

	public SynchronizedIndexedSet(boolean sorted) {
		// TODO
	}

	// TODO
	// Use "Override/Implement Methods" under the "Source" menu in Eclipse

	public static void main(String[] args) {
		Method[] singleMethods = IndexedSet.class.getDeclaredMethods();
		Method[] threadMethods = SynchronizedIndexedSet.class.getDeclaredMethods();

		List<String> expected = Arrays.stream(singleMethods)
				.filter(method -> Modifier.isPublic(method.getModifiers()))
				.filter(method -> !Modifier.isStatic(method.getModifiers()))
				.map(method -> method.getName()).sorted().toList();

		List<String> actual = Arrays.stream(threadMethods)
				.filter(method -> Modifier.isSynchronized(method.getModifiers()))
				.map(method -> method.getName()).sorted().toList();

		System.out.println("Original Methods:");
		System.out.println(expected);

		System.out.println();
		System.out.println("Synchronized Methods:");
		System.out.println(actual);
	}
}
