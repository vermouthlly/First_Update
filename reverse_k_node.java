public class reverse_k_node {
    public static ListNode reverseKGroup(ListNode head, int k) {
        int len = 0;
        ListNode c = head;
        while(c != null) {
            len++;
            c = c.next;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int times = len / k;
        ListNode prev = dummy;
        ListNode tail = head;
        for(int i = 0; i < times; i++) {
            for(int j = 1; j < k; j++) {
                ListNode next = tail.next.next;
                tail.next.next = prev.next;
                prev.next = tail.next;
                tail.next = next;
            }
            
            prev = tail;
            tail = tail.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for(int i = 1; i <= 10; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        ListNode a = reverseKGroup(head, 3);
        while(a != null) {
            System.out.println(a.val);
            a = a.next;
        }
    }
}