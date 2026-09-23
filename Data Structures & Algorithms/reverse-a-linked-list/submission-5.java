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
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode dummy = head;
        ListNode prev = null;
        // [0 -> [1] -> [2] -> null];
        // [null <- [0] <- [1]]
        while (dummy != null) {
            System.out.println("dummy is: " + dummy.val);
            ListNode next = dummy.next;
            dummy.next = prev;
            System.out.println("dummy is now pointing towards: " + (prev != null ? prev.val : "null"));
            prev = dummy;
            dummy = next;
            System.out.println("dummy moved right to: " + (dummy != null ? dummy.val : "null"));
            System.out.println("\n--------------------------");
        } 
        return prev;
    }
}
