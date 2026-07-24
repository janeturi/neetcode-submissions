# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        # a binary tree is defined as a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
        # so just check ifleft and right heights are diff by no more than 1

        def getHeight(node):
            if not node: # empty tree
                return 0
            
            left = getHeight(node.left) # get heights
            right = getHeight(node.right)

            if left == -1 or right == -1: # check if subtrees are unbalanced from our abs(right - left) , we look at all the bottom nodes to see if we have already
            # found a prev unbalance
                return -1

            if abs(left - right) > 1: # if height diff > 1, unbalanced tree, finds new unbalances
                return -1

            return 1 + max(left, right) # otherwise, return height of node
        return getHeight(root) != -1 # returns -1 if unbalanaced