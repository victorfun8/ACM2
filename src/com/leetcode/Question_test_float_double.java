package com.leetcode;

import java.math.BigDecimal;

public class Question_test_float_double {
	
	public static void main(String[] args) {
		float f1 = 1300000.1111111f;
		float f2 = 145.111111f;
		System.out.println(f1);
		System.out.println(f2);
		System.out.println(f1 + f2);
		
		float f3 = 0.1111111f;
		float f4 = 1.111111f;
		System.out.println(f3);
		System.out.println(f4);
		
		double d1 = 130.1111111;
		double d2 = 145.111111;
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(d1 + d2);
		
		BigDecimal bd1 = new BigDecimal(Double.toString(d1));
		BigDecimal bd2 = new BigDecimal(Double.toString(d2));
		System.out.println(bd1.add(bd2).doubleValue());
	}
}
