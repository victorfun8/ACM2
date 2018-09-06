package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author fangji
 * 
 * 题目：https://leetcode-cn.com/problems/valid-sudoku/description/
 * 
 * 解题思路：	1. 横向和竖向的判断很简单
 * 			2. 主要解决9宫格的判断
 * 			3. i表示第i个9宫格，j表示第j个元素
 * 			4. 第i个9宫格，第j个元素的x和y元素的值列表出来
 * 			5. 寻找规律
 * 参考资料：	https://blog.csdn.net/mine_song/article/details/70207326
 * 	
 */
public class Question_36 {
	
	public boolean isValidSudoku(char[][] board) {
		List<Character> shuList = new ArrayList<Character>();
		List<Character> hengList = new ArrayList<Character>();
		List<Character> geziList = new ArrayList<Character>();
		
		for (int i=0; i < 9; i++) {
			shuList.clear();
			hengList.clear();
			geziList.clear();
			for (int j=0; j < 9; j++) {
				if(board[i][j] != '.' && hengList.contains(board[i][j])) {
					return false;
				} else {
					hengList.add(board[i][j]);
				}
				
				if(board[j][i] != '.' && shuList.contains(board[j][i])) {
					return false;
				} else {
					shuList.add(board[j][i]);
				}
				
				int indexX = i/3*3 + j/3;
				int indexY = i%3*3 + j%3;
				if(board[indexX][indexY] != '.' && geziList.contains(board[indexX][indexY])) {
					return false;
				} else {
					geziList.add(board[indexX][indexY]);
				}
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		char[][] board = new char[][]{
			{'5','3','.','.','7','.','.','.','.'},
			{'6','.','.','1','9','5','.','.','.'},
			{'.','9','8','.','.','.','.','6','.'},
			{'8','.','.','.','6','.','.','.','3'},
			{'4','.','.','8','.','3','.','.','1'},
			{'7','.','.','.','2','.','.','.','6'},
			{'.','6','.','.','.','.','2','8','.'},
			{'.','.','.','4','1','9','.','.','5'},
			{'.','.','.','.','8','.','.','7','9'}
		};
		System.out.println("isValidSudoku = " + new Question_36().isValidSudoku(board));
	}
	
}
