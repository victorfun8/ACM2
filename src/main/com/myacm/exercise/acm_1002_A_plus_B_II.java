package com.myacm.exercise;

import java.math.BigDecimal;
import java.util.Scanner;

public class acm_1002_A_plus_B_II {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		if (t <= 20 && t >= 1) {
			for (int i = 1; i <= t; i++) {
				BigDecimal a = s.nextBigDecimal();
				BigDecimal b = s.nextBigDecimal();
				System.out.println("Case " + i + ":");
				System.out.println(a + " + " + b + " = " + a.add(b).toString());
				if(i != t)
					System.out.println();
			}
		}
	}
}
