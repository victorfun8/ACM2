package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author fangji
 * 
 * 题目：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/description/
 * 
 * 解题思路：参考java LinkedList的实现方式，主要是get方法和size方法
 * 
 * 参考资料：
 * 	
 */
public class Question_19 {
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = size(head);
        int index = size - n;
        
        if (index == size) {
        	ListNode removeB = get(head, size, index - 1);
        	removeB.next = null;
        	return head;
        } else if (index == 0) {
        	if (size == 1) {
        		return null;
        	}
        	ListNode removeA = get(head, size, index + 1);
        	return removeA;
        } else {
        	ListNode removeB = get(head, size, index - 1);
        	ListNode removeA = get(head, size, index + 1);
        	removeB.next = removeA;
        	return head;
        }
    }
	
	private int size(ListNode head) {
		if (head == null)
			return 0;
		
		int i = 1;
		ListNode temp = head;
		while (temp.next != null) {
			i++;
			temp = temp.next;
		}
		return i;
	}
	
	private ListNode get(ListNode head, int n, int index) {
		int i = 0;
		ListNode temp = head;
		while (i < n) {
			if (i == index) {
				return temp;
			}
			i++;
			temp = temp.next;
		}
		return null;
	}
	
	public static void main(String[] args) {
		Question_19 q_19 = new Question_19();
//		ListNode listNode1 = q_19.new ListNode(1);
//		ListNode listNode2 = q_19.new ListNode(2);
//		ListNode listNode3 = q_19.new ListNode(3);
//		ListNode listNode4 = q_19.new ListNode(4);
//		ListNode listNode5 = q_19.new ListNode(5);
//		listNode1.next = listNode2;
//		listNode2.next = listNode3;
//		listNode3.next = listNode4;
//		listNode4.next = listNode5;
//		int n = 2;
		
		ListNode listNode1 = q_19.new ListNode(1);
		int n = 1;
		System.out.println("removeNthFromEnd = " + new Question_19().removeNthFromEnd(listNode1, n));
	}
	
	
	class ListNode {
		int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	    
		@Override
		public String toString() {
			return "ListNode [val=" + val + ", next=" + next + "]";
		}
	    
	}
}
