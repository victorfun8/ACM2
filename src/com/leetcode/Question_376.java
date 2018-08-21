package com.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * @author fangji
 * 
 * 题目：https://leetcode-cn.com/problems/wiggle-subsequence/description/
 * 
 * 解题思路：
 * 
 * 
 * 参考资料：
 * 
 * 
 * 
 */
public class Question_376 {
	
	 public int wiggleMaxLength(int[] nums) {
		 int len = nums.length;
		 if (len < 2)
			return len;
		 if (len == 2 && nums[0] == nums[1])
			 return 1;
		 
		int result = 1;
		boolean bigger = false;
		boolean flag = false;
		
		for (int i = 0; i < len - 1; i++) {
			if (!flag) {
				if (nums[i] == nums[i+1]) {
								
				} else {
					flag = true;
					if (nums[i] > nums[i+1]) {
						bigger = true;			
					} else {
						bigger = false;
					}
					result ++;
				}
			} else {
				if ((bigger && nums[i] < nums[i+1]) || (!bigger && nums[i] > nums[i+1])) {
					result++;
					bigger = !bigger;
				}
			}
		}
		
        return result;
	}
	
	public static void main(String[] args) {
//		int[] nums = {1,7,4,9,2,5};
//		int[] nums = {3,3,3,2,5};
//		int[] nums = {1,17,5,10,13,15,10,5,16,8};
		int[] nums = {1,2,3,4,5,6,7,8,9};
		System.out.println("wiggleMaxLength = " + new Question_376().wiggleMaxLength(nums));
	}
}
