package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class ReorderListTest {
	@Test
	public void testReorderList() {
		// Arrange
		ReorderList.ListNode h1 = new ReorderList.ListNode(1);
		h1.next = new ReorderList.ListNode(2);
		h1.next.next = new ReorderList.ListNode(3);
		h1.next.next.next = new ReorderList.ListNode(4);

		ReorderList lc = new ReorderList();

		// Act
		lc.reorderList(h1);

		// Assert
		ReorderList.ListNode cur = h1;
		assertEquals(1, cur.val);
		cur = cur.next;
		assertEquals(4, cur.val);
		cur = cur.next;
		assertEquals(2, cur.val);
		cur = cur.next;
		assertEquals(3, cur.val);
	}
}
