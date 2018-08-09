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
 * 题目：https://leetcode-cn.com/problems/group-anagrams/description/
 * 
 * 解题思路：
 * 
 * 参考资料：	
 * 	
 */
public class Question_49 {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<List<String>>();
		if (strs.length == 0)
			return result;
		
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String s : strs) {
			char[] ca = s.toCharArray();
			Arrays.sort(ca);
			String key = charArray2String(ca);
			if (map.keySet().contains(key)) {
				((List<String>) map.get(key)).add(s);
			} else {
				List<String> list = new ArrayList<String>();
				list.add(s);
				map.put(key, list);
			}
		}
		
		for (List<String> list : map.values()) {
			result.add(list);
		}
		return result;
	}
	
	private String charArray2String(char[] charArray) {
		if (charArray == null || charArray.length == 0)
			return "";
		StringBuilder sb = new StringBuilder();
		for (char c : charArray) {
			sb.append(c);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String[] nums = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println("groupAnagrams = " + new Question_49().groupAnagrams(nums));
	}
}
