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

        if (head == null || k == 1)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroup = dummy;
        ListNode curr = head;

        while (curr != null) {

            // Find kth node (tail of current group)
            ListNode tail = curr;
            for (int i = 1; i < k && tail != null; i++) {
                tail = tail.next;
            }

            // Less than k nodes left
            if (tail == null)
                break;

            // Save next group's head
            ListNode nextGroup = tail.next;

            // Disconnect current group
            tail.next = null;

            // Reverse current group
            reverse(curr);

            // Reconnect
            prevGroup.next = tail;     // old tail becomes new head
            curr.next = nextGroup;     // old head becomes new tail

            // Move pointers
            prevGroup = curr;
            curr = nextGroup;
        }

        return dummy.next;
    }

    private void reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }
}
