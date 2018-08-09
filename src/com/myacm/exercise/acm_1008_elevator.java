package com.myacm.exercise;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class acm_1008_elevator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			if(n == 0)
				break;
			
			for(int i = 0; i < n; i++){
				list.add(sc.nextInt());
			}
			System.out.println(calTimes(list) + "");
			list.clear();
		}
	}
	
	private static int calTimes(List<Integer> list) {
		int time = 0;
		int n = list.size();
		for(int i = 0; i < n; i++){
			if(i == 0){
				time += calTime(0, list.get(i));
			}else
				time += calTime(list.get(i - 1), list.get(i));
		}
		return time;
	}
	
	private static int calTime(int first, int last){
		if(first > last){
			return 4 * (first - last) + 5;
		}else{
			return 6 * (last - first) + 5;
		}
	}

	private static List<Integer> list = new LinkedList<Integer>()	;

}
