package com.urman.test;

import java.util.Arrays;

public class EpamArrayRotation {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 3;
		int[] result = rotateArrayByGivenTimes(nums, k);
		System.out.println(Arrays.toString(result));
	}

	private static int[] rotateArrayByGivenTimes(int[] nums, int k) {
		if (null == nums)
			return null;
		int[] result = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			int currIndex = i + k;
			while (currIndex >= nums.length)
				currIndex = currIndex - nums.length;
			result[currIndex] = nums[i];
		}
		return result;
	}

	// won't work if k > size of array
	private static int[] rotateArrayByGivenTimes1(int[] nums, int k) {
		int[] result = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			result[i + k >= nums.length ? i + k - nums.length : i + k] = nums[i];
		}
		return result;
	}

}
