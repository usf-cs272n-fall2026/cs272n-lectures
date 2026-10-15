package edu.usfca.cs272.templates.threads.safety;

public class LockDemo {
	private Worker worker1;
	private Worker worker2;

	private final static Object staticKey = new Object();
	private final Object instanceKey1;
	private final Object instanceKey2;

	public LockDemo(String name) {
		instanceKey1 = new Object();
		instanceKey2 = new Object();

		worker1 = new Worker(staticKey);
		worker2 = new Worker(staticKey);

		// TODO
	}

	private class Worker extends Thread {
		private final Object lock;

		public Worker(Object lock) {
			this.lock = lock;
		}


		@Override
		public void run() {
			// TODO

			// System.out.println(this.getName() + " Lock?: " + Thread.holdsLock(lock) + "\t\t" + enter.toString());
			// System.out.println(this.getName() + " Lock?: " + Thread.holdsLock(lock) + "\t\t" + exit.toString());
		}
	}

	// +---LockDemo A---+ +---LockDemo B---+
	// | +-A1-+  +-A2-+ | | +-B1-+  +-B2-+ |
	// | |    |  |    | | | |    |  |    | |
	// | +----+  +----+ | | +----+  +----+ |
	// +----------------+ +----------------+

	public static void main(String[] args) throws InterruptedException {
		LockDemo a = new LockDemo("A");
		LockDemo b = new LockDemo("B");

		try {
			Thread.sleep(500);
		}
		catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}

		System.out.println();
		System.out.println("A1 State: " + a.worker1.getState());
		System.out.println("A2 State: " + a.worker2.getState());
		System.out.println("B1 State: " + b.worker1.getState());
		System.out.println("B2 State: " + b.worker2.getState());
		System.out.println();

		a.joinAll();
		b.joinAll();
	}

	public void joinAll() throws InterruptedException {
		worker1.join();
		worker2.join();
	}

	public void outputHashcodes() {
		System.out.println(System.identityHashCode(this));
		System.out.println(System.identityHashCode(instanceKey1));
		System.out.println(System.identityHashCode(instanceKey2));

		System.out.println(System.identityHashCode(staticKey));
		System.out.println(System.identityHashCode(LockDemo.class));

		System.out.println(System.identityHashCode(worker1.lock));
		System.out.println(System.identityHashCode(worker2.lock));
	}
}
