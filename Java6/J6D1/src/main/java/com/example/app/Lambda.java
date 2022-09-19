package com.example.app;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.example.bean.Student;

public class Lambda {
	static List<Student> list =  Arrays.asList(
			new Student("teo",false,9.0),
			new Student("ngo",false,4.0),
			new Student("thang",false,1.0),
			new Student("toan",false,8.0),
			new Student("tung",false,2.0)
			);
	public static void main(String[] args) {
		demo4();
		
	}

	private static void demo4() {
//		demo4Inter o = new demo4Inter() {
//			
//			@Override
//			public void m1(int x) {
//				System.out.println(x);
//				
//			}
//		};
//		o.m1(2002);
		demo4Inter o = (int x) -> {
			System.out.println(x);
		
		};
		o.m1(2002);
		
	}
	@FunctionalInterface
	interface demo4Inter{
		void m1(int x);
		default void m2() {}
		public static void m3() {}
	}
	private static void demo3() {
		Collections.sort(list , (sv1,sv2) -> -sv1.getMarks().compareTo(sv2.getMarks()));
		list.forEach(sv ->{ 
			System.out.println("Name : "+sv.getName());
			System.out.println("Marks: "+sv.getMarks());
			System.out.println();
		});
		
	}

	private static void demo2() {
		 List<Student> list =  Arrays.asList( // tao ra list co 5 sv:
					new Student("teo",false,9.0),
					new Student("ngo",false,9.0),
					new Student("thang",false,9.0),
					new Student("toan",false,9.0),
					new Student("tung",false,9.0)
					);
		list.forEach(sv ->{ // duyet qua moi phan tu "sv" 
			System.out.println(sv.getName());
			System.out.println(sv.getMarks());
			System.out.println();
		});
		
	}

	private static void demo1() {
		List<Integer> list = Arrays.asList(4,5,3,8,9); // tao ra list so nguyen 
		list.forEach(n -> System.out.println(n)); // dung vong lap de duyet va xuat
		
	}
}
