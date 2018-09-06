package com.leetcode;

import com.leetcode.Question_19.ListNode;

/**
 * 
 * @author fangji
 * 
 * 题目：https://leetcode-cn.com/problems/swap-nodes-in-pairs/description/
 * 
 * 解题思路：
 * 
 * 参考资料：
 * 	
 */
public class Question_24 {
	
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) 
			return head;
		
		ListNode head1 = head;
		ListNode headNext = head.next;
		ListNode headNextNext = head.next.next;

		headNext.next = head1;
		head1.next = swapPairs(headNextNext);
		
		return headNext;
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
		Question_24 question = new Question_24();
		ListNode ln1 = question.new ListNode(1);
		ListNode ln2 = question.new ListNode(2);
		ListNode ln3 = question.new ListNode(3);
		ListNode ln4 = question.new ListNode(4);
		ListNode ln5 = question.new ListNode(5);
		ln1.next = ln2;
		ln2.next = ln3;
		ln3.next = ln4;
		ln4.next = ln5;
	
		System.out.println("swapPairs = " + new Question_24().swapPairs(ln1));
	}
	
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
		
	    @Override
		public String toString() {
			return "ListNode [val=" + val + ", next=" + next + "]";
		}
	}

}
