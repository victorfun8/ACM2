package com.myacm.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class acm_1004_Let_the_Balloon_Rise {
	class Color{
		protected Color(String key, int value){
			this.key = key;
			this.value = value;
		}
		
		String key = "";
		int value = 0;
	}
	private List<Color> colors = new ArrayList<Color>();
	
	private String maxNum(List<Color> colors2){
		String t = null;
		int max = 0;
		for(Color c : colors2){
			if(max < c.value){
				max = c.value;
				t = c.key;
			}
		}
		return t;
	}
	
	private void getNewString(String text){
		if(colors.size() == 0){
			colors.add(new Color(text, 1));
			return;
		}
		int len = colors.size();
		for(int i = 0; i < len; i++){
			Color c = colors.get(i);
			if(text.equals(c.key)){
				c.value++;
			}else{
				colors.add(new Color(text, 1));
			}
		}
	}
	
	public static void main(String[] args) {
		acm_1004_Let_the_Balloon_Rise acm = new acm_1004_Let_the_Balloon_Rise();
		
		Scanner s = new Scanner(System.in);
		while(s.hasNext()){
			int n = s.nextInt();
			if (n <= 1000 && n > 0) {
				for (int i = 1; i <= n; i++) {
					String text = s.next();
					acm.getNewString(text);
				}
			}
			System.out.println(acm.maxNum(acm.colors));			
		}
	}
	
	
}
