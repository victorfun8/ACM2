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
 * 题目：https://leetcode-cn.com/problems/is-subsequence/description/
 * 
 * 解题思路：
 * 
 * 
 * 参考资料：
 * 
 * 
 * 
 */
public class Question_392 {
	
	public boolean isSubsequence(String s, String t) {
		int len = s.length();
		int tLen = t.length();
		if (len == 0)
			return true;
		if (tLen == 0)
			return false;
		
		int index = 0;
		for (int i=0; i < len; i++) {
			char c = s.charAt(i);
			while (true) {
				if (index == tLen)
					return false;
				if (t.charAt(index++) == c)
					break;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
//		String s = "axc";
//		String t = "ahbgdc";
//		String s = "abc";
//		String t = "ahbgdc";
		String s = "acb";
		String t = "ahbgdc";
		System.out.println("isSubsequence = " + new Question_392().isSubsequence(s, t));
	}
}
