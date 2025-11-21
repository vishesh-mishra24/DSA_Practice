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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // 1. Count length
        ListNode curr = head;
        int len = 1;
        while (curr.next != null) {
            curr = curr.next;
            len++;
        }

        // 2. Make it circular
        curr.next = head;

        // 3. k may be larger than len
        k = k % len;

        // 4. Find new tail: (len - k - 1)
        int stepsToNewTail = len - k - 1;
        ListNode newTail = head;

        for (int i = 0; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        // 5. New head is next of newTail
        ListNode newHead = newTail.next;

        // 6. Break circle
        newTail.next = null;

        return newHead;
    }
}
