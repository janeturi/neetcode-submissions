# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        # same logic as has duplicate? -> good but fast and slow pointers ar egood to know
        # for linked lists + smaller space complexity

        slow, fast = head, head # start both at head
        while fast and fast.next: # while fast doesnt reach end
            slow = slow.next # lsow moves once
            fast = fast.next.next # fast moves twice -> 
            if slow == fast: # if loop, then fast will eventually meet back at slow
                return True
        return False