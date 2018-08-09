package com.leetcode;

/**
 * 
 * @author fangji
 * 
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/description/
 * 题目：给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
 * 期望结果：nums1 = [1, 3], nums2 = [2]; 中位数是 2.0
 * 期望结果：nums1 = [1, 2], nums2 = [3, 4]; 中位数是 (2 + 3)/2 = 2.5
 * 
 * 解题思路：
 * 	1. 合并数组：需考虑数组为空，数组里的数值都相等，数组越界，边界问题
 *  2. 计算结果：需要考虑入参为int时，什么时候转成double类型
 */
public class Question_4 {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1.length == 0 && nums2.length != 0) {
			return calculateValue(nums2);
		} else if (nums1.length != 0 && nums2.length == 0) {
			return calculateValue(nums1);
		} else if (nums1.length == 0 && nums2.length == 0) {
			return 0.0;
		}
		int[] totalIntArr = containsIntArray(nums1, nums2);
        return calculateValue(totalIntArr);
    }
	
	private int[] containsIntArray(int[] nums1, int[] nums2) {
		int[] totlaValue = new int[nums1.length + nums2.length];
		int indexNum2 = 0;
		int indexTotal = 0;
		for (int i = 0; i < nums1.length; i++) {
			while(indexNum2 < nums2.length && nums1[i] >= nums2[indexNum2]) {
				totlaValue[indexTotal] = nums2[indexNum2];
				indexTotal++;
				indexNum2++;
			}
			totlaValue[indexTotal] = nums1[i];
			indexTotal++;
		}
		while (indexTotal < totlaValue.length) {
			totlaValue[indexTotal] = nums2[indexNum2];
			indexTotal++;
			indexNum2++;
		}
		return totlaValue;
	}
	
	private double calculateValue(int[] nums) {
		int value = nums.length % 2;
		int index = nums.length / 2;
		if (value == 1) {
			return (double)nums[index];
		} else {
			return (double)(nums[index - 1] + nums[index]) / 2;
		}
	}
	
	public static void main(String[] args) {
		int[] nums1 = {1, 2};
		int[] nums2 = {3, 4};
		System.out.println("longest substring length = " + new Question_4().findMedianSortedArrays(nums1, nums2));
	}
}
