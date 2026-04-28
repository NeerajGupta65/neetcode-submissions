class Solution {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode mid = mid(head);
        ListNode righthead = mid.next;
        mid.next = null;

        righthead = reverse(righthead);

        merge(head, righthead);
    }

    // find middle (your "mid")
    private ListNode mid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // reverse second half
    private ListNode reverse(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    // merge alternately (NOT sorted merge)
    private void merge(ListNode head1, ListNode head2) {

        while (head1 != null && head2 != null) {
            ListNode temp1 = head1.next;
            ListNode temp2 = head2.next;

            head1.next = head2;
            if (temp1 == null) break;

            head2.next = temp1;

            head1 = temp1;
            head2 = temp2;
        }
    }
}