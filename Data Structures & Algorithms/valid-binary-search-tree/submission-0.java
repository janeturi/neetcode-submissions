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

 // we want to make sure that every node must fit within
 // a valid value range decided by its anestors
 // for the left, node must be less than the parent- which decreases upper
 // bound

 // for the right, the node must be greater, so the lower bound becomes
 // larger (min needed goes up)

class Solution {
    public boolean isValidBST(TreeNode root) {
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
        // start w root and inf neg and inf pos
    }

    public boolean valid(TreeNode node, long left, long right){
        if(node == null) return true; // null check

        if(!(left < node.val && node.val < right)) return false;
        // nodes on left need to be less than, nodes on right need to be greater

        return valid(node.left, left, node.val) && valid(node.right, node.val, right);
        // traverse left and traverse right
    }
}
