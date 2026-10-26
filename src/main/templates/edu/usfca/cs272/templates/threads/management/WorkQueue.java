package edu.usfca.cs272.templates.threads.management;

import java.util.LinkedList;

public class WorkQueue {
	private final Worker[] workers;
	private final LinkedList<Runnable> tasks;
	private volatile boolean shutdown;
	public static final int DEFAULT = 5;

	public WorkQueue() {
		this(DEFAULT);
	}

	public WorkQueue(int threads) {
		this.tasks = new LinkedList<Runnable>();
		this.workers = new Worker[threads];
		this.shutdown = false;

		// TODO
	}

	public void execute(Runnable task) {
		// TODO
	}

	public void shutdown() {
		// TODO
	}

	public int size() {
		return workers.length;
	}

	private class Worker extends Thread {
		public Worker() {
			setName("Worker" + getName());
		}

		@Override
		public void run() {
			Runnable task = null;

			try {
				// TODO
				Thread.sleep(100);
			}
			catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}
}
