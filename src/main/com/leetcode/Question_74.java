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
 * 题目：https://leetcode-cn.com/problems/search-a-2d-matrix/description/
 * 
 * 解题思路：二分查找，需要定义一头一尾两个index来帮助定位坐标
 * 
 * 
 * 参考资料：https://blog.csdn.net/xygy8860/article/details/46955827
 * 
 * 
 * 
 */
public class Question_74 {
	
//	public boolean searchMatrix(int[][] matrix, int target) {
//		int lenX = matrix.length;
//		if (lenX == 0)
//			return false;
//		if (lenX == 1 && matrix[0].length == 0)
//			return false;
//		if (lenX == 1 && matrix[0].length == 1)
//			return matrix[0][0] == target;
//		
//		int indexX = lenX / 2;
//		while (true) {
//			if (indexX >= lenX) {
//				indexX = lenX - 1;
//			}
//			if (matrix[indexX][0] > target) {
//				if (indexX - 1 <= 0) {
//					indexX = 0;
//					break;
//				}
//				if (matrix[indexX-1][0] < target) {
//					indexX = indexX - 1;
//					break;
//				} else if (matrix[indexX-1][0] > target) {
//					indexX = indexX / 2;					
//				} else if (matrix[indexX-1][0] == target) {
//					return true;			
//				}
//			} else if (matrix[indexX][0] < target) {
//				if (indexX + 1 >= lenX) {
//					indexX = lenX - 1;
//					break;
//				}
//				if (matrix[indexX+1][0] > target) {
//					
//					break;
//				} else if (matrix[indexX+1][0] < target) {
//					if (indexX == 1) {
//						indexX++;						
//					} else {
//						indexX = indexX + indexX / 2;						
//					}
//				} else if (matrix[indexX+1][0] == target) {
//					return true;
//				}
//			} else if (matrix[indexX][0] == target) {
//				return true;
//			}
//		}
//		
//		int lenY = matrix[indexX].length;
//		int indexY = lenY / 2;
//		while (true) {
//			if (indexY >= lenY) {
//				indexY = lenY - 1;
//			}
//			if (indexY == 0 && matrix[indexX][indexY] > target)
//				return false;
//			if (indexY == lenY - 1 && matrix[indexX][indexY] < target)
//				return false;
//			if (matrix[indexX][indexY] > target && matrix[indexX][indexY-1] < target)
//				return false;
//			if (matrix[indexX][indexY] < target && matrix[indexX][indexY+1] > target)
//				return false;
//			
//			if (matrix[indexX][indexY] > target) {
//				indexY = indexY / 2;
//			} else if (matrix[indexX][indexY] < target) {
//				if (indexY == 1) {
//					indexY++;
//				} else {
//					indexY = indexY + indexY / 2;					
//				}
//			} else if (matrix[indexX][indexY] == target) {
//				return true;
//			}
//		}
//	}
	
	/**
	 * AC解法
	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		int lenX = matrix.length;
		if (lenX == 0)
			return false;
		if (lenX == 1 && matrix[0].length == 0)
			return false;
		if (lenX == 1 && matrix[0].length == 1)
			return matrix[0][0] == target;
		
		int indexXs = 0;
		int indexXe = lenX - 1;
		int mid = 0;
		while (indexXs <= indexXe) {
			mid = (indexXs + indexXe) / 2;
			if (matrix[mid][0] > target) {
				indexXe = mid - 1;
			} else if (matrix[mid][0] < target) {
				indexXs = mid + 1;
			} else if (matrix[mid][0] == target) {
				return true;
			}
		}
		
		if (matrix[mid][0] > target) {
			if (mid == 0)
				return false;
			mid--;
		}
		
		int lenY = matrix[mid].length;
		int indexX = mid;
		int indexYs = 0;
		int indexYe = lenY - 1;
		while (indexYs <= indexYe) {
			mid = (indexYs + indexYe) / 2;

			if (matrix[indexX][mid] > target) {
				indexYe = mid - 1;
			} else if (matrix[indexX][mid] < target) {
				indexYs = mid + 1;
			} else if (matrix[indexX][mid] == target) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
//		int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
//		int target = 3;
//		int[][] matrix = {{}};
//		int target = 1;
//		int[][] matrix = {{1}};
//		int target = 0;
//		int[][] matrix = {{1, 1}};
//		int target = 0;
//		int[][] matrix = {{1, 3, 5}};
//		int target = 5;
//		int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
//		int target = 13;
		int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
		int target = 11;
		System.out.println("searchMatrix = " + new Question_74().searchMatrix(matrix, target));
	}
}
