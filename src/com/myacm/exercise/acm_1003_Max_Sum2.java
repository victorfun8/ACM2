package com.myacm.exercise;

import java.util.Scanner;

public class acm_1003_Max_Sum2 {
	public static void main(String[] args) {
		acm_1003_Max_Sum2 acm = new acm_1003_Max_Sum2();
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		if (t <= 20 && t >= 1) {
			for (int i = 1; i <= t; i++) {
				int num = s.nextInt();
				acm.mNum = new int[num];
				int j = 0;
				while(num > j){
					acm.mNum[j] = s.nextInt();
					j++;
				}
				
				acm.maxResult = acm.mNum[0];
				
				System.out.println("Case " + i + ":");
				
				System.out.println(acm.getMax3(0, acm.mNum.length - 1) + " " + (acm.startIndex + 1) + " " + (acm.endIndex + 1));
				if(i != t)
					System.out.println();
			}
		}
	}
	int startIndex = 0, endIndex = 0;
	int[] mNum;
	int maxResult = 0;
	
	private int getMax3(int indexStart, int indexEnd){
		
		if (indexStart == indexEnd) {
			return mNum[indexStart];
		} else {
			return maxResult + getMax3(indexStart + 1, indexEnd);
		}
	}
}
