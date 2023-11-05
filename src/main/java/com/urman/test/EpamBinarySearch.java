package com.urman.test;

import java.util.Arrays;

public class EpamBinarySearch {
	public static void main(String[] args) {
		int[] arr = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 13 };
		int key = 9;

		Arrays.sort(arr);

		int result = binarySearch2(arr, key);

		if (result < 0) {
			System.out.println("Element is not found!");
		} else {
			System.out.println("Element found at index " + result);
		}
	}

	private static int binarySearch1(int[] arr, int key) {
		int result = Arrays.binarySearch(arr, key);
		return result;
	}

	private static int binarySearch2(int[] arr, int key) {

		int startIndex = 0, endIndex = arr.length - 1, result = -1;

		while (startIndex <= endIndex) {
			int mid = (startIndex + endIndex) / 2;
			if (arr[mid] == key)
				return mid;
			else if (arr[mid] > key)
				endIndex = mid - 1;
			else
				startIndex = mid + 1;

		}

		return result;

	}
}
