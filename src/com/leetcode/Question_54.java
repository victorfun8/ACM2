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
 * 题目：https://leetcode-cn.com/problems/spiral-matrix/description/
 * 
 * 解题思路：
 * 
 * 
 * 参考资料：https://www.cnblogs.com/lightwindy/p/8564387.html
 * 
 */
public class Question_54 {
	class Node {
		int x;
		int y;
	}
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0)
			return result;
		
		int height = matrix[0].length;
		int width = matrix.length;
		
		Node leftTop = new Node(), rightTop = new Node(), rightBottom = new Node(), leftBottom = new Node();
		leftTop.x = 0;
		leftTop.y = 0;
		rightTop.x = 0;
		rightTop.y = height - 1;
		rightBottom.x = width - 1;
		rightBottom.y = height - 1;
		leftBottom.x = width - 1;
		leftBottom.y = 0;
		
		while (result.size() < width * height) {
			
			for (int i = leftTop.y; i <= rightTop.y; i++) {
				result.add(matrix[leftTop.x][i]);
			}
			leftTop.x++;
			rightTop.x++;
		
			if (result.size() < width * height) {
				for (int i = rightTop.x; i <= rightBottom.x; i++) {
					result.add(matrix[i][rightTop.y]);
				}
				rightTop.y--;
				rightBottom.y--;
			}
			if (result.size() < width * height) {
				for (int i = rightBottom.y; i >= leftBottom.y; i--) {
					result.add(matrix[rightBottom.x][i]);
				}
				rightBottom.x--;
				leftBottom.x--;
			}
			if (result.size() < width * height) {
				for (int i = leftBottom.x; i >= leftTop.x; i--) {
					result.add(matrix[i][leftBottom.y]);
				}
				leftBottom.y++;
				leftTop.y++;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{ 1, 2, 3 },
				{ 4, 5, 6 },
				{ 7, 8, 9 }};
//		int[][] matrix = {{1, 2, 3, 4},
//				  {5, 6, 7, 8},
//				  {9,10,11,12}};
		 
		System.out.println("spiralOrder = " + new Question_54().spiralOrder(matrix));
	}
}
