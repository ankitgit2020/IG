package com.study.Day1.concurrentds;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemo {

    public static void main(String[] args) throws Exception {

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(4);

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        new Thread(consumer).start();
        new Thread(producer).start();
       

        Thread.sleep(4000);
    }
}

class Producer implements Runnable{

    protected BlockingQueue<Integer> queue = null;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            queue.put(1);
            System.out.print(queue);
            Thread.sleep(1000);
            queue.put(2);
            System.out.print(queue);
            Thread.sleep(1000);
            queue.put(3);
            queue.put(4);
            queue.put(5);
   
            System.out.println(queue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable{

    protected BlockingQueue<Integer> queue = null;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
        	while(true) {
            System.out.println("Take action "+queue.take());

        	}
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}