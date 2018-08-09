package com.myacm.exercise;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class acm_1009_FatMouse_Trade {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int m = sc.nextInt();//fatMouse has m pounds of cat food
			int n = sc.nextInt();
			
			if(m == -1 && n == -1)
				break;
			
			int[] j = new int[n];//JavaBean
			int[] f = new int[n];//food for cat guarding the warehouse
			double[] cost = new double[n];
			
			for(int i = 0; i < n; i++){
				j[i] = sc.nextInt();
				f[i] = sc.nextInt();
				cost[i] = j[i] / f[i];
			}
			
			System.out.println("" + calMaxJavaBean(m, n, j, f, cost));	
		}

	}

	private static String calMaxJavaBean(int m, int n, int[] j, int[] f, double[] cost) {
		int rest = m;
		LinkedList<Double> l = new LinkedList<Double>();
		Collections.
		return null;
	}

}
