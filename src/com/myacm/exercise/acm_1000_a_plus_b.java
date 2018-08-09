package com.myacm.exercise;

import java.util.*;

//提交时，类名必须是Main，否则无法通过
//提交时，package xxx这行不用提交，否则报Wrong anwser
public class acm_1000_a_plus_b{
    public static void main(String args[]) {
    	Scanner cin = null;
    	try {
    		cin = new Scanner(System.in);
            int a, b;
            while (cin.hasNext()) {
                a = cin.nextInt(); 
                b = cin.nextInt();
                System.out.println(a + b);
            }
    	} finally {
    		if (cin != null) {
    			cin.close();
    		}
    	}
    }
}