package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author fangji
 * 
 * 题目：https://leetcode-cn.com/problems/longest-valid-parentheses/description/
 * 
 * 解题思路：
 * 
 * 参考资料：
 * 	
 */
public class Question_32 {
	
	public int longestValidParentheses(String s) {
		int max = 0;
		Stack<Integer> stack = new Stack<Integer>();
		int len = s.length();
		
		for (int i=0; i<len; i++) {
			if (s.charAt(i) == '(') {
				stack.push(0);
			} else {
				if (stack.size() == 0) {
					continue;
				} else if (stack.size() == 1) {
					if (stack.pop() == 0) {
						stack.push(2);
						max = Math.max(max, 2);
					}
				} else {
					if (stack.peek() == 0) {
						if (stack.get(stack.size() - 2) != 0) {
							stack.pop();
							int temp = stack.pop();
							temp += 2;
							stack.push(temp);
							max = Math.max(temp, max);
						} else {
							stack.pop();
							stack.push(2);
							max = Math.max(2, max);
						}
					} else {
						if (stack.get(stack.size() - 2) == 0) {
							int temp = stack.pop();
							stack.pop();
							temp += 2;
							if (!stack.isEmpty() && stack.peek() != 0) {
								temp = temp + stack.pop();
							}
							stack.push(temp);
							max = Math.max(temp, max);
						}
					}
				}
			}
		}
		return max;
	}
	
//	/** 解法1，有问题，未通过 **/
//	enum State {
//		addNewOne,
//		addLastOne,
//		addBeforeOne,
//		addNull
//	}
//	
//	public int longestValidParentheses(String s) {
//        Stack<String> stackStr = new Stack<String>();
//        Stack<Integer> stack = new Stack<Integer>();
//        int strLen = s.length();
//        int index = 0;
//        
//        while (index < strLen) {
//        	State state;
//        	if (s.subSequence(index, index+1).equals(")")) {
//        		if (index > 0 && stackStr.size() > 0) {
//        			stackStr.pop();
//        			
//        			if (s.substring(index - 1, index).equals("(")) {
//        				if (stackStr.size() == 0) {
//        					state = State.addBeforeOne;
//        				} else {
//        					state = State.addLastOne;        					
//        				}
//            		} else {
//            			state = State.addBeforeOne;
//            		}
//        		} else {
//        			state = State.addNewOne;
//        		}
//        	} else {
//        		stackStr.push("(");
//        		state = State.addNewOne;
//        	}
//        	
//        	switch (state) {
//        	case addNewOne:
//        		stack.push(0);
//        		break;
//        	case addLastOne:
//        		int tempLastLen = stack.pop();
//    			tempLastLen += 2;
//    			stack.push(tempLastLen);
//        		break;
//        	case addBeforeOne:
//        		int last = stack.pop();
//        		if (stack.size() > 0) {
//	        		int lastBefore = stack.pop();
//	        		if (stack.size() >= 1 && stack.get(stack.size() - 1) != 0) {
//	        			lastBefore = lastBefore + 2 + last;
//	        			int lastBeforeBefore = stack.pop();
//	        			lastBeforeBefore = lastBeforeBefore + lastBefore;
//	        			stack.push(lastBeforeBefore);
//	        		} else {
//	        			lastBefore = lastBefore + 2 + last;
//	        			stack.push(lastBefore);        			
//	        		}
//        		} else {
//        			last += 2;
//        			stack.push(last);
//        		}
//        		break;
//        	case addNull:
//	
//        		break;
//        	}
//        	
//        	index++;
//        }
//        
//		return getMax(stack);
//    }
//	
//	private int getMax(Stack<Integer> stack) {
//		int max = 0;
//		for(int temp : stack) {
//			if (temp > max) 
//				max = temp;
//		}
//		return max;
//	}

	/** 
	 * 网上找的正确解法，AC
	 * @param args
	 */
//	public int longestValidParentheses(String s) {
//		 int n = s.length();
//	        Stack<Integer> stack = new Stack<Integer>();
//	        int max = 0;
//	        
//	        for(int i=0;i<n;i++){
//	            if(s.charAt(i)=='('){
//	                stack.push(0);
//	            }else{
//	                if(stack.size()==0){
//	                    continue;
//	                }else if(stack.size()==1){
//	                    if(stack.pop()==0){
//	                        stack.push(2);
//	                        max = Math.max(max,2);
//	                    }
//	                }else{
//	                    if(stack.peek()==0){
//	                        stack.pop();
//	                        int num = 2;
//	                        if(stack.peek()!=0){
//	                            num += stack.pop();
//	                        }
//	                        stack.push(num);
//	                        max = Math.max(max,num);
//	                    }else{
//	                        int temp = stack.pop();
//	                        stack.pop();
//	                        temp+=2;
//	                        if(!stack.isEmpty()&&stack.peek()!=0){
//	                            temp += stack.pop();
//	                        }
//	                        max = Math.max(max,temp);
//	                        stack.push(temp);
//	                    }
//	                }
//	            }
//	        }
//	        return max;
//	}

	public static void main(String[] args) {
//		String s = "(()";
//		String s = ")()())";
//		String s= "()(()";
//		String s = "(()()";
//		String s = "()(())";
//		String s = "()((()))";
//		String s = "((()))())";
		String s = ")()())()()(";
		System.out.println("longestValidParentheses = " + new Question_32().longestValidParentheses(s));
	}
	
}
