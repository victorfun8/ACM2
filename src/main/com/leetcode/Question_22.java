package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author fangji
 * 
 * 题目：https://leetcode-cn.com/problems/generate-parentheses/description/
 * 
 * 解题思路：
 * 	1.回溯算法
 *  2.考虑重复的问题，可以用HashSet的特性
 * 
 * 参考资料：
 * 	
 */
public class Question_22 {
	
	 public List<String> generateParenthesis(int n) {
		 if (n <= 0) {
			 return null;
		 }
		 HashSet<String> hs = (HashSet)get(n);
		 List<String> result = new LinkedList<String>();
		 for (String s : hs) {
			 result.add(s);
		 }
		 return result;
	 }
	 
	 private Set<String> get(int n) {
		 Set<String> result = new HashSet<String>();
		 if (n > 1) {
			 Set<String> temp = get(n - 1);
			 for (String s : temp) {
				 int length = s.length();
				 for (int i = 0; i < length; i++) {
					 result.add(s.substring(0, i) + "()" + s.substring(i));
				 }
			 }
		 } else {
			 result.add("()");
		 }
		 return result;
	 }
	
	public static void main(String[] args) {
		int n = 4;
		System.out.println("generateParenthesis = " + new Question_22().generateParenthesis(n));
	}
}
