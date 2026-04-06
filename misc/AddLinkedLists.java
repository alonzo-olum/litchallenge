
class LinkedLists {
	public static LinkedNode addTwoLinkedNodes
		(
			LinkedNode l1,
			LinkedNode l2
			) {
			LinkedNode dummyhead = new LinkedNode(0);
			LinkedNode p = l1, q = l2, curr = dummyhead;
			int carry = 0;
			while (p!=null || q != null) {
				int x = p != null ? p.value : 0;
				int y = q != null ? q.value : 0;
				int sum = x + y + carry;
				carry = sum/10;
				curr.next = new LinkedNode(sum % 10);
				curr = curr.next;
				if (p != null) { p = p.next; }
				if (q != null) { q = q.next; }
			}
			if (carry > 0) {
				curr.next = new LinkedNode(carry);
			}

			return dummyhead.next;
	}

	private static class LinkedNode {
		int value;
		LinkedNode next;
		LinkedNode(int value) {
			this.value = value;
		}
	}
}
