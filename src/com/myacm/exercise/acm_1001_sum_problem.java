package com.myacm.exercise;

import java.util.ArrayList;
import java.util.Scanner;

public class acm_1001_sum_problem {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(s.hasNextInt()){
			list.add(s.nextInt());
		}
		for (int n : list) {
			print(sum(n));
		}
	}
	
	private static int sum(int num){
		if(num > 0){
			return num + sum(num - 1);
		}
		return 0;
	}
	
	private static void print(int result) {
		System.out.println("" + result);
		System.out.println();
	}
}
