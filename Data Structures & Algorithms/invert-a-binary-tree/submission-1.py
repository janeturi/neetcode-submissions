# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        # we're inverting our tree using a stack bc lifo so if we push everything onto the stack, we can
        # pop and return our tree backwards
        # we use dfs -> visit node -> swap l & r children, contineu process 
        if not root:
            return None # if empty return empty
        stack = [root] # initialize our stack with root
        while stack: # when not empty
            node = stack.pop() # pop our parent node to process
            node.left, node.right = node.right, node.left # swap
            if node.left: # whatever node exists, push to stack
                stack.append(node.left)
            if node.right:
                stack.append(node.right)
        return root