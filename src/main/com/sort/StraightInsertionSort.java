package com.sort;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.utils.CalcTimeUtil;

/**
 * 
 * @author fangji
 * 
 * 	插入排序：直接插入排序
 */
public class StraightInsertionSort {
	
	public List<Integer> sort(int[] nums) {
		List<Integer> result = new LinkedList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (result.size() == 0) {
				result.add(nums[i]);
			} else {
				boolean insertFlag = false;
				for (int j = 0; j < result.size(); j++) {
					if (result.get(j) > nums[i]) {
						result.add(j, nums[i]);
						insertFlag = true;
						break;
					}
				}
				if (!insertFlag) {
					result.add(nums[i]);
				}
			}
		}
		return result;
    }
	
	public static void main(String[] args) {
		int[] nums = {-1,0,-5,-2,-2,-4,0,1,-2};
		StraightInsertionSort sort = new StraightInsertionSort();
		Method m;
		try {
			m = StraightInsertionSort.class.getMethod("sort", int[].class);
			CalcTimeUtil.calMethodInvokeTime(m, sort, nums);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
