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
 * 题目：https://leetcode-cn.com/problems/russian-doll-envelopes/description/
 * 
 * 解题思路：
 * 
 * 
 * 参考资料：
 * 
 * 
 * 
 */
public class Question_354 {
	public int maxEnvelopes(int[][] envelopes) {
		int len = envelopes.length;
		if (len == 0)
			return 0;
		if (len == 1)
			return 1;
		for (int i = 0; i < len; i++) {
			for (int j = i+1; j < len; j++) {
				if (envelopes[i][0] > envelopes[j][0] || (envelopes[i][0] == envelopes[j][0] && envelopes[i][1] > envelopes[j][1])) {
					int[] temp = envelopes[i];
					envelopes[i] = envelopes[j];
					envelopes[j] = temp;
				}
			}
		}
		int result = 1;
		int index = 0;
		int next = 1;
		while (index < len && next < len) {
			if (envelopes[index][0] < envelopes[next][0] && envelopes[index][1] < envelopes[next][1]) {
				result++;
				index += (next - index);
				next = index + 1;
			} else {
				next++;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
//		int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
//		int[][] envelopes = {{1,1}};
//		int[][] envelopes = {{4,5},{4,6},{6,7},{2,3},{1,1}};
//		int[][] envelopes = {{4,5},{4,6},{6,7},{2,3},{1,1},{1,1}};
		int[][] envelopes = {{2,100},{3,200},{4,300},{5,500},{5,400},{5,250},{6,370},{6,360},{7,380}};
//		int[][] envelopes = {{30,50},{12,2},{3,4},{12,15}};
		System.out.println("maxEnvelopes = " + new Question_354().maxEnvelopes(envelopes));
	}
}
