# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        # idea: when we use two pointers, we can make it so the gap btwn them is exactly n
        # right pointer moves n steps ahead. then we move them together until the right one reaches
        # the end. hten the left node should be at n. -> good idea to reuse this distance formula :)
        dummy = ListNode(0, head) # use a dummy node to handle deleting first node
        left = dummy # one at dummy, one at head
        right = head

        while n > 0: # move right n steps, this creates a gap between left and right
        # that remains until right reaches the end
            right = right.next
            n -= 1

        while right: # move both until right reaches end
            left = left.next
            right = right.next

        left.next = left.next.next # we're right before the node we need to remove, so
        # we can just skip it to delete
        return dummy.next # safe head