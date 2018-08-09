package com.leetcode;

public class Question_1 {
	public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
            for (int i = 0; i < length; i++) {
            	if (i == length - 1) {
            		break;
            	}
            	for (int j = i + 1; j < length; j++) {
            		if (nums[i] + nums[j] == target) {
            			return new int[]{i, j};
            		}
            	}
            }
            return new int[]{};
    }
}
