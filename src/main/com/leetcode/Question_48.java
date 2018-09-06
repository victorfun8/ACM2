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
 * 题目：https://leetcode-cn.com/problems/rotate-image/description/
 * 
 * 解题思路：
 * 
 * 参考资料：	
 * 	
 */
public class Question_48 {
	public void rotate(int[][] matrix) {
		int len = matrix.length;
		for (int i = 0; i < len; i++) {
			int len1 = matrix[i].length;
			for (int j = 0; j < len1; j++) {
				if (i == j)
					continue;
				if (i > j) {
					int temp = matrix[i][j];
					matrix[i][j] = matrix[j][i];
					matrix[j][i] = temp;
				}
			}
		}
		
		for (int i = 0; i < len; i++) {
			int len1 = matrix[i].length;
			for (int j = 0; j < len1; j++) {
				if (j < len / 2) {
					int temp = matrix[i][j];
					matrix[i][j] = matrix[i][len-j-1];
					matrix[i][len-j-1] = temp;
				}
			}
		}
		
		printMatrix(matrix);
		System.out.println(matrix);
	}
	
	private void printMatrix(int[][] matrix) {
		int len = matrix.length;
		for (int i = 0; i < len; i++) {
			int len1 = matrix[i].length;
			for (int j = 0; j < len1; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
//		int[][] nums = { 
//				{1,2,3},
//				{4,5,6},
//				{7,8,9}
//				};
		int[][] nums = { 
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
				};
		new Question_48().rotate(nums);
	}
}
