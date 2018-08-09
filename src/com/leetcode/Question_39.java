package com.leetcode;

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
 * 题目：https://leetcode-cn.com/problems/combination-sum/description/
 * 
 * 解题思路：	
 * 
 * 参考资料：	
 * 	
 */
public class Question_39 {
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		if (candidates.length == 0) {
			return result;
		}
		Arrays.sort(candidates);
		if (candidates[0] > target) {
			return result;
		}
		int len = candidates.length;
		int index = 0;
		for (int i = 0; i < len; i++) {
			if (candidates[i] == target) {
				List<Integer> list = new ArrayList<Integer>();
				list.add(candidates[i]);
				result.add(list);
			} else if (candidates[i] < target) {
				index++;
			} else {
				break;
			}
		}
		
		for (int i = 0; i < index; i++) {			
			List<List<Integer>> list = combinationSum(candidates, target - candidates[i]);
				
			if (list.size() > 0) {
				for (int j = 0; j < list.size(); j++) {
					List<Integer> newTemp = new ArrayList<Integer>();
					newTemp.add(candidates[i]);
					newTemp.addAll(list.get(j));
					Collections.sort(newTemp);	
					if(!result.contains(newTemp)) {
						result.add(newTemp);						
					}
				}
			}
			
		}
		
		return result;
	}
	
	public static void main(String[] args) {
//		int[] candidates = new int[]{2,3,6,7};
//		int target = 8;
//		int[] candidates = new int[]{2,3,6,7};
//		int target = 7;
//		int[] candidates = new int[]{8,7,4,3};
//		int target = 11;
		int[] candidates = new int[]{7,3,9,6};
		int target = 6;
		System.out.println("combinationSum = " + new Question_39().combinationSum(candidates, target));
	}
	
}
