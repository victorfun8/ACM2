package com.leetcode;

/**
 * 
 * @author fangji
 * 
 * 题目：https://leetcode-cn.com/problems/reverse-nodes-in-k-group/description/
 * 
 * 解题思路：
 * 
 * 参考资料：
 * 	
 */
public class Question_25 {
	
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null) {
			return head;
		}
		if (k == 1)
			return head;
		
        int size = size(head);
        if (k > size) {
        	return head;
        }
        
        int index = 0;
        ListNode result = null;
        while (k - index - 1 > index) {
        	if (k == 2 || (k - index - 1 - index == 1)) {//两个node毗邻
        		ListNode first = get(head, size, index);
        		ListNode second = get(head, size, k - index - 1);
        		ListNode secondNext = getLastNextNode(second.next, index, k);
        		ListNode firstBefore = null;
        		if (index != 0) {
        			firstBefore = get(head, size, index - 1);
        		}
        		
        		first.next = secondNext;
        		second.next = first;
        		if (index != 0) {
        			firstBefore.next = second;
        		}
        		
        		if (index == 0) {
        			result = second;
        			head = result;
        		}
        	} else if (k == 3 || (k - index - 1 - index == 2)) {//两个node中间隔一个
        		ListNode first = get(head, size, index);
        		ListNode middle = first.next;
        		ListNode second = get(head, size, k - index - 1);
        		ListNode secondNext = getLastNextNode(second.next, index, k);
        		ListNode firstBefore = null;
        		if (index != 0) {
        			firstBefore = get(head, size, index - 1);
        		}
        		
        		first.next = secondNext;
        		middle.next = first;
        		second.next = middle;
        		if (index != 0) {
        			firstBefore.next = second;
        		}
        		
        		if (index == 0) {
        			result = second;
        			head = result;
        		}
        	} else {
        		ListNode first = get(head, size, index);
        		ListNode second = get(head, size, k - index - 1);
        		ListNode secondBefore = get(head, size, k - index - 2);
        		ListNode firstNext = first.next;
        		ListNode secondNext = getLastNextNode(second.next, index, k);
        		ListNode firstBefore = null;
        		if (index != 0) {
        			firstBefore = get(head, size, index - 1);
        		}
        		
        		first.next = secondNext;
        		secondBefore.next = first;
        		second.next = firstNext;
        		if (index != 0) {
        			firstBefore.next = second;
        		}
        		
        		if (index == 0) {
        			result = second;
        			head = result;
        		}
        	}
        	index++;
        }
        return result;
    }
	
	private ListNode getLastNextNode(ListNode head, int index, int k) {
		if (index == 0) {
			int size = size(head);
			if (size - k >= 0) {
				return reverseKGroup(head, k);				
			}
		}
		return head;
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
		Question_25 question = new Question_25();
//		ListNode ln1 = question.new ListNode(1);
//		ListNode ln2 = question.new ListNode(2);
//		ListNode ln3 = question.new ListNode(3);
//		ListNode ln4 = question.new ListNode(4);
//		ListNode ln5 = question.new ListNode(5);
//		ln1.next = ln2;
//		ln2.next = ln3;
//		ln3.next = ln4;
//		ln4.next = ln5;
//	
//		int n =2;
		ListNode ln1 = question.new ListNode(1);
		ListNode ln2 = question.new ListNode(2);
		ListNode ln3 = question.new ListNode(3);
		ListNode ln4 = question.new ListNode(4);
		ln1.next = ln2;
		ln2.next = ln3;
		ln3.next = ln4;
	
		int n = 4;

		System.out.println("reverseKGroup = " + new Question_25().reverseKGroup(ln1, n));
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
