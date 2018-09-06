package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author fangji
 * 
 * 题目：https://leetcode-cn.com/problems/3sum-closest/description/
 * 
 * 解题思路：
 * 
 * 参考资料：
 * 	
 */
public class Question_16 {
	
	public int threeSumClosest(int[] nums, int target) {
		if (nums.length < 3) {
			return 0; 
		}
		
		int min = Integer.MAX_VALUE;
		int result = 0;
		Arrays.sort(nums);
		for (int index = 0; index < nums.length - 1; index++) {
			int left = index + 1, right = nums.length - 1;
			while (left < right) {
				int temp = target - nums[index] - nums[left] - nums[right];
				if (min > Math.abs(temp)) {
					min = Math.abs(temp);
					result = nums[left] + nums[index] + nums[right];	
				}

				if (temp < 0) {
					right--;
				} else {
					left++;
				}
			}
            while (index < nums.length -1 && nums[index] == nums[index+1]) {
                index++;
            }
		}
		
		return result;
    }
	
	public static void main(String[] args) {
//		int[] nums = {-1,2,-3,-3 ,0,6,4,-5,6};
//		int[] nums = {0, 0};
//		int[] nums = {-1,0,1,0};
//		int[] nums = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
//		int[] nums = {-1,2,1,-4};
//		int[] nums = {1,1,1,0};
		int[] nums = {-1,0,1,1,55};
//		int[] nums = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		int target = 3;
		System.out.println("threeSumClosest = " + new Question_16().threeSumClosest(nums, target));
	}
}
