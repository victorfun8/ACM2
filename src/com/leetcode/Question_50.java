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
 * 题目：https://leetcode-cn.com/problems/powx-n/description/
 * 
 * 解题思路：
 * 	1. 不考虑效率，循环计算，算法的时间复杂度是O(n)；
 * 	2. 考虑到n个x相乘式子的对称关系，可以在1基础上进行改进，从而得到一种时间复杂度为O(logn)的算法
 * 
 * 参考资料：https://blog.csdn.net/xy010902100449/article/details/49496285
 * 
 */
public class Question_50 {
	public double myPow(double x, int n) {
		if (n == 0) {
			return 1.0;
		} else if (n > 0) {
			if (n % 2 == 0) {
				double tempResult = myPow(x, n / 2);
				double result = tempResult * tempResult;
				return result;
			} else {
				double tempResult = myPow(x, n / 2);
				double result = tempResult * tempResult * x;
				return result;
			}
		} else {
			boolean flag = false;
			if (n == Integer.MIN_VALUE) {
				n = Integer.MAX_VALUE;
				if (x < 0) {
					flag = true;
				}
			} else {
				n = -n;				
			}
			if (n % 2 == 0) {
				double tempResult = myPow(x, n / 2);
				double result = (1 / tempResult) * (1 / tempResult);
				if (flag) {
					result = -result;
				}
				return result;
			} else {
				double tempResult = myPow(x, n / 2);
				double result = (1 / tempResult) * (1 / tempResult) / x;
				if (flag) {
					result = -result;
				}
				return result;
			}
		}
	}
	
	public static void main(String[] args) {
//		double x = 0.0;
//		int n = 0;
//		double x = 2.10000;
//		int n = 3;
//		double x = 2.0000;
//		int n = -2;
//		double x = 2.0000;
//		int n = -2147483648;
		double x = -1.0000;
		int n = -2147483648;
		System.out.println("myPow = " + new Question_50().myPow(x, n));
	}
}
