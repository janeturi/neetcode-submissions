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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // return the level order traversal as a nested list
        // where each sublist contains the values of nodes at a particular
        // levle in the tree from left to 

        // intuition tells me use bfs
        
        List<List<Integer>> res = new ArrayList<>();
        // result array
        
        Queue<TreeNode> q = new LinkedList<>(); // queue cuz bfs
        q.add(root); // add root


        if(root == null) return res;

        while(!q.isEmpty()){ // return the empty list if the tree is empty
            
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < size; i++){ // since queue is dynamic and based on
            // whats been processed and what hasnt
                TreeNode node = q.poll(); // preserve removed node
                level.add(node.val); // add node to level
                    // bc there's a parent node aka new list thingg there
                if(node != null){
                    if(node.left != null) q.add(node.left); // then push its left and right children
                    if(node.right != null) q.add(node.right);
                }
            }
            res.add(level);
           
        }
        return res;
    }
}
