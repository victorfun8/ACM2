package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author fangji
 * 
 * 题目：https://leetcode-cn.com/problems/3sum/description/
 * 
 * 解题思路：
 * 
 * 参考资料：
 * 	
 */
public class Question_15 {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>>	result = new LinkedList<List<Integer>>();

		if (nums.length < 3) {
			return result; 
		}
		
		Arrays.sort(nums);
		for (int index = 0; index < nums.length - 1; index++) {
			if (index != 0 && nums[index - 1] == nums[index]) 
				continue;
			int left = index + 1, right = nums.length - 1;
			while (left < right) {
				int temp = 0 - nums[index];
				int tempLPlusR = nums[left] + nums[right];
				if (temp == tempLPlusR) {
					List<Integer> list = new LinkedList<Integer>();
					list.add(nums[left]);
					list.add(nums[index]);
					list.add(nums[right]);
//					if (!result.contains(list)) {
						result.add(list);					
//					}
					while (left < right && nums[left] == nums[left+1]) {
						left++;
					}
					while (left < right && nums[right] == nums[right-1]) {
						right--;
					}
					left++;
					right--;
				} else if (temp > tempLPlusR) {
					left++;
				} else {
					right--;
				}
			}
			
			while(index<nums.length -1 && nums[index] == nums[index+1]){
                index++;
			}
		}
		
        return result;
    }
//	public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> res = new ArrayList();
//        Arrays.sort(nums);
//        for(int k=0;k<nums.length;k++){
//            int i = k+1,j = nums.length - 1;//***
//            while(i < j){              
//                int value = nums[i] + nums[j];
//                if(value == (-nums[k])){
//                    List<Integer> list = new ArrayList();
//                    list.add(nums[k]);
//                    list.add(nums[i]);
//                    list.add(nums[j]);
//                    res.add(list);
//                    //重值处理
//                    //****一定要有i < j条件，否则i会到最后
//                    while(i<j && nums[i] == nums[i+1]){
//                        i++;
//                    }
//                    //****一定要有i < j条件，否则j会取-1
//                    while(i<j && nums[j] == nums[j-1]){
//                        j--;
//                    }
//                    //***
//                    i++;
//                    j--;
//                }
//                else if(value < (-nums[k]))
//                    i++;
//                else
//                    j--;
//            }
//            //****重值处理
//            while(k < nums.length-1 && nums[k] == nums[k+1]){
//                k++;
//            }
//        }
//        return res;
//    }

	public static void main(String[] args) {
//		int[] nums = {-1,2,-3,-3 ,0,6,4,-5,6};
//		int[] nums = {0, 0};
//		int[] nums = {-1,0,1,0};
//		int[] nums = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
		int[] nums = {-2,0,1,1,2};
//		int[] nums = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		System.out.println("threeSum = " + new Question_15().threeSum(nums));
	}
}
