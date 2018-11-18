package com.oracle.jdk8.lambdas;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Class to generate a list of random words
 */
public class RandomWords {

	/* words list from 'words' file */
	private final List<String> srcWords;

	/**
	 * Constructor
	 */
	public RandomWords() {

		List<String> result = null;
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("words").getFile());
		try (BufferedReader fileReader = Files.newBufferedReader(Paths.get(file.getAbsolutePath()))) {
			result = fileReader.lines().collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		srcWords = result;
	}

	/**
	 * Create a list of a given size containing random words
	 * 
	 * @param listSize The size of the list to create
	 * @return The created list
	 */
	public List<String> createList(int listSize) {
		return new Random().ints(0, listSize, srcWords.size()).mapToObj(srcWords::get).collect(Collectors.toList());
	}

	/**
	 * Return the list of all source words, which cannot be modified
	 *
	 * @return The unmodifiable list of all source words
	 */
	public List<String> allWords() {
		return Collections.unmodifiableList(srcWords);
	}
}
