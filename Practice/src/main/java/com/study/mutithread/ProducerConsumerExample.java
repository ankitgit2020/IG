package com.study.mutithread;

import java.util.Vector;


public class ProducerConsumerExample {
	
	Vector<Integer> sharedQueue = new Vector<>();
	
    public static void main(String args[]) {

        ProducerConsumerExample obj = new ProducerConsumerExample();
        
        	Thread prodThread = new Thread(new Producer(obj.sharedQueue), "Producer");
        	Thread consThread = new Thread(new Consumer(obj.sharedQueue), "Consumer");
        	prodThread.start();
            consThread.start();       
    }
}

class Producer implements Runnable {

	Vector<Integer> sharedQueue = new Vector<>();
	int i = 0;
	Producer(Vector<Integer> sharedQueue){
		this.sharedQueue = sharedQueue;
	}
	@Override
	public void run() {		
			
		synchronized(sharedQueue) {
			while(true) {
			
			sharedQueue.add(i);
			try {				
					Thread.sleep(1000);
					sharedQueue.wait();
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}			
			}
		}
	}	
}

class Consumer implements Runnable {

	Vector<Integer> sharedQueue = new Vector<>();
	Consumer(Vector<Integer> sharedQueue){
		this.sharedQueue = sharedQueue;
	}
	@Override
	public void run() {		
		
		while(true) {
			
			System.out.println("Capacity: "+ sharedQueue.capacity() + "  Size=" + sharedQueue.size() );
			try {
				synchronized(sharedQueue) {
					Thread.sleep(500);
					sharedQueue.notify();
				}
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		
		}
		
	}
	
	
	
}
