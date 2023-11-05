package com.urman.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EpamGroupAnagram {

	public static void main(String[] args) {

		String[] list = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> result = groupAnagrams(list);
		System.out.println(result);

	}

	private static List<List<String>> groupAnagrams(String[] list) {
		List<List<String>> result = new ArrayList<>(0);
		for (int i = 0; i < list.length; i++) {
			List<String> group = new ArrayList<>(0);
			boolean isNewGroup = false;
			if (!result.stream().flatMap(r -> r.stream()).toList().contains(list[i])) {
				isNewGroup = true;
				group.add(list[i]);
			} else {
				String s = list[i];
				group = result.stream().filter(r -> r.contains(s)).findFirst().get();
			}
			for (int j = i + 1; j < list.length; j++) {
				if (isAnagram(list[i], list[j]))
					group.add(list[j]);

			}
			if (isNewGroup)
				result.add(group);

		}
		return result;
	}

	private static boolean isAnagram(String s1, String s2) {

		if (null != s1 && null != s2) {
			if (s1.length() != s2.length()) {
				return false;
			} else {
				char[] s1Chars = s1.toCharArray();
				char[] s2Chars = s2.toCharArray();
				Arrays.sort(s1Chars);
				Arrays.sort(s2Chars);
				if (new String(s1Chars).equals(new String(s2Chars)))
					return true;
			}
		}
		return false;

	}

}
