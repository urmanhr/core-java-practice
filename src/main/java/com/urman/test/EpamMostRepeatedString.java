package com.urman.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EpamMostRepeatedString {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("apple", "banana", "apple", "orange", "apple", "banana");
		String result = getMostRepeatedString(list);
		System.out.println(result);
	}

	private static String getMostRepeatedString(List<String> list) {
		return list.stream().collect(Collectors.groupingBy(s -> s)).entrySet().stream()
				.max((a, b) -> a.getValue().size() - b.getValue().size()).get().getKey();
	}

}
