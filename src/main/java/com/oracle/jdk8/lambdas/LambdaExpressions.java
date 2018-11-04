package com.oracle.jdk8.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LambdaExpressions {

	public void runExercises() {

		System.out.println("JDK 8 Lambdas and Streams MOOC Lesson 1");
		System.out.println("Running exercise 1 solution...");
		exercise1();
		System.out.println("Running exercise 2 solution...");
		exercise2();
		System.out.println("Running exercise 3 solution...");
		exercise3();
		System.out.println("Running exercise 4 solution...");
		exercise4();
		System.out.println("Running exercise 5 solution...");
		exercise5();
	}

	private void exercise5() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		new Thread(() -> list.forEach(System.out::println)).start();
	}

	private void exercise4() {
		Map<String, Integer> map = new TreeMap<>();
		map.put("c", 3);
		map.put("b", 2);
		map.put("a", 1);
		StringBuilder result = new StringBuilder();
		map.forEach((key, value) -> result.append("key: " + key + ", value: " + value + " "));
		// map.forEach((key, value) -> result.append( String.format("%s%s", key,
		// value)));

		System.out.println(result);
	}

	private void exercise3() {
		List<String> list = new ArrayList<>(Arrays.asList("alpha", "bravo", "charlie", "delta", "echo", "foxtrot"));
		list.replaceAll(String::toUpperCase);
		list.forEach(System.out::println);
	}

	private void exercise2() {
		List<String> list = new ArrayList<>(Arrays.asList("alpha", "bravo", "charlie", "delta", "echo", "foxtrot"));
		list.removeIf(s -> s.length() % 2 != 0);
		// list.removeIf(s -> (s.length()&1) == 1);
		list.forEach(System.out::println);
	}

	private void exercise1() {
		List<String> list = Arrays.asList("alpha", "bravo", "charlie", "delta", "echo", "foxtrot");
		StringBuilder result = new StringBuilder();
		list.forEach(s -> result.append(s.charAt(0)));
		System.out.println(result);
	}

	public static void main(String[] args) {
		LambdaExpressions lambdasExpression = new LambdaExpressions();
		lambdasExpression.runExercises();
	}

}
