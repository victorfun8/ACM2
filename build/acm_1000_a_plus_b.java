package com.myacm.exercise;

import java.util.*;

//�ύʱ������һ��Ҫ�ǣ�Main������CE��
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
