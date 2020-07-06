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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode head = ans;
        int carry = 0;
        
        while (l1 != null && l2 != null) {
            int sum = l1.val+l2.val+carry;
            carry = 0;
            if (sum >= 10) {
                sum = sum-10;
                carry = 1;
            }
            ListNode s = new ListNode(sum);
            ans.next = s;
            ans = ans.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        if (l1 == null) {
            while (l2 != null) {
                int sum = l2.val + carry;
                carry = 0;
                if (sum >= 10) {
                    sum -= 10;
                    carry = 1;
                }
                ListNode s = new ListNode(sum);
                l2 = l2.next;
                ans.next = s;
                ans = ans.next;
            }
        }
        
        if (l2 == null) {
            while (l1 != null) {
                int sum = l1.val + carry;
                carry = 0;
                if (sum >= 10) {
                    sum -= 10;
                    carry = 1;
                }
                ListNode s = new ListNode(sum);
                l1 = l1.next;
                ans.next = s;
                ans = ans.next;
            }
        }
        
        if (carry == 1) 
            ans.next = new ListNode(1);
            
        return head.next;
    }
    
}