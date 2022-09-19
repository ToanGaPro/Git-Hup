package com.example.app;

import java.util.List;

public class Lambda {
	  public static void main(String[] args) {
		  demo1();
	  }

	private static void demo1() {
		List<Integer> list = Arrays.asList(3,4,9,5,8,7);
		list.forEach(n -> System.out.println(n));
	}
	  
}
