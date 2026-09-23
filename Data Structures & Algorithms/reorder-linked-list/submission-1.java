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
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow is now at HALF distance because fast reached the end twice as fast.
        // e.g. it represents the half node which links all the way to the end.

        // reverse second half and store the reference to its starting node in first
        ListNode second = reverseList(slow);
        slow.next = null;

        // Merge the two halves
        // keep the reference to the starting node in the `first` var
        // head node remains unchanged
        ListNode first = head;
        while (first != null && second != null) {
            // tmp1 and tmp2 store the lists starting from the second node
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;

            // make "first-half" (which started as head) point to the other array
            // this is basically equivalent to adding the top reversed element to the result
            // then, as second comes to store the first half, we're adding the next element from the first half
            first.next = second;
            // make "reversed-half" now point to the first half 
            second.next = tmp1;

            // now that we've played with first nodes, remove them and reset from next positions
            first = tmp1;
            second = tmp2;
        }
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
