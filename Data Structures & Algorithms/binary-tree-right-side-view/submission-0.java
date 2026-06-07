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
    List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        // i want to return th evalues that are visible from the 
        // right side of the tree

        // in dfs, we visit the right child first then the
        // left child
        dfs(root, 0); // initialize at depth 0 bc we're at the
        // beginning
        return res; 
    }

    private void dfs(TreeNode node, int depth){
        if(node == null) return; // null check

        if(res.size() == depth) res.add(node.val);
        // the first node at this depth, append the value to res
        // current level in tree + nodes alr added
        // if (res.size() == depth), since we add right first,
        // then that means its the left node being processed
        // so it's not appended
        

        dfs(node.right, depth + 1); // make it so we visit 
        // right child first
        dfs(node.left, depth + 1);
    }
}
