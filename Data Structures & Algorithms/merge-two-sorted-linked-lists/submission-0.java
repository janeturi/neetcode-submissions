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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // given heads of two sorted linked lists list1 and list2
        // we want to merge both into one sorted linked list and return
        // head of the new sorted linked list (will be merged w alt
        // vertices, like list 1 1, list 2 1, list 1 2, list 2 2 etc

        ListNode temp = new ListNode(0);
        ListNode node = temp;

        while(list1 != null && list2 != null){
            if (list1.val < list2.val){
                // chooses between smallest node to determine what 
                // goes in the merged list
                node.next = list1;
                // adds list 1 value to temp node
                list1 = list1.next;
                // moves value forward
            } else {
                node.next = list2; 
                // same logic as before
                list2 = list2.next;
            }
            node = node.next;
            // move on to add next node to temp
        }   

        if(list1 != null){
            // if we keep going and there's still extra nodes
            node.next = list1;
        } else {
            node.next = list2;
        }


        return temp.next;
    }
}