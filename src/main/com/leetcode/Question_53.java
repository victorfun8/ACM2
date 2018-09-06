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
 * 题目：https://leetcode-cn.com/problems/maximum-subarray/description/
 * 
 * 解题思路：
 * 
 * 
 * 参考资料：
 * 
 * 
 * 
 */
public class Question_53 {
	public int maxSubArray(int[] nums) {
		int len = nums.length;
		if (len == 1) 
			return nums[0];
		
		int[] maxArr = new int[len];
		int size = 1;
		maxArr[0] = nums[0];
		
		for (int i=0; i < len; i++) {
			
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		int[] nums = {2,100,7,380};
		System.out.println("maxSubArray = " + new Question_53().maxSubArray(nums));
	}
}
