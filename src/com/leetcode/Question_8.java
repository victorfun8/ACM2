package com.leetcode;

/**
 * 
 * @author fangji
 * 
 * 题目：https://leetcode-cn.com/problems/string-to-integer-atoi/description/
 * 示例1：输入: "42"，输出: 42
 * 示例2：输入: "   -42"，输出: -42，解释: 第一个非空白字符为 '-', 它是一个负号。我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例3：输入: "4193 with words"，输出: 4193，解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例4：输入: "words and 987"，输出: 0，解释: 第一个非空字符是 'w', 但它不是数字或正、负号。 因此无法执行有效的转换。
 * 示例5:输入: "-91283472332",输出: -2147483648,解释: 数字 "-91283472332" 超过 32 位有符号整数范围。  因此返回 INT_MIN (−231) 。
 * 
 * 解题思路：
 * 	用正则表达式把符合的数字删选出来，然后通过Integer的parseInt方法转换String成Int
 */
public class Question_8 {
	public int myAtoi(String str) {
        if (str.trim().equals("") || str == null) {
    		return 0;
    	}
        
        if (str.trim().equals("-") || str.trim().equals("+")) {
            return 0;
        }
        String temp = str.trim();
        StringBuilder sb = new StringBuilder();
        int result = 0;

        if (!temp.substring(0, 1).matches("^([0-9]|[-]|[+])$")) {
        	return result;
        }
        
        boolean isFuShu = false;
        
        for (int i = 0; i < temp.length(); i++) {
        	String value = temp.substring(i, i+1);
        	if (i == 0 && value.matches("^[-]$")) {
        		isFuShu = true;
        	} else if (i == 0 && value.matches("^[+]$")) {
        		continue;
        	} else if (value.matches("^[0-9]$")) {
        		sb.append(value);
        	} else {
        		break;
        	}
        }
        
        try {
        	if (sb.toString().equals("")) {
        		return 0;
        	}
        	if (isFuShu) {
        		result =  Integer.parseInt("-"+sb.toString());
        	} else {
        		result = Integer.parseInt(sb.toString());        		
        	}
        } catch (Exception e) {
        	System.out.println(e.toString());
        	if (isFuShu) 
        		result = Integer.MIN_VALUE;
        	else
        		result = Integer.MAX_VALUE;
        }
        return result;
    }
	
	public static void main(String[] args) {
		String test = "+-2";
		System.out.println("myAtoi = " + new Question_8().myAtoi(test));
	}
}
