package com.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author fangji
 * 
 * 题目：https://leetcode-cn.com/problems/merge-k-sorted-lists/description/
 * 
 * 解题思路：两两比较，能得出正确结论，但是效率低，这个实现方案不能通过时间限制
 * 
 * 参考资料：
 * 	
 */
public class Question_23 {
	
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0)
        	return null;
		if (lists.length == 1)
        	return lists[0];
        
        return containListNodes(lists);
    }
	
	private ListNode containListNodes(ListNode[] lns) {
		ListNode temp = lns[0];
		for (int i = 1; i < lns.length; i++) {
			temp = contain2ListNode(temp, lns[i]);
		}
		return temp;
	}
	
	private ListNode contain2ListNode(ListNode ln1, ListNode ln2) {
		if (ln1 == null && ln2 == null) {
			return null;
		}
		if (ln1 == null) {
			return ln2;			
		}
		if (ln2 == null) {
			return ln1;			
		}
		
		int index1 = 0, index2 = 0;
		
		ListNode result = null;

		List<ListNode> list1 = getListNodeList(ln1);
		List<ListNode> list2 = getListNodeList(ln2);
		int len1 = list1.size();
		int len2 = list2.size();
		while (index1 <= len1 || index2 <= len2) {
			if (index1 == len1) {
				if (index1 == 0 && index2 == 0) {
					result = ln2;
				} else {					
					get(result, index1 + index2, index1 + index2 - 1).next = list2.get(index2);					
				}
				break;
			} else if (index2 == len2) {
				if (index1 == 0 && index2 == 0) {
					result = ln1;
				} else {
					get(result, index1 + index2, index1 + index2 - 1).next = list1.get(index1);					
				}
				break;
			} else if (list1.get(index1).val <= list2.get(index2).val) {
				if (index1 == 0 && index2 == 0) {
					result = list1.get(index1);
				} else {
					get(result, index1 + index2, index1 + index2 - 1).next = list1.get(index1);
				}
				index1++;
			} else {
				if (index1 == 0 && index2 == 0) {
					result = list2.get(index2);
				} else {
					get(result, index1 + index2, index1 + index2 - 1).next = list2.get(index2);
				}
				index2++;
			}
		}
		return result;
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
	
	
	private List<ListNode> getListNodeList(ListNode ln) {
		List<ListNode> list = new LinkedList<ListNode>();
		ListNode temp = ln;
		while (temp.next != null) {
			list.add(temp);
			temp = temp.next;
		}
		list.add(temp);
		return list;
	}
	
	public static void main(String[] args) {
		Question_23 question = new Question_23();
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
		System.out.println("mergeKLists = " + new Question_23().mergeKLists(listNodes));
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
