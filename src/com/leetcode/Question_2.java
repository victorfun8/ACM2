package com.leetcode;

public class Question_2 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode ln = new ListNode(0);
		while (l1.next != null) {
			int increase1 = (l1.val + l2.val) / 10;
			ln.val = (l1.val + l2.val) % 10;
			
			if (l2.next != null) {
				
			} else {
				ln.next = l1.next;
			}
		}
		
		return parseInt2ListNode(result);
	}
	
	private ListNode addTwoNumbers(ListNode l1, ListNode l2, boolean increase1) {
		ListNode ln = new ListNode(0);
		while (l1.next != null) {
			int increase1 = (l1.val + l2.val) / 10;
			ln.val = (l1.val + l2.val) % 10;
			
			if (l2.next != null) {
				
			} else {
				ln.next = l1.next;
			}
		}
		
		return parseInt2ListNode(result);
	}

	private ListNode parseInt2ListNode(int result) {
		int temp = result / 10;
		if (temp > 0) {
			ListNode ln = new ListNode(result % 10);
			ln.next = parseInt2ListNode(temp);
			return ln;
		} else {
			return new ListNode(result % 10);
		}
	}

	public class ListNode {
    	int val;
        ListNode next;
   	    ListNode(int x) { val = x; }
    }
	
//	算法1：此算法当输入值超出int取值范围时，就会报NumberFormatException了
//  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//	int result = getListNodeNum(l1) + getListNodeNum(l2);
//	return parseInt2ListNode(result);
//}
//
//private ListNode parseInt2ListNode(int result) {
//	int temp = result / 10;
//	if (temp > 0) {
//		ListNode ln = new ListNode(result % 10);
//		ln.next = parseInt2ListNode(temp);
//		return ln;
//	} else {
//		return new ListNode(result % 10);
//	}
//}
//
//private int getListNodeNum(ListNode l1) {
//	if (l1.next == null) {
//		return l1.val;
//	} else {
//		return Integer.parseInt(getListNodeNum(l1.next) + "" + l1.val);    		
//	}
//}
}
