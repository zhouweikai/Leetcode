package com.company;

import org.junit.jupiter.api.Test;

public class ReorderListTest {
	@Test
	public void testReorderList() {
		ReorderList.ListNode h1 = new ReorderList.ListNode(1);
		h1.next = new ReorderList.ListNode(2);
		h1.next.next = new ReorderList.ListNode(3);
		h1.next.next.next = new ReorderList.ListNode(4);
		ReorderList.ListNode cur = h1;
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
