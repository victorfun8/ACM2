package com.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author fangji
 * 
 * 题目：https://leetcode-cn.com/problems/multiply-strings/description/
 * 
 * 解题思路：int数组的解题思路
 * 
 * 参考资料：	
 * 	
 */
public class Question_43 {
	public String multiply(String num1, String num2) {
		char[] num1Chars = num1.toCharArray();
		char[] num2Chars = num2.toCharArray();
		int size1 = num1Chars.length;
		int size2 = num2Chars.length;
		int[] nums1 = new int[num1Chars.length];
		int[] nums2 = new int[num2Chars.length];
		int[] result = new int[num1Chars.length + num2Chars.length]; //2个数相乘，结果的位数不会超过2个数位数相加
		
		for (int i = 0; i < nums1.length; i++) {
			nums1[i] = num1Chars[i] - '0';
		}
		
		for (int i = 0; i < nums2.length; i++) {
			nums2[i] = num2Chars[i] - '0';
		}
		
		int add = 0;
		for (int i = nums1.length; i > 0; i--) {
			
			for (int j = nums2.length; j > 0; j--) {
				int temp = nums1[i-1] * nums2[j-1] + add + result[i+j-1];
				result[i+j-1] = temp % 10;
				add = temp / 10;
				if (j - 1 == 0) {
					result[i+j-2] += add;
					add = 0;
				}
			}
		}
		
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < result.length; i++) {
			if (sb.length() == 0 && result[i] == 0)
				continue;
			sb.append(result[i]);
		}
		if (sb.toString().equals("")) {
			return "0";
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
//		String num1 = "123";
//		String num2 = "456";
//		String num1 = "2";
//		String num2 = "3";
		String num1 = "0";
		String num2 = "0";
		System.out.println("multiply = " + new Question_43().multiply(num1, num2));
	}
	
}
