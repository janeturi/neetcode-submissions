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
    public boolean hasCycle(ListNode head) {
        // given the beginning of a linked list head, return true
        // if there is a cycle in the linked list

        // cycles are in a linked list if at least one node in the list
        // can be visited again by the following next pointer
        ListNode fast = head;
        ListNode slow = head;
        // ok somehow someway, the fast one is going to eventually run
        // be at the same node as the slow.
        // like if someone ran 2 miles around a track per min and the 
        // other ran 1 mile, then the fast would eventually have to run
        // past the other
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }
}
