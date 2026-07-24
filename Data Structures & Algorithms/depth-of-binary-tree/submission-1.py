# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        stack = [[root, 1]] # pair where 2nd represents a depth of 1
        res = 0

        while stack:
            node, depth = stack.pop() # pop our node depth from our stack

            if node:
                res = max(res, depth) # update
                stack.append([node.left, depth + 1]) # push left if exists
                stack.append([node.right, depth +1]) # push right if it exists
        return res # when our stack is empty, return maxDepth