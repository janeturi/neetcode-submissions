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
    public int maxDepth(TreeNode root) {
        // we'll use a queue to solve this to avoid recursion, just bc
        // recursion can get weird and also i dont wanna

        // bfs processes one entire level of a tree, so for as long as there's
        // a level, the longest length increases each time
        Queue<TreeNode> q = new LinkedList<>();

        if(root != null) q.add(root); // account for root, add to queue 

        int level = 0;

        while (!q.isEmpty()){

            int size = q.size(); // updates each loop

            for(int i = 0; i < size; i++){
                // process all size nodes
                TreeNode node = q.poll(); // keep track of removed nodes
                if(node.left != null){
                    q.add(node.left);
                    // push left children if they exist
                } if (node.right != null){
                    q.add(node.right);
                    // push right children if they exist
                }
            }
            level++; // each level, increment level
        }
        return level; // return level when queue is empty
    }
}
