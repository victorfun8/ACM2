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
 * 题目：https://leetcode-cn.com/problems/longest-increasing-subsequence/description/
 * 
 * 解题思路：
 * 
 * 
 * 参考资料：
 * 1.https://blog.csdn.net/OneDeveloper/article/details/80047289
 * 2.https://blog.csdn.net/shuangde800/article/details/7474903
 * 
 * 
 */
public class Question_300 {
	/**
	 * AC解法1
	 * 未经优化，效率较低
	 * O(n2)
	 * @param nums
	 * @return
	 */
//	public int lengthOfLIS(int[] nums) {
//		if (nums.length == 0)
//			return 0;
//		if (nums.length == 1)
//			return 1;
//		
//		int[] maxLenPerIndex = new int[nums.length];
//		int[] maxLenLastValuePerIndex = new int[nums.length];
//		maxLenPerIndex[0] = 1;
//		maxLenLastValuePerIndex[0] = nums[0];
//		Stack<Integer> stack = new Stack<Integer>();
//		for (int i=1; i < nums.length; i++) {
//			if (nums[i] > maxLenLastValuePerIndex[i-1]) {
//				maxLenPerIndex[i] = maxLenPerIndex[i-1] + 1;
//				maxLenLastValuePerIndex[i] = nums[i];
//				continue;
//			}
//			
//			stack.clear();
//			
//			for (int j = 0; j <= i; j++) {
//				while (stack.size() > 0 && stack.peek() >= nums[j]) {
//					stack.pop();
//					if (stack.size() == 0) 
//						break;
//				}
//				stack.push(nums[j]);
//			}
//		
//			int tempMax = stack.size();
//			int tempMaxLastValue = nums[i];
//			
//			for (int j = 0; j < i; j++) {
//				if (tempMax < maxLenPerIndex[j]) {
//					tempMax = maxLenPerIndex[j];
//					tempMaxLastValue = maxLenLastValuePerIndex[j];
//				} else if (tempMax == maxLenPerIndex[j]) {
//					tempMaxLastValue = tempMaxLastValue < maxLenLastValuePerIndex[j] ? tempMaxLastValue : maxLenLastValuePerIndex[j];
//				}
//			}
//			maxLenPerIndex[i] = tempMax;
//			maxLenLastValuePerIndex[i] = tempMaxLastValue;
//		}
//		
//		int max = 0;
//		for (int result : maxLenPerIndex) {
//			max = max > result ? max : result;
//		}
//		
//		return max;
//	}
	
	/**
	 * AC解法2
	 * O(n2)
	 * maxArray集合:集合的size表示最长上升子序列的长度，这个元素是对应的这个index位置(index+1=size)的最大值
	 * @param nums
	 * @return
	 */
//	public int lengthOfLIS(int[] nums) {
//		if (nums.length == 0)
//			return 0;
//		if (nums.length == 1)
//			return 1;
//		
//		List<Integer> maxArray = new ArrayList<Integer>();
//		maxArray.add(nums[0]);
//		
//		for (int i=1; i < nums.length; i++) {
//			boolean isLess = false;
//			for (int j=0; j < maxArray.size(); j++) {
//				if (nums[i] <= maxArray.get(j)) {
//					maxArray.remove(j);
//					maxArray.add(j, nums[i]);
//					isLess = true;
//					break;
//				}
//			}
//			if (!isLess) {
//				maxArray.add(nums[i]);
//			}
//		}
//		
//		return maxArray.size();
//	}
	
	/**
	 * AC解法3
	 * O(n2)
	 * @param nums
	 * @return
	 */
//	public int lengthOfLIS(int[] nums) {
//		if (nums.length == 0)
//			return 0;
//		if (nums.length == 1)
//			return 1;
//		
//		int[] maxArray = new int[nums.length];
//		int len = 0;
//		maxArray[len] = nums[0];
//		
//		for (int i=1; i < nums.length; i++) {
//			boolean isLess = false;
//			for (int j=0; j <= len; j++) {
//				if (nums[i] <= maxArray[j]) {
//					maxArray[j] = nums[i];
//					isLess = true;
//					break;
//				}
//			}
//			if (!isLess) {
//				maxArray[++len] = nums[i];
//			}
//		}
//		
//		return len+1;
//	}
	
	/**
	 * AC解法4
	 * O(nlogn)
	 * 用二分查找优化解法
	 * @param nums
	 * @return
	 */
	public int lengthOfLIS(int[] nums) {
		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return 1;
		
		int[] maxArray = new int[nums.length];
		int len = 1;
		maxArray[0] = nums[0];
		
		for (int i=1; i < nums.length; i++) {
			if (nums[i] > maxArray[len-1]) {
				maxArray[len++] = nums[i];
				continue;
			}
			int start = 0, end = len-1;
			while (start < end) {
				int mid = (start + end) / 2;
				if (maxArray[mid] >= nums[i]) {
					end = mid;
				} else {
					start = mid + 1;
				}
			}
			maxArray[start] = nums[i];
		}
		
		return len;
	}
	
	public static void main(String[] args) {
//		int[] nums = {10,9,2,5,3,7,101,18};
//		int[] nums = {4,10,4,3,8,9};
		int[] nums = {3,5,6,2,5,4,19,5,6,7,12};
//		int[] nums = {1,3,6,7,9,4,10,5,6};
//		int[] nums = {2,2};
//		int[] nums = {10,9,2,5,3,4};
		System.out.println("lengthOfLIS = " + new Question_300().lengthOfLIS(nums));
	}
}
