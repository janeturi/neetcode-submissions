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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // need to return if two trees are equivalent
        // two trees are equivalent if they
        // 1. share same structure (height == height)
        // 2. nodes share the same values 

        if(p == null && q == null) return true; // if both true, yes

        if(p != null && q!= null && p.val == q.val){
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            // will return either true or false depending on 
        } else {
            return false;
        }
    }
}
