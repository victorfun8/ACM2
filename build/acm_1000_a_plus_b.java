package com.myacm.exercise;

import java.util.*;

//提交时的类名一定要是：Main，否则CE。
public class acm_1000_a_plus_b {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int a, b;
		while (cin.hasNextInt()) {
			a = cin.nextInt();
			b = cin.nextInt();
			System.out.println(a + b);
		}
	}
}
