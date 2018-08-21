package com.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * @author fangji
 * 
 * 题目：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 * 
 * 解题思路：
 * 
 * 
 * 参考资料：
 * https://blog.csdn.net/weixin_41761806/article/details/80423250
 * https://blog.csdn.net/newbie_lb/article/details/80007386
 * 
 */
public class Question_122 {
	
	public int maxProfit(int[] prices) {
		if(prices==null)return 0;
        if(prices.length<2)return 0;
        int ret=0;
        for(int i=1;i<prices.length;i++){
            ret+= Math.max(0,prices[i]-prices[i-1]);
        }
        return ret;
	}
	
	public static void main(String[] args) {
		int[] prices = {7,6,4,3,1};
//		int[] prices = {1,2,3,4,5};
//		int[] prices = {7,1,5,3,6,4};
		System.out.println("maxProfit = " + new Question_122().maxProfit(prices));
	}
}
