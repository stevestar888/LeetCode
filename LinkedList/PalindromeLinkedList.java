/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * Utilize stack to store the first half of nodes and check if those match with the second half
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        
        ListNode fast = head;
        ListNode slow = head;
        Stack<Integer> sta = new Stack();
        
        while (fast != null && fast.next != null) {
            sta.push(slow.val);
            
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if (fast != null) {
            sta.push(slow.val);
        }
        
        while (slow != null) {
            if (sta.pop() != slow.val) 
                return false;
            slow = slow.next;
        }
        
        return true;
    }
}