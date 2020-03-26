/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * remove_nth_node
 */
public class remove_nth_node {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x ) {val = x;}
        
    }

    ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode front = dummy;
        ListNode back = dummy;
        for(int i = 0; i < n; i++) {
            back = back.next;
        }
        while(back.next != null) {
            back = back.next;
            front = front.next;
        }
        front.next = front.next.next;
        return dummy.next;
    }
}