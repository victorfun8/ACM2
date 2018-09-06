package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author fangji
 * 
 * 题目：https://leetcode-cn.com/problems/4sum/description/
 * 
 * 解题思路：
 * 
 * 参考资料：
 * 	
 */
public class Question_18 {
	
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (nums.length < 4) 
			return list;
		
		Arrays.sort(nums);
		for (int i = 0; i < nums.length-3; i++) {
			for (int j = i+1; j < nums.length-2; j++) {
				int left = j+1, right = nums.length-1;
				while (left < right) {
					int temp = nums[i] + nums[j] + nums[left] + nums[right];
					if (temp == target) {
						List<Integer> tempList = new ArrayList<Integer>();
						tempList.add(nums[i]);
						tempList.add(nums[j]);
						tempList.add(nums[left]);
						tempList.add(nums[right]);
						
						list.add(tempList);
						while (left < right && nums[right] == nums[right-1]) {
							right--;							
						}
						right--;
						while (left < right && nums[left] == nums[left+1]) {
							left++;						
						}
						left++;
					} else if (temp > target) {
						while (left < right && nums[right] == nums[right-1]) {
							right--;							
						}
						right--;
					} else {
						while (left < right && nums[left] == nums[left+1]) {
							left++;						
						}
						left++;
					}
				}
				while (j < nums.length - 2 && nums[j] == nums[j+1]) {
					j++;
				}
			}
			while (i < nums.length - 3 && nums[i] == nums[i+1]) {
				i++;
			}
		}
		return list;
    }
	
	public static void main(String[] args) {
		int[] nums = {-1,0,-5,-2,-2,-4,0,1,-2};
		int target = -9;
		System.out.println("letterCombinations = " + new Question_18().fourSum(nums, target));
	}
}
