class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0); 
        dummy.next = head;

        ListNode prev = dummy;   // prev points to last node before duplicates
        ListNode curr = head;    // current pointer

        while (curr != null) {
            // Move curr until end of duplicate sequence
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }

            // If prev.next == curr → no duplicates, move prev
            if (prev.next == curr) {
                prev = prev.next;
            } 
            // Else duplicates existed, skip entire block
            else {
                prev.next = curr.next;
            }

            curr = curr.next;  // move forward
        }

        return dummy.next;
    }
}
