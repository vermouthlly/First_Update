/**
 * merge_two_sorted_list
 */
public class merge_two_sorted_list {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x ) {val = x;}
        
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode i = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                i.next = l1;
                l1 = l1.next;
            }else {
                i.next = l2;
                l2 = l2.next;
            }
            i = i.next;
        }
        i.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}