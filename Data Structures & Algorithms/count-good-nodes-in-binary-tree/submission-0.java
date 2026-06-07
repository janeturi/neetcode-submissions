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
    public int goodNodes(TreeNode root) {
        // a node is considered good if the path from the root
        // to the node x contains no nodes with a value
        // greater than  or equal tothe value of node x

        // given a root, return the number of good nodes within
        // the tree
        return dfs(root, root.val); // start at root, maxValue takes
        // the current root's value
    }

    private int dfs(TreeNode node, int maxVal){
        if(node == null) return 0;

        int res = (node.val >= maxVal) ? 1 : 0;
        // initialize result w either 1 or 0 if nodeValue is greater htan or
        // equal to maxVal each recursive call
        maxVal = Math.max(maxVal, node.val); 
        res += dfs(node.left, maxVal);
        // traverse left side, use updated maxVal to add onto and update res
        res += dfs(node.right, maxVal);
        // traverse right side, use updated maxVal to add onto and update res
        return res; 
    }
}
