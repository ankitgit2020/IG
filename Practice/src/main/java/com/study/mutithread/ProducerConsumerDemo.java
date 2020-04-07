package com.study.mutithread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class ProducerConsumerDemo {

	static int i = 0 ;
	
	public static void main(String[] args) {
		
		BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
		
		final Runnable producer = () -> {
			while(true) {
				try {
					queue.put(createName());
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
		};
		final Runnable consumer = () -> {
			while(true) {
				try {
					System.out.println(queue.take());
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
		};
		
		new Thread(consumer).start();
		new Thread(producer).start();
		
	}
	
	public static String createName(){
		
		return "Name" + (++i) ;
	}
}
