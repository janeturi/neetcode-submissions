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
    public int kthSmallest(TreeNode root, int k) {
        // we want to return the k smallest integer
        // in. abinary tree

        Stack<TreeNode> stack = new Stack<>();
        // we'll use a stack to put first the left binary tree
        // in a stack
        // that way we will continously pop all elements
        // until we get to to the top node, k. if
        // k isn't in the left part, we push the right side
        // and do the k stuff still
        TreeNode curr = root;

        while(!stack.isEmpty() || curr != null){
            while(curr != null){
                stack.push(curr); // push curr 
                curr = curr.left; // change curr to curr.left
                // to push all of left
            }
            curr = stack.pop(); // to keep track of removed nodes
            k--; // decrement k each time we pop from stack
            if(k == 0){
                return curr.val; // if k == 0, we found our val
            }
            curr = curr.right; // otherwise, push the rest of the tree
        }
        return -1;
    }
}
