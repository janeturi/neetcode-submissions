# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        # given head of a singly linked list, reorder the nodes to become
        # [0, n - 1, 1, n - 2, 2, n - 3, ...]
        # we notice that this does: one from front, one from back, one from front, one from back etc
        slow, fast = head, head.next # find middle of the slow and fast to figure out
        # which is our front and our back
        while fast and fast.next:# when fast reaches the end, slow will be at the middle
            slow = slow.next
            fast = fast.next.next

        # reverse scond half of the list to make it easy to merge nodes from front and back
        # just like in the zipper
        second = slow.next # starts after mid, 
        prev = slow.next = None # splits and severs the connection
        while second:
            tmp = second.next
            second.next = prev
            prev = second
            second = tmp

        # merge two halves one by one, using two pointers from the first half and from the second halff
        # so we make each go first -> second, then second -> first etc
        first, second = head, prev # current node at first half, current node in second half 
        while second: 
            tmp1, tmp2 = first.next, second.next # these all adjust pointers and stuff,
            first.next = second
            second.next = tmp1
            first, second = tmp1, tmp2 # but this moves to next node