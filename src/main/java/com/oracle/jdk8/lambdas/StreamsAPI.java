package com.oracle.jdk8.lambdas;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * JDK 8 Lambdas and Streams MOOC Lesson 2
 */
public class StreamsAPI {

	/* Regular expression for file */
	private static final String WORD_REGEXP = "[- .:,]+";

	/* Sample list */
	List<String> list = Arrays.asList("The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG");

	/**
	 * Method to run all the exercises.
	 * 
	 * @throws IOException
	 */
	public void runExercises() throws IOException {
		System.out.println("JDK 8 Lambdas and Streams MOOC Lesson 2");
		System.out.println("Running exercise 1 solution...");
		exercise1();
		System.out.println("Running exercise 2 solution...");
		exercise2();
		System.out.println("Running exercise 3 solution...");
		exercise3();
		System.out.println("Running exercise 4 solution...");
		exercise4(fileReader("SonnetI.txt"));
		System.out.println("Running exercise 5 solution...");
		exercise5(fileReader("SonnetI.txt"));
		System.out.println("Running exercise 6 solution...");
		exercise6(fileReader("SonnetI.txt"));
		System.out.println("Running exercise 7 solution...");
		exercise7(fileReader("SonnetI.txt"));
	}

	/**
	 * Method to return the BufferedReader object for the file in resource folder.
	 * 
	 * @param fileName
	 * @return reader
	 * @throws IOException
	 */
	public BufferedReader fileReader(String fileName) throws IOException {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
		BufferedReader reader = Files.newBufferedReader(Paths.get(file.getAbsolutePath()), StandardCharsets.UTF_8);
		return reader;
	}

	public static void main(String[] args) throws IOException {
		StreamsAPI streamsApi = new StreamsAPI();
		streamsApi.runExercises();
	}

	/**
	 * Modify exercise6 so that the words are sorted by length
	 * 
	 * @param reader
	 * @throws IOException
	 */
	private void exercise7(BufferedReader reader) throws IOException {
		List<String> words = reader.lines().flatMap(line -> Stream.of(line.split(WORD_REGEXP))).map(String::toLowerCase)
				.distinct().sorted((a, b) -> a.length() - b.length()).collect(Collectors.toList());
		words.stream().forEach(System.out::println);
		reader.close();
	}

	/**
	 * Using the BufferedReader to access the file create a list of words from the
	 * file, converted to lower-case and with duplicates removed, which is sorted by
	 * natural order. Print the contents of the list.
	 * 
	 * @param reader
	 * @throws IOException
	 */
	private void exercise6(BufferedReader reader) throws IOException {
		List<String> words = reader.lines().flatMap(line -> Stream.of(line.split(WORD_REGEXP))).map(String::toLowerCase)
				.distinct().sorted().collect(Collectors.toList());
		words.stream().forEach(System.out::println);
		reader.close();

	}

	/**
	 * Using the BufferedReader to access the file, create a list of words with no
	 * duplicates contained in the file. Print the words.
	 * 
	 * @param reader
	 * @throws IOException
	 * 
	 */
	private void exercise5(BufferedReader reader) throws IOException {
		List<String> words = reader.lines().flatMap(line -> Stream.of(line.split(WORD_REGEXP))).distinct()
				.collect(Collectors.toList());
		words.stream().forEach(System.out::println);
		reader.close();
	}

	/**
	 * Count the number of lines in the file using the BufferedReader provided
	 * 
	 * @param reader
	 * @throws IOException
	 */
	private void exercise4(BufferedReader reader) throws IOException {
		System.out.println(reader.lines().count());
		reader.close();
	}

	/**
	 * Join the second, third and forth strings of the list into a single string,
	 * where each word is separated by a hyphen (-). Print the resulting string.
	 */
	private void exercise3() {
		List<String> list = Arrays.asList("The", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog");
		String result = list.stream().skip(1).limit(3).collect(Collectors.joining("-"));
		System.out.println(result);
	}

	/**
	 * Modify exercise 1 so that the new list only contains strings that have an odd
	 * length
	 */
	private void exercise2() {
		List<String> newList = list.stream().filter(s -> s.length() % 2 != 0).map(String::toLowerCase)
				.collect(Collectors.toList());
		newList.forEach(System.out::println);
	}

	/**
	 * Create a new list with all the strings from original list converted to lower
	 * case and print them out.
	 */
	private void exercise1() {
		List<String> newList = list.stream().map(String::toLowerCase).collect(Collectors.toList());
		newList.forEach(System.out::println);
	}
}
