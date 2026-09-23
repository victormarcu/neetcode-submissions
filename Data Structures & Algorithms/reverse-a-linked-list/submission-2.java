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
        Deque<ListNode> stack = new ArrayDeque<>();
        while(head.next != null) {
            stack.push(head);
            head = head.next;
        }

        head.next = stack.peek();
        while (!stack.isEmpty()) {
            stack.pop().next = stack.peek();
        }
        return head;
    }
}
