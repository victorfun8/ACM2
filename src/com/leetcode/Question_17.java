package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author fangji
 * 
 * 题目：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/
 * 
 * 解题思路：
 * 
 * 参考资料：
 * 	
 */
public class Question_17 {
	
	public List<String> letterCombinations(String digits) {
		List<String> list = new ArrayList();
		if (digits.length() == 0) {
			return list;
		}
		if (digits.length() == 1) {
			list.addAll(Arrays.asList(getStringByNum(Integer.parseInt(digits))));
			return list;
		}
		
		if (digits.length() == 2) {
        	String[] temp1 = getStringByNum(Integer.parseInt(digits.substring(0, 1)));
        	String[] temp2 = getStringByNum(Integer.parseInt(digits.substring(1)));
        	for (String s1 : temp1) {
        		for (String s2 : temp2) {
        			list.add(s1 + s2);
        		}
        	}
        	return list;
        }
		
        if (digits.length() > 2) {
        	List<String> tempL = letterCombinations(digits.substring(1));
        	String[] temp1 = getStringByNum(Integer.parseInt(digits.substring(0, 1)));
        	for (String sl : tempL) {
        		for (String s1 : temp1) {
        			list.add(s1 + sl);
        		}
        	}
        	return list;
        } 
        
        return list;
    }
	
	private String[] getStringByNum(int num) {
		switch (num) {
		case 2:
			return new String[]{"a", "b", "c"};
		case 3:
			return new String[]{"d", "e", "f"};
		case 4:
			return new String[]{"g", "h", "i"};
		case 5:
			return new String[]{"j", "k", "l"};
		case 6:
			return new String[]{"m", "n", "o"};
		case 7:
			return new String[]{"p", "q", "r", "s"};
		case 8:
			return new String[]{"t", "u", "v"};
		case 9:
			return new String[]{"w", "x", "y", "z"};
		default:
			return new String[]{" "};
		}
	}
	
	public static void main(String[] args) {
		String s = "23";
		System.out.println("letterCombinations = " + new Question_17().letterCombinations(s));
	}
}
