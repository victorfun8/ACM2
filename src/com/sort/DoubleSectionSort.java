package com.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author fangji
 * 
 * 选择排序：二元选择排序
 * 	
 */
public class DoubleSectionSort<E> {
	
	public int[] sort(int[] nums) {
		int length = nums.length;
		for (int i = 0; i <= length / 2 ; i++) {
			int min_index = i;
			int max_index = i;
			
			for (int j = i+1; j < nums.length - i; j++) {
				if (nums[min_index] > nums[j]) {
					min_index = j;
					continue;
				}
				if (nums[max_index] < nums[j]) {
					max_index = j;
				}
			}
			
			int left = nums[i];
			int right = nums[nums.length - 1 - i];
			
			boolean isIequalMax = false;
			boolean isJequalMin = false;
			if (max_index == i) {
				isIequalMax = true;
			}
			if (min_index == length - 1 - i) {
				isJequalMin = true;
			}
			
			if (isJequalMin) {
				nums[length - 1 -i] = nums[max_index];	
				nums[i] = right;
				nums[max_index] = left;
			} else if (isIequalMax) {
				nums[i] = nums[min_index];
				nums[min_index] = right;
				nums[length - 1 -i] = left;
			} else {
				nums[i] = nums[min_index];
				nums[min_index] = left;
				nums[nums.length - 1 - i] = nums[max_index];
				nums[max_index] = right;
			}
			
		}
		return nums;
    }
	
	static class Node implements Cloneable {
		String a;
		String b;
		@Override
		public String toString() {
			return "Node [a=" + a + ", b=" + b + "]";
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {-1,0,-5,-2,-2,-4,0,1,-2};
		int[] temp = new DoubleSectionSort().sort(nums);
		for (int i : temp) {
			System.out.println("sort = " + i);
		}
	}
}
