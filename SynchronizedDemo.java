package com.collabera.multithreading;

class Counter {

	int count;
	
	//Only one thread can work with this method at a time!
	//The other thread(s) will have to wait for the one currently accessing it to be done to access it themselves
	public synchronized void increment() {

		count++; //Two tasks; addition and assignment
		//count = count + 1;
	}

}

public class SynchronizedDemo {

	public static void main(String[] args) throws InterruptedException {

		Counter c = new Counter();
		// c.increment();

		Thread t1 = new Thread(new Runnable() {

			public void run() {
				for (int i = 1; i <= 1000; i++) {
					c.increment();
				}
			}

		});

		Thread t2 = new Thread(new Runnable() {

			public void run() {
				for (int i = 1; i <= 1000; i++) {
					c.increment();
				}
			}

		});

		t1.start();
		t2.start();

		// Main thread, wait for t1...
		t1.join();
		t2.join();

		System.out.println("Count " + c.count);

	}

}
