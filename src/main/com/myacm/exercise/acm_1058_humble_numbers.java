package com.myacm.exercise;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class acm_1058_humble_numbers {
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		acm_1058_humble_numbers acm = new acm_1058_humble_numbers();
		acm.list = new TreeSet<Long>(acm.new com());
		acm.calList(acm.hhh, acm.hhh.length, 1);
		System.out.println(acm.list.toString());
		
		while(sc.hasNext()){
			int n = sc.nextInt();
			if(n == 0)
				break;
			
			if(n % 100 == 11 || n % 100 == 12 || n % 100 == 13)
				System.out.println("The " + n + "th humble number is " + acm.getHumbleNumber(n) + ".");
			else if(n % 10 == 1)
				System.out.println("The " + n + "st humble number is " + acm.getHumbleNumber(n) + ".");
			else if(n % 10 == 2)
				System.out.println("The " + n + "nd humble number is " + acm.getHumbleNumber(n) + ".");
			else if(n % 10 == 3)
				System.out.println("The " + n + "rd humble number is " + acm.getHumbleNumber(n) + ".");
			else
				System.out.println("The " + n + "th humble number is " + acm.getHumbleNumber(n) + ".");
		}
	}

	private Set<Long> list;
	
	private long getHumbleNumber(int n) {
		int index = 0;
		for(long a : list){
			index++;
			if(index != n)
				continue;
			return a;
		}
		return 0;
	}
	
	private long h_2 = 2L,
						h_3 = 3L,
						h_5 = 5L,
						h_7 = 7L;
	private long[] hhh = {7,5,3,2};
	private final long MAX_NUMBER = 2000000000;
	
	private void calHumbleNumber(){
		long temp_h2, temp_h3, temp_h5, temp_h7;
		for(int a = 0; a < 32; a++){
			temp_h2 = power(h_2, a);
			
			if(temp_h2 > MAX_NUMBER)
				break;
			else
				list.add(temp_h2);
			
			for(int b = 0; b < 32; b++){
				temp_h3 = power(h_3, b);
				
				long re_h3 = temp_h2 * temp_h3;
				if(re_h3 > MAX_NUMBER)
					break;
				else
					list.add(re_h3);
				
				for(int c = 0; c < 32; c++){
					temp_h5 = power(h_5, c);
					
					long re_h5 = temp_h2 * temp_h3 * temp_h5;
					if(re_h5 > MAX_NUMBER)
						break;
					else
						list.add(re_h5);
					
					for(int d = 0; d < 32; d++){
						temp_h7 = power(h_7, d);
						
						long re_h7 = temp_h2 * temp_h3 * temp_h5 * temp_h7;
						
						if(re_h7 > MAX_NUMBER)
							break;
						else
							list.add(re_h7);
					}
				}
			}
		}
		System.out.println(list.toString());
	}
	
	private void calList(long[] hhh, int longSize, long re_h){
		if(longSize != 0){
			longSize--;
			int d = 0;
			while(d < 32){
				long temp_h = power(hhh[longSize], d);
				if(re_h > MAX_NUMBER)
					break;
				list.add(temp_h);
				calList(hhh, longSize, temp_h);
				
				re_h *= temp_h;	
				d++;
				if(re_h > MAX_NUMBER)
					break;
				list.add(re_h);
				calList(hhh, longSize, re_h);
			}			
		}
	}
	
	private long power(long a, int p){
		long temp = 1;
		if(p == 0)
			return temp;
		
		for(int i = 1; i <= p; i++){
			temp *= a;
		}
		return temp;
	}
	
	class com implements Comparator<Long>{

		@Override
		public int compare(Long o1, Long o2) {
			int flag = o1.compareTo(o2);
			if(flag == 0){
				return o1.compareTo(o2);
			}else
				return flag;
		}
		
	}
}
