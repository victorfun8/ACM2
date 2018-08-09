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
 * 题目：https://leetcode-cn.com/problems/search-in-rotated-sorted-array/description/
 * 
 * 解题思路：
 * 
 * 参考资料：
 * 	
 */
public class Question_33 {
	
	public int search(int[] nums, int target) {
		int len = nums.length;
		int index = 0;
		for (int i=0; i < len ; i++) {
			if (nums[i] == target) {
				index = i;
			}
		}
		return index;
	}
	
	public static void main(String[] args) {
//		String s = "(()";
//		String s = ")()())";
//		String s= "()(()";
//		String s = "(()()";
//		String s = "()(())";
//		String s = "()((()))";
//		String s = "((()))())";
//		String s = ")()())()()(";
		int[] nums = {1, 2, 3, 4, 5, 6};
		int target = 0;
		System.out.println("search = " + new Question_33().search(nums, target));
	}
	
}
