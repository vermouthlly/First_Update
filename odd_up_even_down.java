/**
 * odd_up_even_down
 */
public class odd_up_even_down {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode ou(ListNode head) {
        if(head.next == null) {
            return head;
        }
        ListNode current_odd = head;
        ListNode current_even = head.next;
        ListNode temp;

        while(current_odd.next != null && current_odd != null) {
            temp = current_odd.next.next;
            current_odd.next = temp;
            // System.out.println(current_odd.val);
            if(current_odd != null) 
                current_odd = current_odd.next;
        }
        if(current_odd != null) {
            current_odd.next = null;
        }

        while(current_even.next != null && current_even != null) {
            temp = current_even.next.next;
            current_even.next = temp;
            System.out.println(current_even.val);
            if(current_even != null) 
                current_even = current_even.next;
            
        }

        if(current_even != null) {
            current_even.next = null;
        }

        ListNode s = head;
        // while(s != null) {
        //     System.out.println(s.val);
        //     s = s.next;
        // }

        return merge(current_odd, current_even);
    }

    public static ListNode merge(ListNode odd, ListNode even) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while(odd != null && even != null) {
            if(odd.val <= even.val) {
                current.next = odd;
                odd = odd.next;
            }else {
                current.next = even;
                even = even.next;
            }
            current = current.next;
        }
        current.next = (odd != null) ? odd : even;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(8);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(6);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(4);
        ListNode g = new ListNode(7);
        ListNode h = new ListNode(2);
        ListNode i = new ListNode(9);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;
        h.next = i;
        i.next = null;
        ListNode ss = ou(a);
        ListNode s = ss;
        // while(s != null) {
        //     System.out.println(s.val);
        //     s = s.next;
        // }
    }
}