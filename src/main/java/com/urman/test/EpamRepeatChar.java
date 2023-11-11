package com.urman.test;

import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class EpamRepeatChar {

//	Given a String, find the second non-repeated character using Stream functions
//	 
//	String input = "Java articles are Awesome";
//	Output - v

	public static void main(String[] args) {
		String s = "Java articles are Awesome";
		System.out.println(s.chars().mapToObj(c -> (char) c).toList().stream()
				.collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.toList())).entrySet().stream()
				.filter(a -> a.getValue().size() == 1).map(x -> x.getKey()).toList().get(1));
	}

}
