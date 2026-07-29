"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:

    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':

        if not head:
            return None
        # we're going to use a dictionary to map every og node to its copy

        copyMap = {}
        curr = head

        while curr: # first pass, we create a copyof every node and store mapping
            copyMap[curr] = Node(curr.val)
            curr = curr.next
        
        for real, copy in copyMap.items(): # in our second copy, we go through our dictionary
            if real.next: # if given real.next, we find its copy via dictionary
                copy.next = copyMap[real.next]
            if real.random: # if given real.random, we find its copy via dictionary
                copy.random = copyMap[real.random]

        return copyMap[head] # return copy of head
