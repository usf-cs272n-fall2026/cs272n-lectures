package edu.usfca.cs272.templates.threads.locking;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;

public class IndexedSet<E> {
	private final Set<E> set;

	public IndexedSet() {
		this(false);
	}

	public IndexedSet(boolean sorted) {
		set = sorted ? new TreeSet<E>() : new HashSet<E>();
	}

	public boolean add(E element) {
		return set.add(element);
	}

	public boolean addAll(Collection<E> elements) {
		return set.addAll(elements);
	}

	public boolean addAll(IndexedSet<E> elements) {
		return set.addAll(elements.set);
	}

	public int size() {
		return set.size();
	}

	public boolean contains(E element) {
		return set.contains(element);
	}

	public E get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= set.size()) {
			throw new IndexOutOfBoundsException(index);
		}

		return set.stream().skip(index).findFirst().get();
	}

	public E first() throws NoSuchElementException {
		checkEmpty();
		return get(0);
	}

	public E last() throws NoSuchElementException {
		checkEmpty();
		return get(set.size() - 1);
	}

	private void checkEmpty() throws NoSuchElementException {
		if (set.isEmpty()) {
			throw new NoSuchElementException();
		}
	}

	public IndexedSet<E> unsortedCopy() {
		return copy(false);
	}

	public IndexedSet<E> sortedCopy() {
		return copy(true);
	}

	public IndexedSet<E> copy(boolean sorted) {
		IndexedSet<E> copy = new IndexedSet<>(sorted);
		copy.addAll(set);
		return copy;
	}

	@Override
	public String toString() {
		return set.toString();
	}

	public static void main(String[] args) {
		List<String> elements = List.of("ant", "fox", "fly", "bee");

		IndexedSet<String> sorted = new IndexedSet<>(true);
		sorted.addAll(elements);

		System.out.println(sorted);
		System.out.println(sorted.first());
		System.out.println(sorted.get(0));
		System.out.println(sorted.unsortedCopy());

		System.out.println();

		IndexedSet<String> unsorted = new IndexedSet<>();
		unsorted.addAll(elements);

		System.out.println(unsorted);
		System.out.println(unsorted.last());
		System.out.println(unsorted.get(3));
		System.out.println(unsorted.sortedCopy());

		System.out.println();

		System.out.println(unsorted.get(10));
	}
}
