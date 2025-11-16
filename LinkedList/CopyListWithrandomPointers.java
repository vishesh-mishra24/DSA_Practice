/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        Node curr = head;

        // 1. Insert cloned nodes between original nodes
        while (curr != null) {
            Node currNext = curr.next;
            Node copy = new Node(curr.val);
            curr.next = copy;
            copy.next = currNext;
            curr = currNext;
        }

        // 2. Copy random pointers
        curr = head;
        while (curr != null && curr.next != null) {
            if (curr.random == null) {
                curr.next.random = null;
            } else {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // 3. Separate both lists
        Node newHead = head.next;
        Node newCurr = newHead;
        curr = head;

        while (curr != null && newCurr != null) {
            curr.next = curr.next != null ? curr.next.next : null;
            newCurr.next = newCurr.next != null ? newCurr.next.next : null;

            curr = curr.next;
            newCurr = newCurr.next;
        }

        return newHead;
    }
}
