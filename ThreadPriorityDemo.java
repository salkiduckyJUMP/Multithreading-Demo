package com.collabera.multithreading;

public class ThreadPriorityDemo {
		public static void main(String[] args) throws InterruptedException {			
			//Thread parameters are your Runnable object followed by the name you wish to name the thread
			Thread t1 = new Thread(() -> {
				
				for(int i = 1; i <=5; i ++) {
					
					System.out.println("Hi " + Thread.currentThread().getPriority());
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}	
	}, "Hi Thread");
			Thread t2 = new Thread(() -> {
				for(int i = 1; i <=5; i ++) {
					
					System.out.println("Hello " + Thread.currentThread().getPriority());
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
		}, "Hello Thread");	
						
			//Change Thread name
			//t1.setName("Hi Thread");
			//t2.setName("Hello Thread");
			
			//First thread by default is thread-0
			System.out.println(t1.getName());
			//Next thread is thread-1 and so on.
			System.out.println(t2.getName());
			
			//Change priorities
			//t1.setPriority(1);
			//t2.setPriority(10);
			
			//Can also use Constants instead of numbers
			t1.setPriority(Thread.MIN_PRIORITY);
			t2.setPriority(Thread.MAX_PRIORITY);
			
			//Fetch priority
			//Default they both have priority of 5
			System.out.println(t1.getPriority());
			System.out.println(t2.getPriority());
			
			t1.start();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			t2.start();
			
			
			t1.join();
			t2.join();
						
		}
}
