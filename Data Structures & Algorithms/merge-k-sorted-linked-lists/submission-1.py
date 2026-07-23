# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:    
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        # given an array of k linked list 'lists' where each list is the result of all the 
        # indiv linked lists
        # we can merge these together by going through them at once -> slow
        # can instead use a mergesort-like approach to merge pairs which would lead to a 
        # less comparisons being done bc of less lists to merge
        if not lists or len(lists) == 0: # if lists is empty return null bc nothing to merge
            return None
        
        while len(lists) > 1: # while we can still merge lists
            mergedLists = [] 
            for i in range(0, len(lists), 2): # loop over lists in steps of 2
                l1 = lists[i]
                l2 = lists[i + 1] if (i + 1) < len(lists) else None # make l2 if it exists 
                mergedLists.append(self.mergeList(l1, l2)) # append the merged lists using mergeList
            lists = mergedLists # now set our lists keyword to our mergedLists
        return lists[0] # our fully sorted lists!


    def mergeList(self, l1, l2): # our mergelist funcction
        dummy = ListNode() # our dummy node and our tail pointer to it 
        tail = dummy
        while l1 and l2: # while both are non empty
            if l1.val < l2.val: # whatever value is < goes next
                tail.next = l1
                l1 = l1.next
            else:
                tail.next = l2
                l2 = l2.next
            tail = tail.next # move to next node

        if l1: # attach remaining nodes
            tail.next = l1
        if l2:
            tail.next = l2

        return dummy.next # dummy.next is our merged head