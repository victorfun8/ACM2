package com.myacm.exercise;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class acm_1004_collection {
	private static Map<String, Integer> colors = new HashMap<String, Integer>();
	
	private static String maxNum(Map<String, Integer> colors2){
		String t = null;
		int max = 0;
		Set<Entry<String, Integer>> set = colors2.entrySet();
		Iterator<Entry<String, Integer>> it = set.iterator();
		while(it.hasNext()){
			Entry<String, Integer> entry = it.next();
			if(max < entry.getValue()){
				max = entry.getValue();
				t = entry.getKey();
			}
		}
		return t;
	}
	
	private static void getNewString(String text){
		if(colors.size() == 0){
			colors.put(text, 1);
			return;
		}
		boolean flag = false;
		for(String key : colors.keySet()){
			if(text.equals(key)){
				flag = true;
			}
		}
		if(flag){
			colors.put(text, colors.get(text) + 1);
		}else
			colors.put(text, 1);
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()){
			int n = s.nextInt();
			if(n == 0)
				return;
			if (n <= 1000 && n > 0) {
				for (int i = 1; i <= n; i++) {
					String text = s.next();
					getNewString(text);
				}
			}
			System.out.println(maxNum(colors));
			colors.clear();
		}
	}
}
