package com.study.mutithread;


public class DistributedWork {

	Thread T1 = new Thread() {
		public void run() {
			for(int i=0;i<5;i++) {
				System.out.println("T1 "+i);
			}
		}
	};
	public static void main(String[] arg) {
		DistributedWork dw = new DistributedWork();
		dw.T1.start();
		try {
			dw.T1.join();
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		System.out.println("Hello distributed");
	}
}
