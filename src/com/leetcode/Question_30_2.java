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
public class Question_30_2 {
	
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new LinkedList<Integer>();
        List<String> wordList = Arrays.asList(words);
        List<String> wordMatchedList = new LinkedList<String>();
        for (String word : wordList) {
        	if (wordMatchedList.contains(word)) {
        		continue;
        	}
        	String temp = s;
    		List<Integer> indexs = indexOfAll(temp, word);
        	if (indexs.size() > 0) {
        		List<String> tempWords = new LinkedList<String>();
        		tempWords.addAll(wordList);
        		tempWords.remove(word);
        		
        		for (int index : indexs) {
        			temp = s;
        			temp = temp.substring(index + word.length());
            		if (isHasStartedString(temp, tempWords)) {
            			result.add(index);
            		}
        		}
        	}
        	wordMatchedList.add(word);
        }
		return result;
    }
	
	private List<Integer> indexOfAll(String matchedString, String word) {
		String tempString = matchedString;
		List<Integer> result = new LinkedList<Integer>();
		
		for (int i = 0; i <= matchedString.length() - word.length(); ) {
			tempString = matchedString;
			if (i != 0) {
				tempString = tempString.substring(i);
			}
			int tempIndex = tempString.indexOf(word);
			if (tempIndex == -1)
				break;
			
			result.add(i + tempIndex);
			i = i + tempIndex + 1;
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
//		String s = "a";
//		String[] words = {"a"};
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		String[] words = {"a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a"};
//		String s = "barfoothefoobarman";
//		String[] words = {"foo","bar"};
//		String s = "wordgoodstudentgoodword";
//		String[] words = {"word","student"};
		System.out.println("findSubstring = " + new Question_30_2().findSubstring(s, words));
	}
	
}
