package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author fangji
 * 
 *         题目：https://leetcode-cn.com/problems/substring-with-concatenation-of-
 *         all-words/description/
 * 
 *         解题思路：
 * 
 *         参考资料：
 * 
 */
public class Question_30_3 {

	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> indexes = new LinkedList<Integer>();
		if (words.length == 0)
			return indexes;

		Map<String, Integer> counts = new HashMap<String, Integer>();
		for (String word : words) {
			counts.put(word, counts.getOrDefault(word, 0) + 1);
		}

		int n = s.length(), num = words.length, len = words[0].length();
		for (int i = 0; i < n - num * len + 1; i++) { // i是迭代字符串的起始位置，当i>=n-num*len+1的时候
														// 所剩字符已小于要求的字符串 长度，结束
			Map<String, Integer> seen = new HashMap<String, Integer>();
			int j = 0;
			while (j < num) { // 该循环迭代寻找字符串，i为起始索引
				String word = s.substring(i + j * len, i + (j + 1) * len); // 每次找的是从i开始，长度为len的一个字符串
				if (counts.containsKey(word)) {
					seen.put(word, seen.getOrDefault(word, 0) + 1); // 将迭代到的字符串及个数放入Map中，与要求的Map进行对比
					if (seen.get(word) > counts.get(word))
						break;
				} else {
					break;
				}
				j++;
			}
			if (j == num) {
				indexes.add(i);
			}
		}

		return indexes;
	}

	public static void main(String[] args) {
		// String s = "aaaaaaaa";
		// String[] words = {"aa","aa","aa"};
		// String s = "barfoothefoobarman";
		// String[] words = {"foo","bar"};
		String s = "wordstudentgoodword";
		String[] words = { "word", "student" };
		System.out.println("findSubstring = " + new Question_30_3().findSubstring(s, words));
	}

}
