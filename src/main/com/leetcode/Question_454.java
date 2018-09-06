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
 * 题目：https://leetcode-cn.com/problems/4sum-ii/description/
 * 
 * 解题思路：
 * 
 * 
 * 参考资料：https://blog.csdn.net/zibingling777/article/details/78805889
 * 
 * 
 * 
 */
public class Question_454 {
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		int lenA = A.length;
		int lenB = B.length;
		int lenC = C.length;
		int lenD = D.length;
		int result = 0;
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i=0; i < lenA; i++) {
			for (int j=0; j < lenB; j++) {
				int value = A[i] + B[j];
				map.put(value, map.getOrDefault(value, 0)+1);
			}
		}
		
		for (int n=0; n < lenC; n++) {
			for (int m=0; m < lenD; m++) {
				int value = map.getOrDefault(0 - C[n] - D[m], 0);
				result += value;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] A = {1, 2};
		int[] B = {-2, -1};
		int[] C = {-1, 2};
		int[] D = {0, 2};
		System.out.println("fourSumCount = " + new Question_454().fourSumCount(A, B, C, D));
	}
}
