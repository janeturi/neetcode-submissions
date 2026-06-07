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
    public int diameterOfBinaryTree(TreeNode root) {
        // diameter of a binary tree is the length of longest path
        // between any two nodes within the tree, it does not have to pass
        // through the root

        // length == # of edges btwn nodes, path cannot include duplicate nodes

        // at some node, the path length is left subtree height + right subtree height
        int[] res = new int[1]; // res will store an int of size 1
        dfs(root, res); // use dfs method w root and res
        return res[0]; // return 
    }

    private int dfs(TreeNode root, int[] res){
        if (root == null) return 0; // null check

        int left = dfs(root.left, res); // recursively get left height (left + res which is null rn)
        int right = dfs(root.right, res); // recursively get right height
        res[0] = Math.max(res[0], left + right);
        // update diameter through node
        return 1 + Math.max(left, right); // return to parent
        // returns height 
    }
}
