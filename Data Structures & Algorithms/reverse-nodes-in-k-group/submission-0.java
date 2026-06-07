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
    public ListNode reverseKGroup(ListNode head, int k) {
        // given head of a singly linked lists and int k
        // reverse the first k nodes in the linked lists
        // then reverse the next k noes and so on
        // if there are less than k nodes left, leave nodes as is

        // only able to modify the nodes' next pointers, not values


        
        ListNode dummy = new ListNode(0, head); // simplify edge cases

        ListNode groupPrev = dummy; // node right before the group we're
        // going to reverse

        while(true){
            ListNode kth = getKth(groupPrev, k);
            // we want to find the k-th node from the group's prev node
            // so kth walks k steps forward after the group we're going
            // to reverse


            if(kth == null){ // if there aren't any k nodes left, stop
                break;
            }

            ListNode groupNext = kth.next; // first node after current group

            ListNode prev = kth.next; // reversed group should eventually point
            // to k, will change and become less than each loop
            ListNode curr = groupPrev.next; // first node in current group
            // also for reversal portion
            while(curr != groupNext){ // while curr is not a dupe
                // reverse current group
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }
            // reconnect everything
            ListNode tmp = groupPrev.next; // old head, now tail
            
            groupPrev.next = kth;  // groupPrev -> new head of group
            // start of next group
            groupPrev = tmp; 
            // tail of last group
        }
        return dummy.next;
    }

    private ListNode getKth(ListNode curr, int k){
        while(curr != null && k > 0){
            // move curr forward, remove from k
            curr = curr.next;
            k--;
        }
        return curr;
    }
}
