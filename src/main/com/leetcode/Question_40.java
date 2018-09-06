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
 * 题目：https://leetcode-cn.com/problems/combination-sum-ii/description/
 * 
 * 解题思路：	
 * 
 * 参考资料：	
 * 	
 */
public class Question_40 {
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
				if (result.size() == 0) {					
					List<Integer> list = new ArrayList<Integer>();
					list.add(candidates[i]);
					result.add(list);
				}
			} else if (candidates[i] < target) {
				index++;
			} else {
				break;
			}
		}
		
		for (int i = 0; i < index; i++) {
			int[] intTemp = array2array(candidates, i);
			
			List<List<Integer>> list = combinationSum2(intTemp, target - candidates[i]);
				
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
	
	private int[] array2array(int[] array, int index) {
		int[] intTemp = new int[array.length - 1];
		for (int i = 0; i < (array.length - 1); i++) {
			if (i < index) {
				intTemp[i] = array[i];
			} else {
				intTemp[i] = array[i+1];
			}
		}
		return intTemp;
	}
	
	private int[] list2array(List<Integer> list) {
		int[] intTemp = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			intTemp[i] = list.get(i);
		}
		return intTemp;
	}
	
	public static void main(String[] args) {
//		int[] candidates = new int[]{2,3,6,7};
//		int target = 8;
//		int[] candidates = new int[]{2,3,6,7};
//		int target = 7;
//		int[] candidates = new int[]{8,7,4,3};
//		int target = 11;
//		int[] candidates = new int[]{7,3,9,6};
//		int target = 6;
//		int[] candidates = new int[]{1,1};
//		int target = 1;
		int[] candidates = new int[]{14,18,19,30,6,5,14,23,28,18,26,21,12,15,29,18,32,23,6,21,19,30,6,28,17,13,29,28,10,34,26,11,10,32,7,11,32,8,21,18,22,5,34,21,7,20,26,5,9,28,21,23,23,15,8,27,23,32,12,20,31,33,27,28,30,21,34,19};
		int target = 29;
		System.out.println("combinationSum2 = " + new Question_40().combinationSum2(candidates, target));
	}
	
}
