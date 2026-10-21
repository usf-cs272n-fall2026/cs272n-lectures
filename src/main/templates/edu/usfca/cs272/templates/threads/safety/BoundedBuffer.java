package edu.usfca.cs272.templates.threads.safety;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//    0 1 2 3 4 5 6 7 8 9
//
// *...versus...*
//
//    0 1 2 3
//    9     4
//    8 7 6 5

public class BoundedBuffer<E> {
	private E[] buffer;

	private int beg;
	private int end;

	private int num;
	private int max;

	private static Logger log = LogManager.getLogger();

	public BoundedBuffer(int bufferSize) {
		buffer = newArray(bufferSize);
		beg = 0;
		end = 0;
		num = 0;
		max = buffer.length;
	}

	public /* TODO */ void put(E item) throws InterruptedException {
		log.debug("put(): adding {} in buffer.", item);

		// TODO
//		log.debug("put(): waiting until buffer not full.");
//		log.debug("put(): woke up, checking buffer.");

		log.debug("put(): buffer now has {} elements.", num);
		log.debug("put(): range is now ({}, {}).", beg, end);

		// TODO
	}

	public /* TODO */ void putAll(E[] items) throws InterruptedException {
		for (E item : items) {
			this.put(item);
		}
	}

	public /* TODO */ E get() throws InterruptedException {
		log.debug("get(): getting {} from buffer.", buffer[beg]);

		// TODO
//		log.debug("get(): waiting until buffer not empty.");
//		log.debug("get(): woke up, checking buffer.");

		log.debug("get(): buffer now has {} elements.", num);
		log.debug("get(): range is now ({}, {}).", beg, end);

		return null; // TODO
	}

	@SafeVarargs
	private static <E> E[] newArray(int length, E... unused) {
		return Arrays.copyOf(unused, length);
	}
}