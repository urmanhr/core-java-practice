package com.urman.test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class EpamSpecificWord {

	public static void main(String[] args) {
		List<String> textList = Arrays.asList("Java is a programming language.",
				"Python is another programming language.", "Java and Python are popular choices.", null);
		String targetWord = "Java";
		int occurances = findOccurancesOfTargetWordInList(textList, targetWord);
		System.out.println("Result: " + occurances);
	}

	private static int findOccurancesOfTargetWordInList(List<String> textList, String targetWord) {
		if (null != textList && !textList.isEmpty()) {
			System.out.println(
					textList.parallelStream().filter(text -> text != null && text.contains(targetWord)).toList());
			return textList.parallelStream().filter(text -> text != null && text.contains(targetWord)).toList().size();
		}
		return 0;
	}

	private static int findOccurancesOfTargetWordInList1(List<String> textList, String targetWord) {
		AtomicInteger o = new AtomicInteger(0);
		if (null != textList && !textList.isEmpty()) {
			textList.parallelStream().forEach(text -> {
				if (null != text && text.contains(targetWord))
					o.incrementAndGet();
			});
		}
		return o.get();
	}

}
