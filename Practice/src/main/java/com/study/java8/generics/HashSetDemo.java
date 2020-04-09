package com.study.java8.generics;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {

	public static void main(String[] args) {
		
		E1 e1 = new E1(1);
		E1 en = new E1(1);
		
		E2 e2 = new E2(2);
		E1 ex = e1;
		
		Set set = new HashSet();
		set.add(e1);
		set.add(en);
		set.add(ex);
		
		System.out.println(set.size());
	}
	
}

class E1 {
	
	int id;
	String name;
	
	E1(int id){
		this.id = id;
	}
	
	@Override
    public boolean equals(Object o) {
		
		if(o instanceof E1) {
			E1 e = (E1)o;
			return e.id == id;
	}
		return false;
  }
	
	@Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Integer.valueOf(id).hashCode();
       
        return result;
    }
}

class E2 {
	
	int id;
	String name;
	
	E2(int id){
		this.id = id;
	}
}

