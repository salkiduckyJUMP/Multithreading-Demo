package com.collabera.multithreading;

class Yo implements Runnable {
	
	public void run() {
		
		for(int i = 1; i <=5; i ++) {
			
			System.out.println("Hi");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}

class Yoyo implements Runnable {
	
	public void run() {
		
		for(int i = 1; i <=5; i ++) {
			
			System.out.println("Hello");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}

public class RunnableDemo {
		public static void main(String[] args) {
			Runnable obj1 = new Yo();
			Runnable obj2 = new Yoyo();
			
			//Pass in Runnable object 
			Thread t1 = new Thread(obj1);
			Thread t2 = new Thread(obj2);
			
			t1.start();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			t2.start();
			
		}
}
