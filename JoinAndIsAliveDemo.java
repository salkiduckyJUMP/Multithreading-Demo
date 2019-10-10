package com.collabera.multithreading;

public class JoinAndIsAliveDemo {

	public static void main(String[] args) throws InterruptedException {			
		Thread t1 = new Thread(() -> {
			
			for(int i = 1; i <=5; i ++) {
				
				System.out.println("Hi");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}	
});
		Thread t2 = new Thread(() -> {
			for(int i = 1; i <=5; i ++) {
				
				System.out.println("Hello");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
	});	
		t1.start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
		
		//Checks if the thread is running, returns boolean to tell you if it is or not
		System.out.println(t1.isAlive());
		
		//Return to the main thread only when the other two threads are done
		//Print only when t1 and t2 is done.
		t1.join();
		t2.join();
		
		System.out.println(t2.isAlive());
		
		System.out.println("Bye");
	}
	
}
