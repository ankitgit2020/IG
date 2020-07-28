package com.study.Practice;

class Parent {
	
	public void show() {

		System.out.println("Inside parent show");
	}
}
class Child extends Parent {
	
	public void show() {

		System.out.println("Inside Child show");
	}
}

public class App {
	
	protected static int instanceVariable = 0;
	
	public void show(String watcher) {

		System.out.println("Show is watched by " + watcher);
	}

	public void show(int watcher) {

		System.out.println("No of persone watched show " + watcher);
	}

	public static void main(String[] args) {
		//Overloading example
		App app = new App();
		app.show(null);
		System.out.println("Hello World!");
		 
		Parent c = new Child();
		//var tmp = 10;
		
		System.out.println(instanceVariable);
		
	}
}
