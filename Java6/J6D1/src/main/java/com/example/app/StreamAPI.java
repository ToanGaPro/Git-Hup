package com.example.app;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.bean.Student;

public class StreamAPI {
	static List<Student> list =  Arrays.asList(
			new Student("teo",false,9.0),
			new Student("ngo",false,4.0),
			new Student("thang",false,1.0),
			new Student("toan",false,8.0),
			new Student("tung",false,2.0)
			);
	public static void main(String[] agrs){
		demo3();
	}

	private static void demo3() {
		List<Student> result = list.stream()
				.filter(sv -> sv.getMarks() >= 7)
				.peek(sv -> sv.setName(sv.getName().toUpperCase())) // duyet sv đó và lấy tên sinh vn đó > 7 ra in hoa
				.collect(Collectors.toList()); // lấy các thông tin đó
		result.forEach(sv ->{ 
			System.out.println("Name : "+sv.getName());
			System.out.println("Marks: "+sv.getMarks());
			System.out.println();
		});
		
	}

	private static void demo2() {
		List<Integer> list = Arrays.asList(1,3,4,6,8);
		List<Double> result = list.stream() // Stream có các số nguyên Stream interger
				.filter(n -> n%2 ==0) // lọc filter lấy các số nguyên số chăn Stream integer
				.map(n -> Math.sqrt(n)) //map chuyển đổi kiểu này sang kiểu khác Stream doble
				.peek(d -> System.out.println(d)) // peek nhu vong for nó cho kết quả đây stream double
				.collect(Collectors.toList()); // kết thucs thu thập dữ liệu chuyển thành cái list double
		
	}

	private static void demo1() {
		Stream<Integer> stream1 = Stream.of(1,3,4,67,8);
		stream1.forEach(n -> {
			System.out.println(n);
		});
		List<Integer> list = Arrays.asList(1,3,4,67,8);
		list.stream().forEach(n ->
		{
			System.out.println(n);
		}
				);
		
	}
}
