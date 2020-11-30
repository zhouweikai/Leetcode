package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class L143Test {
	@Test
	public void testReorderList() {
		// Arrange
		L143.ListNode h1 = new L143.ListNode(1);
		h1.next = new L143.ListNode(2);
		h1.next.next = new L143.ListNode(3);
		h1.next.next.next = new L143.ListNode(4);

		L143 lc = new L143();

		// Act
		lc.reorderList(h1);

		// Assert
		L143.ListNode cur = h1;
		assertEquals(1, cur.val);
		cur = cur.next;
		assertEquals(4, cur.val);
		cur = cur.next;
		assertEquals(2, cur.val);
		cur = cur.next;
		assertEquals(3, cur.val);
	}
}
