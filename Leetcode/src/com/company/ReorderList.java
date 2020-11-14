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
public class ReorderList {
	public void reorderList(ListNode head) {
		if (head == null || head.next == null ||
				head.next.next == null) {
			return;
		}
		ListNode slow = head, fast = head;
		findMid(slow, fast);
		if (fast != null) {
			slow = slow.next;
		}
		// reaching here, slow Pointer is the head
		// second half list
		ListNode tail = head;
		while (tail.next != slow) {
			tail = tail.next;
		}
		tail.next = null;
		ListNode secHead = reverse(slow);
		merge(head, secHead);
	}

	private void findMid(ListNode slow, ListNode fast) {
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
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
		ListNode one = h1;
		while (one != null) {
			System.out.println(one.val);
			one = one.next;
		}
		System.out.println("-----------");
		ListNode two = h2;
		while (two != null) {
			System.out.println(two.val);
			two = two.next;
		}
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		ListNode cur1 = h1;
		ListNode cur2 = h2;
		if (cur1 == null && cur2 == null) {
			return;
		}
		while (cur1 != null && cur2 != null) {
			cur.next = cur1;
			cur1 = cur1.next;
			cur.next.next = cur2;
			cur2 = cur2.next;
			cur = cur.next.next;
		}
		if (cur1 != null) {
			cur.next = cur1;
		}
		h1 = dummy.next;
	}

	public static class ListNode {
	   int val;
	   ListNode next;
	   ListNode(int x) { val = x; }
	}

	public static void main(String[] args) {
		ListNode h1 = new ListNode(1);
		h1.next = new ListNode(2);
		h1.next.next = new ListNode(3);
		h1.next.next.next = new ListNode(4);
		ListNode cur = h1;
		while (cur != null) {
			System.out.println(cur.val);
			cur = cur.next;
		}
		ReorderList lc = new ReorderList();
		lc.reorderList(h1);
		while (h1 != null) {
			System.out.println(h1.val);
			h1 = h1.next;
		}
	}
}
