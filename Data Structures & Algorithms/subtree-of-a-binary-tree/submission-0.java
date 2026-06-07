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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // given roots of two binary trees (root & subroot)
        // return true is there is a subtree of root with the same structure
        // and node values of subroot and false otherwise

        // a subtree of a binarytree tree is a tree that consits
        // of a node in tree and all of this node's descendants
        // tree tree could also be consdiered as a subtree of itself


        
        if(subRoot == null) return true; // subroot == null always true
        if(root == null) return false; // cant have subroots
        // null checks

        if(sameTree(root, subRoot)) return true; // return true w recursive calls
        // traverses the current node and see if it's a subtree

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot); // check both trees
        // if the node we're on isnt a subtree, 
    }

    public boolean sameTree(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null) return true; // both null == yes same tree

        if(root != null && subRoot != null && root.val == subRoot.val){
            return sameTree(root.left, subRoot.left) && sameTree(root.right, subRoot.right);
            // we have found a candidate, now check if the rest of the tree qualifies
        } // checks subtree's feautures b
        return false;
    }
}
