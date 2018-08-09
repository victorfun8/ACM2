package com.leetcode;

/**
 * 
 * @author fangji
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/
 * 题目：给定一个字符串，找出不含有重复字符的最长子串的长度。
 * 期望结果：给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
 * 期望结果：给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
 * 期望结果：给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。
 * 
 * 解题思路：
 * 	1. 申明2个对象，一个存最近的子字符串，一个存历史最长的子字符串
 *  2. 注意遇到重复时，只需要剔除重复的，未重复的字串还得保留
 * 
 */
public class Question_3 {
	public int lengthOfLongestSubstring(String s) {
		String tempLongestSubString = "";
		StringBuilder sb = new StringBuilder();
		int len = s.length();
		
		for(int i = 0; i < len; i++) {
			String c = s.substring(i, i+1);
			if (sb.toString().contains(c)) {
				if (sb.toString().length() >= tempLongestSubString.length()) {
					tempLongestSubString = sb.toString();
				}
				int index = sb.indexOf(c);
				sb.delete(0, index + 1);
				sb.append(c);
			} else {
				sb.append(c);
			}
		}
		
		System.out.println("tempLongestSubString = " + tempLongestSubString + ", sb = " + sb.toString());
		return Math.max(tempLongestSubString.length(), sb.toString().length());
    }
	
	public static void main(String[] args) {
		String test = "dvdf";
		System.out.println("longest substring length = " + new Question_3().lengthOfLongestSubstring(test));
	}
}
