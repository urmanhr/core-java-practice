package com.urman.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class EpamIntIndex {

//	Find the index of each digits from the number 2641 in given number 62716248
//	 
//	Output -
//	2 -> 1, 5
//	6 -> 0, 4
//	4 -> 6
//	1 -> 3

	public static void main(String[] args) {

		int a = 2641, b = 62716248;

		Map<Integer, List<Integer>> output = getIndexOfEachDigits(a, b);
		System.out.println("result" + output);
	}

	private static Map<Integer, List<Integer>> getIndexOfEachDigits(int a, int b) {
		Map<Integer, List<Integer>> result = new HashMap<>();

		List<Integer> individualIntForInput = getIndividualInt(a);
		List<Integer> individualIntForSupply = getIndividualInt(b);
		individualIntForInput
				.forEach(input -> result.put(input, new ArrayList<>(IntStream.range(0, individualIntForSupply.size())
						.filter(i -> input.equals(individualIntForSupply.get(i))).boxed().toList())));

		return result;
	}

	private static List<Integer> getIndividualInt(int a) {
		return new ArrayList<Integer>(String.valueOf(a).chars().mapToObj(c -> (char) c).toList().stream()
				.map(c -> Integer.valueOf(String.valueOf(c))).toList());
	}

}
