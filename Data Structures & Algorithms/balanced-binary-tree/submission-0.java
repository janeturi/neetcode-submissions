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
    public boolean isBalanced(TreeNode root) {
        return dfs(root)[0] == 1;
    }
    // one dfs returns this for every node
    // 1. is the subtree balanced? y/n?
    // 2. what is the height?

    // this makes it so that if something is unbalanced, aka
    // {0, x}, we can go ahead and stop worrying about going further
    // down the tree
    

    private int[] dfs(TreeNode root){
        if (root == null) return new int[]{1, 0};
        // return true for balanced,0 for height 
        

        int[] left = dfs(root.left); // get results from left children
        int[] right = dfs(root.right); // get results from right children

        boolean balanced = (left[0] == 1 && right[0] == 1) &&
        (Math.abs(left[1] - right[1]) <= 1);
        // checks if balanced &
        // height difference <= 1

        int height = 1 + Math.max(left[1], right[1]);
        // height of current node

        return new int[]{balanced ? 1 : 0, height};
        // returns whether balanced or not and updates height
    }
}
