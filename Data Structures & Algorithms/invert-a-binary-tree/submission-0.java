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
    public TreeNode invertTree(TreeNode root) {
        // we're going to solve using a stacks

        // dfs goes through a tree fully before backtracking nad checking
        // the next subtree using a stack, which is different from bfs 
        // that does it level
        // by level and uses a queue
        if (root == null) return null;
        

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        // push everything onto stack until it's empty, so start with root
        // root doesn't change
        
        while(!stack.isEmpty()){
            TreeNode node = stack.pop(); // keeps node that we remove 
            // 'safe' so we can reference it again
            TreeNode temp = node.left;
            node.left = node.right;
            // swap left and right
            node.right = temp;
            // swap left and rightc
            if(node.left != null) stack.push(node.left);
            // push leftover left nodes
            if(node.right != null) stack.push(node.right);
            // push leftover right nodes
        }
        return root;
    }
}
