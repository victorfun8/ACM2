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
 * 题目：https://leetcode-cn.com/problems/jump-game/description/
 * 
 * 解题思路：
 * 
 * 
 * 参考资料：http://www.cnblogs.com/wmx24/p/9032719.html
 * 
 */
public class Question_55 {
	/**
	 * 优化后的解，仍然超出时间限制
	public boolean canJump(int[] nums) {
		return canJump(nums, 0);
	}
	
	public boolean canJump(int[] nums, int index) {
		long before = System.currentTimeMillis();
		System.out.println("" + before);
		if (nums[index] >= nums.length - 1 - index)
			return true;
		if (nums[index] == 0)
			return false;
		
		int value = nums[index];
		for (int i = index + value; i >= index + 1; i--) {
			if (canJump(nums, i))
				return true;
		}
		long now = System.currentTimeMillis();
		System.out.println("" + now);
		System.out.println("" +(now - before));
		return false;
	}
	**/
	
	/**
	 * AC解法
	 * @param nums
	 * @return
	 */
	public boolean canJump(int[] nums) {
		if (nums.length == 1)
			return true;
        
		int len = nums.length;
		int far = -1;
		for (int i=0; i < len; i++) {
			if (nums[i] > far)
				far = nums[i];
			if (nums[i] >= len - i - 1)
				return true;
			if (nums[i] == 0 && far == 0)
				return false;
			far--;
		}
		return false;
	}
	
	public static void main(String[] args) {
//		int[] nums = {2,3,1,1,4};
//		int[] nums = {3,2,2,0,4};
		int[] nums = {2,0};
		System.out.println("canJump = " + new Question_55().canJump(nums));
	}
}
