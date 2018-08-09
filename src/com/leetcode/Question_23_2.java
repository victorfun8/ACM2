package com.leetcode;

/**
 * 
 * @author fangji
 * 
 * 题目：https://leetcode-cn.com/problems/merge-k-sorted-lists/description/
 * 
 * 解题思路：此方法通过验证，所有数组读取头元素，比较大小，取最小的
 * 
 * 参考资料：
 * 	
 */
public class Question_23_2 {
	
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0)
        	return null;
		if (lists.length == 1)
        	return lists[0];
		
        return containListNodes(lists);
    }
	
	private ListNode containListNodes(ListNode[] lns) {
		int len = lns.length;
		int[] index = new int[len];
		int[] lens = new int[len];
		for (int i=0; i < len; i++) {
			index[i] = 0;
			lens[i] = size(lns[i]);
		}
		ListNode result = null;
		int i = 0;
		while (xunhuanIsOver(index, lens, len))	{
			ListNode temp = getMin(lns, index);
			if (result == null) {
				result = temp;
			} else {
				get(result, i).next = temp;
			}
			i++;
		}
		
		return result;
	}
	
	private ListNode get(ListNode head, int index) {
		int i = 0;
		ListNode temp = head;
		while (i < index - 1) {
			i++;
			temp = temp.next;
		}
		return temp;
	}
	
	private boolean xunhuanIsOver(int[] index, int[] lens, int len) {
		boolean result = false;
		for (int i=0; i < len; i++) {
			if (index[i] < lens[i]) {
				result = true;
				break;
			}
		}
		return result;
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
	
	private ListNode getMin(ListNode[] lns, int[] index) {
		int min = Integer.MAX_VALUE;
		int minIndex = 0;
		for (int i = 0; i < lns.length; i++) {
			if (lns[i] != null && min > lns[i].val) {
				minIndex = i;
				min = lns[i].val;
			}
		}
		ListNode result = lns[minIndex];
		lns[minIndex] = lns[minIndex].next;
		index[minIndex]++;
		return result;
	}
	
	public static void main(String[] args) {
		Question_23_2 question = new Question_23_2();
		ListNode ln1 = question.new ListNode(1);
		ListNode ln2 = question.new ListNode(2);
		ListNode ln3 = question.new ListNode(3);
		ListNode ln4 = question.new ListNode(4);
		ListNode ln5 = question.new ListNode(5);
		ln1.next = ln2;
		ln2.next = ln3;
		ln3.next = ln4;
		ln4.next = ln5;
		
		ListNode ln11 = question.new ListNode(1);
		ListNode ln15 = question.new ListNode(5);
		ListNode ln16 = question.new ListNode(6);
		ln11.next = ln15;
		ln15.next = ln16;
		
		ListNode[] listNodes = new ListNode[]{ln1, ln11};
		System.out.println("mergeKLists = " + new Question_23_2().mergeKLists(listNodes));
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
