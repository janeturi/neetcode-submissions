# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        # res = max left height + max right height
        # diameter = length of the longest path btwn two nodes without including the same node twice
        # we use a nested function bc we need to be able to calculate max height and depth
        # + 
        res = 0

        def dfs(root): # recursive call for simplicity
            nonlocal res # refer to the prev res in outer funct

            if not root: # if empty
                return 0

            left = dfs(root.left) # find max height for l, r, and update res
            right = dfs(root.right)
            res = max(res, left + right)
        
            return 1 + max(left, right) # return height 
        dfs(root) 
        return res