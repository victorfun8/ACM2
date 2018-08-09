package com.myacm.exercise;

import java.util.Scanner;

public class acm_1005_Number_Sequence {
	public static void main(String[] args) {
		acm_1005_Number_Sequence acm = new acm_1005_Number_Sequence();
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int n = sc.nextInt();
			
			if(a == 0 && b == 0 && n == 0)
				return;
			
			if(a < 1 || a > 1000 || b < 1|| b > 1000 || n < 1 || n > 100000000)
				continue;
			
			acm.num = new int[n];
			acm.initNum(acm.num);
			
			System.out.println("" + acm.numSequence(a, b, n-1));
		}
	}

	private int[] num;
	private void initNum(int[] num){
		for(int i=0; i < num.length; i++){
			num[i] = -1;
		}
		num[0] = 1;
		num[1] = 1;
	}
	
	private int numSequence(int a, int b, int n) {
		if(n == 0){
			return 1;
		}
		if(n == 1){
			return 1;
		}
		if(num[n-1] != -1 && num[n-2] != -1){
			return (a * num[n-1] + b * num[n-2]) % 7;
		}else if(num[n-1] != -1){
			return (a * num[n-1] + b * numSequence(a, b, n - 2)) % 7;
		}else if(num[n-2] != -1){
			return (a * numSequence(a, b, n - 1) + b * num[n-2]) % 7;
		}else
			return (a * numSequence(a, b, n - 1) + b * numSequence(a, b, n - 2)) % 7;
	}
}
