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
 * 题目：https://leetcode-cn.com/problems/is-subsequence/description/
 * 
 * 解题思路：
 * 
 * 
 * 参考资料：
 * 
 * 
 * 
 */
public class Question_402 {
	/**
	 * 
	public String removeKdigits(String num, int k) {
		if (k >= num.length())
			return "0";
		if (k == 0)
			return num;
		
		int size = k + 1;
		int len = num.length();
		StringBuilder sb = new StringBuilder();
		char small = '9';
		int temp = k;
		int index = 0;
		for (int i=0; i < size; i++) {
			if (i >= len)
				break;
			char c = num.charAt(i);
			if (small - c > 0) {
				small = c;
				temp = k - i;
				index = i;
			}
		}
		String result = removeKdigits(num.substring(index+1), temp);
		char c = num.charAt(index);
		if (c != '0') {
			sb.append(num.charAt(index));	
		}
		sb.append(result);
		return sb.toString();
	}
	**/
	enum InitDataState {
		big,
		normal,
		small
	}
	/**
	 * 这个算法还是有问题的
	 * @param num
	 * @param k
	 * @return
	 */
	public String removeKdigits(String num, int k) {
		int len = num.length();
		if (k >= len)
			return "0";
		if (k == 0)
			return num;
		int t = k;
		
		int resultLen = len - k;
		StringBuilder sb = new StringBuilder();
		int index = 0;
		
		List<Integer> sbIndex = new ArrayList<Integer>();
		InitDataState state = InitDataState.normal;
		
		for (int j=0; j < resultLen; j++) {
			if (k > 0) {
				char smallValue = '9';
				int tempSize = k;
				
				int smallIndex = 0;
				while (tempSize >= 0) {
					char c = num.charAt(index);
					if (smallValue - c > 0) {
						smallValue = c;
						smallIndex = index;
					}
					index++;
					tempSize--;
					
				}
				if (smallIndex > k) {
					state = InitDataState.big;
					k = 0;
				}
				sbIndex.add(smallIndex);
				sb.append(smallValue);
				index = smallIndex + 1;
				k = k - (smallIndex - j);
				if (smallIndex > j) {
					state = InitDataState.small;
				}
					
			} else {
				if (state == InitDataState.normal) {
					sb.append(num.charAt(j+t));					
				} else if (state == InitDataState.small) {
					sb.append(j);
				} else if (state == InitDataState.big) {
					sb.delete(0, sb.length());
					sb.append(j);
				}
				
			}
			
		}
		while (sb.charAt(0) == '0' && sb.length() > 1) {
			sb.deleteCharAt(0);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		String num = "1432219";
		int k = 3;
//		String num = "10200";
//		int k = 1;
//		String num = "112";
//		int k = 1;
//		String num = "1111111";
//		int k = 3;
//		String num = "9999999999991";
//		int k = 8;
//		String num = "10";
//		int k = 2;
//		String num = "10";
//		int k = 1;
//		String num = "5337";
//		int k = 2;
		System.out.println("removeKdigits = " + new Question_402().removeKdigits(num, k));
	}
}
