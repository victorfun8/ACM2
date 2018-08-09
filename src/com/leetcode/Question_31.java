package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author fangji
 * 
 * 题目：https://leetcode-cn.com/problems/next-permutation/description/
 * 
 * 是否通过：否 (题目意思不明确)
 * 解题思路：
 * 
 * 参考资料：
 * 	
 */
public class Question_31 {
	
	public void nextPermutation(int[] nums) {
		int length = nums.length;
		int swap = nums[length - 1], swapIndex = length - 1;
		int swapRight = nums[length - 1], swapRightIndex = length - 1;
		boolean isSwap = false;
		
		for (int i = length-1; i >= 0; i--) {
			if (!isSwap && nums[i] < swap) {
				swapIndex = i;
				swap = nums[i];
				if (i < length - 1) {
					swapRight = nums[i+1];
					swapRightIndex = i + 1;
					for (int j = i+1; j < length; j++) {
						if (nums[j] > swap && nums[j] < swapRight) {
							swapRight = nums[j];
							swapRightIndex = j;
						}
					}			
				}
				isSwap = true;
				break;
			}
		}
		if (isSwap) {
			nums[swapIndex] = swapRight;
			nums[swapRightIndex] = swap;			
		} else {
			int half = length/2;
			for (int i = length - 1; i >= half; i--) {
				int temp = nums[i];
				nums[i] = nums[length - i - 1];
				nums[length - i - 1] = temp;
			}
		}
		System.out.print("[");
		for (int i = 0; i < length; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.print("]");
    }
	
	
	
	public static void main(String[] args) {
//		int[] words = {1, 2, 3};
//		int[] words = {3,2,1};
		int[] words = {1, 3, 3};
//		int[] words = {1, 1, 5};
		new Question_31().nextPermutation(words);
	}
	
}
