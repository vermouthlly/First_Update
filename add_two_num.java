/**
 * add_two_num
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class add_two_num {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = l1, q = l2, current = dummy;
        int carry = 0;

        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = (sum >= 10)? 1 : 0;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (carry == 1) {
            current.next = new ListNode(1);
        }

        return dummy.next;
    }

    public static ListNode rev(ListNode head) {
        if(head.next == null) {
            return head;
        }
        ListNode dummy = null;
        ListNode pre = dummy;
        ListNode current = head;
        ListNode temp = new ListNode(0);
        while(current != null) {
            temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }
        return pre;
    }

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode21 = new ListNode(2);
        ListNode listNode22 = new ListNode(3);
        ListNode listNode23 = new ListNode(4);
        listNode21.next = listNode22;
        listNode22.next = listNode23;

        ListNode result1 = addTwoNumbers(listNode1, listNode21);
        ListNode temp = rev(result1);
        while(temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}