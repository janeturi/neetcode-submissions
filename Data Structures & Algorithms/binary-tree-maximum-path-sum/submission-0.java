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
    public int maxPathSum(TreeNode root) {
        // given root of  binary tree, rturn the maximum path sum of
        // any non empty path
        // path does nto need to include root

        // we know that a path can start and end naywhere
        // but we also notice it needs to go downward at each step

        int[] res = new int[]{root.val};
        dfs(root, res);
        return res[0];

        // for every node, we compute:
        // max downward path starting at this node
        // max path through this node, which includes both the left
        // and right downward paths
    }

    private int dfs(TreeNode root, int[] res){
        if(root == null) return 0;
    // also make sure to drop all negatives +
    // update global max
        int leftMax = Math.max(dfs(root.left, res), 0);
        // compute the left subtree nodes, plus ignore negative downward paths
        int rightMax = Math.max(dfs(root.right, res), 0);
        // compute rihgt subtree nodes, plus ignore negative downward paths

        res[0] = Math.max(res[0], root.val + leftMax + rightMax);
        // update global result with the best path through the node
        return root.val + Math.max(leftMax, rightMax);
        // return the best downpard path 
    }
}
