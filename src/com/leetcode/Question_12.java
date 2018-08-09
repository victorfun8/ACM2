package com.leetcode;

/**
 * 
 * @author fangji
 * 
 * 题目：https://leetcode-cn.com/problems/integer-to-roman/description/
 * 
 * 解题思路：
 * 
 * 参考资料：https://segmentfault.com/a/1190000008824222
 * 	
 */
public class Question_12 {
	public String intToRoman(int num) {
		StringBuilder sb = new StringBuilder();
		
		if (num >= 1000) {
			int n = num / 1000 % 10;
			for (int i=0; i < n; i++) {
				sb.append("M");
			}
		}
		
		if (num >= 100) {
			int n = num / 100 % 10;
			if (n == 1 || n == 2 || n == 3) {
				for (int i=0; i < n; i++) {
					sb.append("C");
				}
			} else if (n == 4) {
				sb.append("CD");
			} else if (n == 5) {
				sb.append("D");
			} else if (n == 6 || n == 7 || n == 8) {
				sb.append("D");
				for (int i=0; i < n-5; i++) {
					sb.append("C");
				}
			} else if (n == 9) {
				sb.append("CM");
			}
		}
		
		if (num >= 10) {
			int n = num / 10 % 10;
			if (n == 1 || n == 2 || n == 3) {
				for (int i=0; i < n; i++) {
					sb.append("X");
				}
			} else if (n == 4) {
				sb.append("XL");
			} else if (n == 5) {
				sb.append("L");
			} else if (n == 6 || n == 7 || n == 8) {
				sb.append("L");
				for (int i=0; i < n-5; i++) {
					sb.append("X");
				}
			} else if (n == 9) {
				sb.append("XC");
			}
		}
		
		if (num > 0) {
			int n = num % 10;
			if (n == 1 || n == 2 || n == 3) {
				for (int i=0; i < n; i++) {
					sb.append("I");
				}
			} else if (n == 4) {
				sb.append("IV");
			} else if (n == 5) {
				sb.append("V");
			} else if (n == 6 || n == 7 || n == 8) {
				sb.append("V");
				for (int i=0; i < n-5; i++) {
					sb.append("I");
				}
			} else if (n == 9) {
				sb.append("IX");
			}
		}
		
		return sb.toString();
    }
	
	
	
	public static void main(String[] args) {
		int romaNum = 1994;
		System.out.println("intToRoman = " + new Question_12().intToRoman(romaNum));
	}
}
