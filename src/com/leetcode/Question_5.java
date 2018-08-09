package com.leetcode;

/**
 * 
 * @author fangji
 * 
 * https://leetcode-cn.com/problems/longest-palindromic-substring/description/
 * 题目：给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 * 示例1：输入: "babad"，输出: "bab"，注意: "aba"也是一个有效答案。
 * 示例2：输入: "cbbd"，输出: "bb"
 * 
 * 注：什么是回文？可以返回来的字符串，如“人人爱我”和“我爱人人”
 */
public class Question_5 {
	//实现方式1：未理解回文的意思
//	public String longestPalindrome(String s) {
//        String longestString = "";
//        StringBuilder sb = new StringBuilder();
//        
//        for (int i = 0; i < s.length(); i++) {
//        	String temp = s.substring(i, i+1);
//        	if (sb.toString().contains(temp) && longestString.length() >= sb.length()) {
//        		sb.append(temp);
//        		sb.delete(0, sb.indexOf(temp)+1);
//        	} else if (sb.toString().contains(temp) && longestString.length() < sb.length()) {
//        		sb.append(temp);
//        		longestString = sb.substring(sb.indexOf(temp));
//        		sb.delete(0, sb.indexOf(temp)+1);
//        	} else {
//        		sb.append(temp);
//        	}
//        }
//		return longestString.length() >= sb.length() ? longestString : sb.toString();
//    }
	
//	//实现方式2：未理解回文的意思
//	public String longestPalindrome(String s) {
//		if (s.length() == 1)
//            return s;
//		
//        String longestString = "";
//        
//        for (int i = 0; i < s.length(); i++) {
//        	String tempI = s.substring(i, i+1);
//        	for (int j = s.length() - 1; j > i; j--) {
//        		String tempJ = s.substring(j, j+1);
//        		if (tempI.equals(tempJ)) {
//        			String tempString = s.substring(s.indexOf(tempI), s.lastIndexOf(tempJ) + 1);
//        			if (longestString.length() < tempString.length()) {
//        				longestString = tempString;
//        			}
//        			break;
//        		}
//        	}
//        }
//		return longestString;
//    }
	
	//动态规划的思路解题
	public String longestPalindrome(String s) {
		if (s.length() == 1)
          return s;
			
		int len = s.length();
		int start = 0;
		int maxlength = 0;
		boolean p[][] = new boolean[s.length()][s.length()];
		// 子串长度为1和为2的初始化
		for (int i = 0; i < len; i++) {
			p[i][i] = true;
			if (i < len - 1 && s.charAt(i) == s.charAt(i + 1)) {
				p[i][i + 1] = true;
				start = i;
				maxlength = 2;
			}
		}
		// 使用上述结果可以dp出子串长度为3~len -1的子串
		for (int strlen = 3; strlen <= len; strlen++) {
			for (int i = 0; i <= len - strlen; i++) {
				int j = i + strlen - 1; // 子串结束的位置
				if (p[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
					p[i][j] = true;
					maxlength = strlen;
					start = i;
				}
			}
		}
		if (maxlength > 0)
			return s.substring(start, start + maxlength);
		else
			return s.substring(0,1);
	}
	
	public static void main(String[] args) {
		String test = "abcda";
		System.out.println("longestPalindrome = " + new Question_5().longestPalindrome(test));
	}
}
