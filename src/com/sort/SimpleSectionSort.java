package com.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author fangji
 * 
 * 选择排序：简单选择排序
 * 	
 */
public class SimpleSectionSort {
	
	public List<Integer> sort(int[] nums) {
		List<Integer> result = new LinkedList<Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			int min_index = i;
			int min = nums[i];
			
			for (int j = i; j < nums.length; j++) {
				if (min > nums[j]) {
					min_index = j;
					min = nums[j];
				}
			}
			
			nums[min_index] = nums[i];
			nums[i] = min;
			result.add(min);
		}
		return result;
    }
	
	public static void main(String[] args) {
		int[] nums = {-1,0,-5,-2,-2,-4,0,1,-2};
		System.out.println("sort = " + new SimpleSectionSort().sort(nums));
	}
}
