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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // given a bst where all nodes are unique + two nodes from the trees
        // p and q, return the lowest common ancestor of the two nodes

        // lowest node in a tree such tha tboth p and q are descendents
        // ancestor is allowed to be a descendant of itself
        // so the closest node that is also the parent of the ndoe given


        TreeNode cur = root;

        while(cur != null){
            if (p.val > cur.val && q.val > cur.val){
                cur = cur.right;
                // if both p and q aare both greater than the current node,
                // move right
            } else if (p.val < cur.val && q.val < cur.val){
                cur = cur.left; // if they are both smaller, move left
            } else { // if they split, then the current node is the lca b/c
            // it is the first node where paths diverge
                return cur;
            }
        }
        return null;
    }
}
