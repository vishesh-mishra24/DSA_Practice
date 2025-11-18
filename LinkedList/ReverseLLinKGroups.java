/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = dummy;
        ListNode next = dummy;

        // Count the length of the list
        int length = 0;
        while (curr.next != null) {
            curr = curr.next;
            length++;
        }

        // Reverse in groups of k
        curr = prev.next;  // first node of each group
        while (length >= k) {

            curr = prev.next;
            next = curr.next;

            // Reverse k-1 links
            for (int i = 1; i < k; i++) {
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }

            prev = curr;
            length -= k;
        }

        return dummy.next;
    }
}
