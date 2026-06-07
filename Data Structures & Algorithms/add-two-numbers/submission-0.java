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
        // given two non-empty linked lists, l1 and l2
        // each represents a non negative integer

        // digits are stored in reverse order
        // each node has 1 digit 
        // return sum fo the two numbers as a linked list


        // linked list stores numbers in reverse order, so first nodes
        // represent the 1s place
        // so we can add two digits,
        // add the carry 
        // save the resulting digit (sum % 10) into a new node
        // update the carry (sum / 10)
        // move both pointer sforward


        ListNode dummy = new ListNode();
        // to build answer
        ListNode cur = dummy; // pointer

        int carry = 0; // current number we're carrying

        while (l1 != null || l2 != null || carry != 0){
            int v1 = (l1 != null) ? l1.val : 0;
            // read & save
            // current digit of l1, return 0 if the list is over
            int v2 = (l2 != null) ? l2.val : 0;
            // read and save current digit of l2, 
            // return 0 if the list is over


            int val = v1 + v2 + carry;
            // val will be regular addition
            carry = val / 10;
            // carry = val / 10, which isolates the last digit
            // and returns everything BUT the last digit
            // this is bc when you carry stuff, you're carrying the 1
            // like in 15, u carry 1 and leave 5
            val = val % 10;
            // val % 10 gives last digit, aka remainder
            cur.next = new ListNode(val);
            // update linkedlist we made w the remainder

            cur = cur.next; // move to next number
            l1 = (l1 != null) ? l1.next : null;
            // move to next digit or null if it's empty
            l2 = (l2 != null) ? l2.next : null;
        }
        return dummy.next; // head of result list
    }
}
