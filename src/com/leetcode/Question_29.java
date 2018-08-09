package com.leetcode;

/**
 * 
 * @author fangji
 * 
 * 题目：https://leetcode-cn.com/problems/divide-two-integers/description/
 * 
 * 解题思路：
 * 
 * 参考资料：
 * 	
 */
public class Question_29 {
	
	public int divide(int dividend, int divisor) {
		if (dividend == 0) {
			return 0;
		} else if (dividend > 0 && divisor < 0) {
			return -getValue(-dividend, divisor);
		} else if (dividend < 0 && divisor > 0) {
			return -getValue(dividend, -divisor);
		} else if (dividend > 0 && divisor > 0) {
			return getValue(-dividend, -divisor);
		} else {
			if (dividend == Integer.MIN_VALUE && divisor == -1)
				return Integer.MAX_VALUE;
			return getValue(dividend, divisor);
		}
		
    }
	
	private int getValue(long dividend, long divisor) {
		
		if (dividend > divisor) {
			return 0;
		}
		int index = 1;
		long newDivisor = divisor;
		newDivisor += newDivisor;
		long oldDivisor = newDivisor;
        
        while (dividend <= newDivisor) {
        	oldDivisor = newDivisor;
        	newDivisor += newDivisor;
        	index += index;
        }
        
        dividend -= oldDivisor;
        return index + getValue(dividend, divisor);
	}
	
	public static void main(String[] args) {
		int dividend = 10, divisor = 3;
		System.out.println("divide = " + new Question_29().divide(dividend, divisor));
	}
	
}
