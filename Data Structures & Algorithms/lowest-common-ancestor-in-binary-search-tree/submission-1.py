# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def lowestCommonAncestor(self, root: TreeNode, p: TreeNode, q: TreeNode) -> TreeNode:
        # idea was to just return previous until they match up, but tree pchildren
        # dont point to their parent nodes

        # bc bsts are ordered, we can deckded where they are by comparing value
        # if they split 
        # so if theyre both smaller than our current root, we move down to the next node on the lefft
        # and vice versa
        # but if one is smaller and one is bigger than our root, then we found the split!
        while root:
            if p.val > root.val and q.val > root.val: # both bigger, move to right
                root = root.right
            elif p.val < root.val and q.val < root.val:
                root = root.left
            else: # else they are different
                return root