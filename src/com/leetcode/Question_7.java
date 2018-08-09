package com.leetcode;

/**
 * 
 * @author fangji
 * 
 * 题目：https://leetcode-cn.com/problems/reverse-integer/description/
 * 示例1：输入: 123，输出: 321
 * 示例2：输入: -123，输出: -321
 * 示例3：输入: 120，输出: 21
 * 注意:假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0
 *
 * 思路：String没有反转的api，StringBuilder有，利用StringBuilder的反转api
 *
 */
public class Question_7 {
	public int reverse(int x) {
		try {
			String value = String.valueOf(x);
			StringBuilder sb = new StringBuilder();
			boolean fuShu = false;
			if (value.startsWith("-")) {
				sb.append(value.substring(1));
				fuShu = true;
			} else {
				sb.append(value);
			}
			
			sb.reverse();
			while (sb.charAt(0) == 48) {
				sb.deleteCharAt(0);
			}
			return fuShu ? Integer.parseInt("-" + sb.toString()) : Integer.parseInt(sb.toString());			
		} catch(Exception e) {
			return 0;
		}
    }
	
	public static void main(String[] args) {
		int test = -1234567899;
		System.out.println("reverse = " + new Question_7().reverse(test));
	}
}
