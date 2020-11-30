package com.company;

/**
 * https://leetcode.com/problems/reorder-list/
 *
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You may not modify the values in the list's nodes,
 * only nodes itself may be changed.
 */
public class L143 {
	public void reorderList(ListNode head) {
		if (head == null || head.next == null ||
				head.next.next == null) {
			return;
		}
		// find middle point
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode tail = head;
		while (tail.next != slow) {
			tail = tail.next;
		}
		tail.next = null;
		ListNode secHead = reverse(slow);
		merge(head, secHead);
	}

	private ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = null;
		ListNode cur = head;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}

	private void merge(ListNode h1, ListNode h2) {
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		ListNode cur1 = h1;
		ListNode cur2 = h2;
		while (cur1 != null && cur2 != null) {
			cur.next = cur1;
			cur1 = cur1.next;
			cur.next.next = cur2;
			cur2 = cur2.next;
			cur = cur.next.next;
		}
		if (cur2 != null) {
			cur.next = cur2;
		}
		h1 = dummy.next;
	}

	public static class ListNode {
	   int val;
	   ListNode next;
	   ListNode(int x) { val = x; }
	}
}
