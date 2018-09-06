package com.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author fangji
 * 
 * 题目：https://leetcode-cn.com/problems/permutations/description/
 * 
 * 解题思路：
 * 
 * 参考资料：	
 * 	
 */
public class Question_46 {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums.length == 0) 
			return result;
		
		if (nums.length == 1) {
			List<Integer> list = new ArrayList<Integer>();
			list.add(nums[0]);
			result.add(list);
			return result;
		}
		
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			List<List<Integer>> tempResult = permute(copyIntArray(nums, nums[i]));
			for (int j = 0; j < tempResult.size(); j++) {
				List<Integer> list = tempResult.get(j);
				list.add(0, nums[i]);
			}
			result.addAll(tempResult);
		}
		return result;
	}
	
	private int[] copyIntArray(int[] nums, int valueNeedRemove) {
		int[] result = new int[nums.length - 1];
		int index = 0;
		for (int i : nums) {
			if (i == valueNeedRemove)
				continue;
			result[index++] = i;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4};
		System.out.println("permute = " + new Question_46().permute(nums));
	}
	
}
