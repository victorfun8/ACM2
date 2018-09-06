package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author fangji
 * 
 * 题目：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/description/
 * 
 * 解题思路：
 * 
 * 参考资料：
 * 	
 */
public class Question_30 {
	
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new LinkedList<Integer>();
        List<String> wordList = Arrays.asList(words);
        for (String word : wordList) {
        	if (s.contains(word)) {
        		String temp = s;
        		int index = temp.indexOf(word);
        		if (result.contains(index))
        			continue;
        		
        		temp = temp.substring(index + word.length());
        		
        		List<String> tempWords = new LinkedList<String>();
        		tempWords.addAll(wordList);
        		tempWords.remove(word);
        		if (isHasStartedString(temp, tempWords)) {
        			result.add(index);
        		}
        		
        		temp = s;
        		temp = temp.substring(index + 1);
        		List<Integer> tempList = findSubstring(temp, words);
        		if (tempList != null && tempList.size() > 0) {
        			for (int tempIndex : tempList) {
        				int t = tempIndex + index + 1;
        				if (!result.contains(t))
        					result.add(t);
        			}
        		}
        	}
        }
		return result;
    }
	
	private boolean isHasStartedString(String s, List<String> words) {
		if (words == null || words.size() == 0)
			return true;
		Iterator<String> it = words.iterator();
		
		while (it.hasNext()) {
			String word = it.next();
			if (s.startsWith(word)) {
				s = s.substring(word.length());
				List<String> temp = new LinkedList<String>();
				temp.addAll(words);
				temp.remove(word);
				return isHasStartedString(s, temp);
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
//		String s = "aaaaaaaa";
//		String[] words = {"aa","aa","aa"};
//		String s = "barfoothefoobarman";
//		String[] words = {"foo","bar"};
		String s = "wordgoodstudentgoodword";
		String[] words = {"word","student"};
		System.out.println("findSubstring = " + new Question_30().findSubstring(s, words));
	}
	
}
