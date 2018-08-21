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
 * 题目：https://leetcode-cn.com/problems/queue-reconstruction-by-height/description/
 * 
 * 解题思路：
 * 
 * 
 * 参考资料：
 * 
 * 
 * 
 */
public class Question_406 {
	
	/**
	 * 未通过算法
	 * @param people
	 * @return
	 */
	public int[][] reconstructQueue(int[][] people) {
		int len = people.length;
		int[] newPeo = new int[len];
		List<int[]> arr = new ArrayList<int[]>();
		List<int[]> waitList = new ArrayList<int[]>();
		for (int i=0; i < len; i++) {
			int index = 0;
			for (int j=0; j < arr.size(); j++) {
				int[] temp = arr.get(j);
				if (temp[1] > people[j][1]) {
					index++;
				}
			}
			arr.add(index, people[i]);
		}
		return null;
	}
	
	public static void main(String[] args) {
		int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
		System.out.println("reconstructQueue = " + new Question_406().reconstructQueue(people));
	}
}
