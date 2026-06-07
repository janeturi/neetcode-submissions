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
    public ListNode mergeKLists(ListNode[] lists) {
        
// given an array of k number of linked lists lists, where each list is 
// sorted in ascending order
// we want to sort all linked lists into 1


// this method is putting two sorted lists into 1
    if(lists == null || lists.length == 0){
        return null; // null check
    }

    while(lists.length > 1){ // > 1 bc can't be =1
        List<ListNode> mergedLists = new ArrayList<>();
        for(int i = 0;i < lists.length; i += 2){ // move in steps\
        // of 2 because you merge both and so you each list will be like
        // (l1, l2) -> (l1, l2) -> etc
            ListNode l1 = lists[i]; 
            ListNode l2 = (i + 1) < lists.length ? lists[i+1] : null;
            // add l2 as long as it exists, if not, skip it

            mergedLists.add(mergeList(l1, l2)); // add pair
        }
        lists = mergedLists.toArray(new ListNode[0]); // returns list as 
        // array, of 'size' 0 to be dynamic
    }
    return lists[0]; // fully merged sorted list

    }
    // now actually sort the lists
    private ListNode mergeList(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(); // fake temp node to avoid messy code
        // from having to update head and stuff.
        ListNode tail = dummy;
        
        while(l1 != null && l2 != null){ // as long as there's still numbers

            if(l1.val < l2.val){
                // whatever's smaller, add to the tail
                tail.next = l1;
                l1 = l1.next; 
                // moves to the next in the list so it's not checked again
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
            // move to next
        }

        if (l1 != null){
            // if there exists remaining nodes
            tail.next = l1;
        }

        if (l2 != null) {
            // if there exists remaining nodes
            tail.next = l2;
        }
        return dummy.next;// skip over temp node 
        
    }
}
