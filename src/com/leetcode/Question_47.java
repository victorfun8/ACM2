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
 * 题目：https://leetcode-cn.com/problems/permutations-ii/description/
 * 
 * 解题思路：
 * 
 * 参考资料：	
 * 	
 */
public class Question_47 {
	public List<List<Integer>> permuteUnique(int[] nums) {
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
			List<List<Integer>> tempResult = permuteUnique(copyIntArray(nums, i));
			for (int j = 0; j < tempResult.size(); j++) {
				List<Integer> list = tempResult.get(j);
				list.add(0, nums[i]);
			}
			for (List<Integer> list : tempResult) {
				if (!result.contains(list))
					result.add(list);
			}
		}
		return result;
	}
	
	/**
	 * 
	 * @param nums
	 * @param index 需要被删除数字的序号
	 * @return
	 */
	private int[] copyIntArray(int[] nums, int index) {
		int[] result = new int[nums.length - 1];
		int indexNew = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i == index) 
				continue;
			result[indexNew++] = nums[i];
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 1, 2};
		System.out.println("permuteUnique = " + new Question_47().permuteUnique(nums));
	}
	
}
