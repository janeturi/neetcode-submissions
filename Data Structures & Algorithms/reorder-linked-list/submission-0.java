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
        // goal is to reorder list of nodes as:
        // L1 -> Ln -> L2 -> L(n - 1) -> L3 -> L(n - 2)
        // break problem down into:
        // 1. find mid using slow & fast pointers to split list into halves
        // 2. reverse second half 
        // 3. merge two halves one by one

        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // middle is found when fast is at the end and slow is at half

        // reverse 2nd half
        ListNode second = slow.next;
        ListNode prev = slow.next = null;
        while(second != null){
            ListNode tmp = second.next;
            second.next = prev;
            prev = second;
            second = tmp;
        }
        // reverse list by changing everything like normal
        // prev -> second -> second.next
        // prev <- second <- second.next
        // second.next -> second -> prev

        ListNode first = head;
        second = prev;
        while(second != null){
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
        // merge two lists together
        // take node from first half, then take node from reversed 
        // 2nd half, then continue
    }
}
