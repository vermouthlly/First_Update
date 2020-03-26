
/**
 * swap_nodes
 */
public class swap_nodes {

    public class ListNode {
             int val;
             ListNode next;
             ListNode(int x) { val = x; }
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head.next;
        ListNode current = head;
        ListNode previous = new ListNode(0);
        ListNode next_node = null;
        while(current != null) {
            next_node = current.next;
            if(next_node != null) {
                current.next = next_node.next;
                next_node.next = current;
                previous.next = next_node;
                previous = current;
                current = current.next;
            }else {
                current = current.next;
            }
            
        }
        return dummy.next;
    }
}