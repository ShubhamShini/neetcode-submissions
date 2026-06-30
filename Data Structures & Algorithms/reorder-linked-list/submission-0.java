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
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null) {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!= null && fast.next!= null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow;
        slow = reverseList(slow.next);
        fast.next = null;
        fast = head;
        ListNode temp = fast.next;
        while(slow!=null) {
            fast.next = slow;
            fast = temp;
            temp = slow.next;
            slow.next = fast;
            slow = temp;
            temp = fast.next;
        }
        
    }
    
}
