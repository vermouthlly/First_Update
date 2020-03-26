/**
 * add_two_num
 */
public class add_two_num {

    // public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    //     ListNode index = new ListNode(0);
    //     ListNode x = l1;
    //     ListNode y = l2;
    //     ListNode z = index;
    //     ListNode p = new ListNode(0);
    //     int res_a = 0;
    //     int res_b = 0;
    //     int result;
    //     while(x != null) {
    //         res_a = res_a * 10 + x.val;
    //         x = x.next;
    //     }
    //     while(y != null) {
    //         res_b = res_b * 10 + y.val;
    //         y = y.next;
    //     }
    //     result = reverse(res_a) + reverse(res_b);
    //     while(result > 0) {
    //         ListNode temp = new ListNode(0);
         
    //         z.val = result % 10;
    //         result /= 10;
    //         z.next = temp;
    //         p = z;
    //         z = z.next;
    //     }
    //     p.next = null;
    //     return index;
    // }

    // public static int reverse(int x) {
    //     boolean neg;
    //     int tar = 0;
    //     if (x < 0) {
    //         neg = true;
    //         x = Math.abs(x);
    //     } else {
    //         neg = false;
    //     }
    //     while(x != 0) {
    //         int curr;
    //         int test = tar;
    //         curr = x % 10;
    //         tar = tar * 10 +  curr;
    //         x = x / 10;
    //         if((tar - curr) / 10 != test) {
    //             return 0;
    //         }
    //     }
    //     if(neg == true) {
    //         tar = 0 - tar;
    //         return tar;
    //     } else {
    //         return tar;
    //     }
    // }
}