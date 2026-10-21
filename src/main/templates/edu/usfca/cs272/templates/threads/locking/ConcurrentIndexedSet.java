package edu.usfca.cs272.templates.threads.locking;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ConcurrentIndexedSet<E> extends IndexedSet<E> {
	private ReentrantReadWriteLock lock;

	public ConcurrentIndexedSet() {
		this(false);
	}

	public ConcurrentIndexedSet(boolean sorted) {
		super(sorted);
		lock = new ReentrantReadWriteLock();
	}

	@Override
	public boolean add(E element) {
		// TODO
		return false;
	}

	@Override
	public boolean addAll(Collection<E> elements) {
		lock.writeLock().lock();

		try {
			return super.addAll(elements);
		}
		finally {
			lock.writeLock().unlock();
		}
	}

	@Override
	public boolean addAll(IndexedSet<E> elements) {
		lock.writeLock().lock();

		try {
			return super.addAll(elements);
		}
		finally {
			lock.writeLock().unlock();
		}
	}

	@Override
	public int size() {
		// TODO
		return -1;
	}

	@Override
	public boolean contains(E element) {
		lock.readLock().lock();

		try {
			return super.contains(element);
		}
		finally {
			lock.readLock().unlock();
		}
	}

	@Override
	public E get(int index) {
		lock.readLock().lock();

		try {
			return super.get(index);
		}
		finally {
			lock.readLock().unlock();
		}
	}

	@Override
	public E first() throws NoSuchElementException {
		lock.readLock().lock();

		try {
			return super.first();
		}
		finally {
			lock.readLock().unlock();
		}
	}

	@Override
	public E last() throws NoSuchElementException {
		lock.readLock().lock();

		try {
			return super.last();
		}
		finally {
			lock.readLock().unlock();
		}
	}

	@Override
	public IndexedSet<E> copy(boolean sorted) {
		lock.readLock().lock();

		try {
			return super.copy(sorted);
		}
		finally {
			lock.readLock().unlock();
		}
	}

	@Override
	public String toString() {
		lock.readLock().lock();

		try {
			return super.toString();
		}
		finally {
			lock.readLock().unlock();
		}
	}

	public static void main(String[] args) {
		Method[] singleMethods = IndexedSet.class.getDeclaredMethods();
		Method[] threadMethods = ConcurrentIndexedSet.class.getDeclaredMethods();

		List<String> expected = Arrays.stream(singleMethods)
				.filter(method -> Modifier.isPublic(method.getModifiers()))
				.filter(method -> !Modifier.isStatic(method.getModifiers()))
				.map(method -> method.getName()).sorted().toList();

		List<String> actual = Arrays.stream(threadMethods)
				.filter(method -> Modifier.isPublic(method.getModifiers()))
				.filter(method -> !Modifier.isStatic(method.getModifiers()))
				.map(method -> method.getName()).sorted().toList();

		System.out.println("Original Methods:");
		System.out.println(expected);

		System.out.println();
		System.out.println("Overridden Methods:");
		System.out.println(actual);
	}
}
