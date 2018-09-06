package com.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.sort.StraightInsertionSort;

public class CalcTimeUtil {
	
	public static void calMethodInvokeTime(Method m, Object invoker, Object... args) {
		long startTime=System.currentTimeMillis();//记录开始时间
		 
		try {
			System.out.println(m.getName() + " result -> " + m.invoke(invoker, args));
		} catch (IllegalAccessException e) {
			System.out.println(e.toString());
		} catch (IllegalArgumentException e) {
			System.out.println(e.toString());
		} catch (InvocationTargetException e) {
			System.out.println(e.toString());
		}
		 
		long endTime=System.currentTimeMillis();//记录结束时间
		 
		float excTime=(float)(endTime-startTime)/1000;
		 
		System.out.println("执行时间："+excTime+"s");
	}
}
