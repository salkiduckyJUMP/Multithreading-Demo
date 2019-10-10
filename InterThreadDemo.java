package com.collabera.multithreading;

class A {
	int num;
	boolean valueSet = false;
	
	public synchronized void put(int num) {
		//If value is already put, wait and do not put it again until it's empty.
		while(valueSet) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Put:" + num);
		this.num = num;
		valueSet = true;
		//Tell Consumer to go
		notify();
	}
	
	public synchronized void get() {
		while(!valueSet) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Get:" + num);
		valueSet=false;
		//Tell Producer to go
		notify();
	}
}

class Producer implements Runnable {
	
	A a;

	public Producer(A a) {
		this.a = a;
		Thread t = new Thread(this, "Producer");
		t.start();
	}
	
	public void run() {
		int i=0;
		while(true) {
			
			a.put(i++);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			
			}
		}
	}
	
	
}

class Consumer implements Runnable {
	
	A a;
	

	public Consumer(A a) {
		this.a = a;
		Thread t = new Thread(this, "Consumer");
		t.start();
	}
	
	public void run() {
		while(true) {
			a.get();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			
			}
		}
	}
	
	
}

public class InterThreadDemo {
	
	public static void main(String[] args) {
		
		A a = new A();
		new Producer(a);
		new Consumer (a);
		
	}

}
