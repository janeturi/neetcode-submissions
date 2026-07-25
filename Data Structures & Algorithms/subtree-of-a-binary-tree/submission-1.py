# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:   
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool: # if trees are exact same
        if not subRoot: # empty subtrees = always subtree
            return True
        if not root: # non-empty root but empty subroot -> false
            return False

        if self.sameTree(root, subRoot): # if root and subroot are the same, return true
            return True
        return (self.isSubtree(root.left, subRoot) or self.isSubtree(root.right, subRoot)) # check on our left and rights 
    
    def sameTree(self, root: Optional[TreeNode], subRoot:Optional[TreeNode]) -> bool: # search for a subtree
        if not root and not subRoot:# if both null -> true
            return True 
        if root and subRoot and root.val == subRoot.val: # if both exist and the values are the same, we check the other children
            return (self.sameTree(root.left, subRoot.left) and self.sameTree(root.right, subRoot.right))
        return False # else, return false bc values differ
