package com.leetcode;

/**
 * 
 * @author fangji
 * 
 * 题目：https://leetcode-cn.com/problems/container-with-most-water/description/
 * 
 * 解题思路：
 * 	1.暴力循环，但性能差
 * 	2.双指针遍历，提高性能
 * 
 * 参考资料：https://segmentfault.com/a/1190000008824222
 * 	
 */
public class Question_11 {
	public int maxArea(int[] height) {
		if (height.length == 0 || height.length == 1)
			return 0;
		
        int maxArea = 0;
        int left = 0, right = height.length -1;
        
        while (left < right) {
        	maxArea = Math.max(maxArea, (right-left)*Math.min(height[left], height[right]));
        	if (height[left] > height[right]) {
        		right--;
        	} else {
        		left++;
        	}
        }
        
        //时间复杂度为n2的遍历
//        for (int i=0; i < height.length; i++) {
//        	for (int j=height.length-1; j > i; j--) {
//        		int tempArea = (j-i)*Math.min(height[i], height[j]);
//        		if (tempArea > maxArea) {
//        			maxArea = tempArea;
//        		}
//        	}
//        }
        
		return maxArea;
    }
	
	public static void main(String[] args) {
		int[] heights = {1,2,3,4,5,6,7};
		System.out.println("maxArea = " + new Question_11().maxArea(heights));
	}
}
