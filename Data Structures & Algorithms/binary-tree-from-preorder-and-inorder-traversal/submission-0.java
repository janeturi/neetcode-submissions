/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int preIdx = 0; // what node to make next
    // when we finished a subtree
    int inIdx = 0; // when we finished a subtree

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // preorder, root left right
        // inorder left root right

        // the first element of preorder → this is the root.
        // Find that value in inorder.
        // Everything left of it in inorder = left subtree.
        // Everything right of it in inorder = right subtree.
        //The number of elements on the left tells you how many nodes
        //  belong to the left subtree in preorder.
        return dfs(preorder, inorder, Integer.MAX_VALUE);
        
    }

    private TreeNode dfs(int[] preorder, int[] inorder, int limit){
        if(preIdx >= preorder.length) return null; // no nodes
        // in this level of tree

        if(inorder[inIdx] == limit){ // reached end of subtree
            inIdx++; 
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIdx++]); 
        // traverses preorder, which basically in a way tells us 
        // the root or starting node of everything
        root.left = dfs(preorder, inorder, root.val);
        // biild left subtree, nodes less than root appear before it in 
        // inorder
        root.right = dfs(preorder, inorder, limit);
        // build right w og limit
        return root;
    }
}
