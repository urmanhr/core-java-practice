package com.urman.test;

import java.util.Arrays;

public class EpamPushZeroToEnd {

	public static void main(String[] args) {
		int[] data = { 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0 };
		int[] result = pushZerosToEnd(data);
		System.out.println(Arrays.toString(result));
	}

	private static int[] pushZerosToEnd(int[] data) {
		if (null == data)
			return null;
		int[] result = new int[data.length];
		int resultIndex = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i] != 0)
				result[resultIndex++] = data[i];
		}

		while (resultIndex < data.length - 1) {
			result[resultIndex++] = 0;
		}
		return result;
	}

}
