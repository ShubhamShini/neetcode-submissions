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
        if(head == null) return head;

        Node temp = head;
        while(temp != null) {
            Node nxt = temp.next;
            temp.next = new Node(temp.val);
            temp.next.next = nxt;
            temp = nxt;
        }

        temp = head;
        while(temp != null) {
            Node nxt = temp.next;
            if(temp.random != null)
                nxt.random = temp.random.next;
            temp = nxt.next;
        }

        temp = head;
        head = head.next;
        Node nxt = head;
        while(temp != null) {
            temp.next = nxt.next;
            temp = temp.next;

            if(temp!=null) {
                nxt.next = temp.next;
                nxt = nxt.next;
            }
        }
        return head;
    }
}
