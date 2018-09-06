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
 * 题目：https://leetcode-cn.com/problems/gas-station/description/
 * 
 * 解题思路：
 * 
 * 
 * 参考资料：
 * 
 * 
 * 
 */
public class Question_134 {
	
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int lenGas = gas.length;
		int currentGas = 0;
		int result = -1;
		
		for (int i = 0; i < lenGas; i++) {
			int index = i;
			boolean flag = true;
			currentGas = gas[i];
			do {
				int nextStationIndex = (index + 1) % lenGas;
				currentGas = currentGas + gas[nextStationIndex] - cost[index];
				if (currentGas < cost[nextStationIndex]) {
					flag = false;
				}
				if (nextStationIndex == i) {
					break;
				}
				index = nextStationIndex;
			} while (true);
			
			if (flag) {
				result = i;
			}
		}
		
        return result;
	}
	
	public static void main(String[] args) {
		int[] gas = {1,2,3,4,5};
		int[] cost = {3,4,5,1,2};
//		int[] gas = {2,3,4};
//		int[] cost = {3,4,3};
//		int[] gas = {5,1,2,3,4};
//		int[] cost = {4,4,1,5,1};
		System.out.println("canCompleteCircuit = " + new Question_134().canCompleteCircuit(gas, cost));
	}
}
