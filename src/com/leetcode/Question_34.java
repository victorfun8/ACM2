package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author fangji
 * 
 * 题目：https://leetcode-cn.com/problems/search-for-a-range/description/
 * 
 * 解题思路：
 * 
 * 参考资料：
 * 	
 */
public class Question_34 {
	
	public int[] searchRange(int[] nums, int target) {
		int len = nums.length;
		if (len == 0) {
			return new int[]{-1, -1};
		} else if (len == 1) {
			if (nums[0] == target) {
				return new int[]{0, 0};
			} else {
				return new int[]{-1, -1};
			}
		}
		
		int indexStart= 0;
		int indexEnd = len - 1;
		boolean hasEqual = false;
		
		while (indexStart < indexEnd && !hasEqual) {
			if (indexEnd - indexStart == 1) {
				if (nums[indexStart] != target) {
					indexStart = indexEnd;
				}
				if (nums[indexEnd] != target) {
					indexEnd = indexStart;
				}
			}
			
			int mid = (indexStart + indexEnd) / 2;
			if (nums[mid] > target) {
				indexEnd = mid;
			} else if (nums[mid] < target) {
				indexStart = mid;
			} else {
				hasEqual = true;
				indexStart = mid;
				indexEnd = mid;
				int tempIndexJianFa = mid;
				while (--tempIndexJianFa >= 0 && nums[tempIndexJianFa] == target) {
					indexStart = tempIndexJianFa;
				}
				int tempIndexJiaFa = mid;
				while (++tempIndexJiaFa <= (len - 1) && nums[tempIndexJiaFa] == target) {
					indexEnd = tempIndexJiaFa;
				}
				break;
			}
		}
		
		if (!hasEqual) {
			indexStart = -1;
			indexEnd = -1;
		}
		int[] result = {indexStart, indexEnd};
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		return result;
	}
	
	public static void main(String[] args) {
//		int[] nums = {5,7,7,8,8,10};
//		int target = 6;
//		int[] nums = {5,7,7,8,8,10};
//		int target = 8;
//		int[] nums = {1,2,2};
//		int target = 2;
//		int[] nums = {1};
//		int target = 1;
//		int[] nums = {2, 2};
//		int target = 2;
//		int[] nums = {1, 4};
//		int target = 4;
		int[] nums = {1, 2, 3};
		int target = 3;
		System.out.println("search = " + new Question_34().searchRange(nums, target));
	}
	
}
