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

public class Codec {
// serialization means to convert a structure into a seq of bits
// so it can be stored or sent across a network to be reconstructed later
// by a differet computer
    // Encodes a tree to a single string.

    /// we want to turn a tree into a string so that it can 
    // be decoded later

    // dfs uses root -> left -> right
    // null children are recorded via letter N
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();// store new string
        dfsSerialize(root, res); // recursvie call
        return String.join(",", res); // join list w commas
    }

    private void dfsSerialize(TreeNode node, List<String> res){
        if (node == null){ // if node is null, use 'n'
            res.add("N");
            return;
        }
        res.add(String.valueOf(node.val)); // add node value to string
        dfsSerialize(node.left, res); // traverse left
        dfsSerialize(node.right, res); // traverse right
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(","); // takes the string value apart
        // and splits it whenever theres a comma
        int[] i = {0};
        return dfsDeserialize(vals, i);  // traverses string w/o commas
    }

    private TreeNode dfsDeserialize(String[] vals, int[] i){
        if(vals[i[0]].equals("N")){
            i[0]++; // move foward
            return null; // replace N with null
        }
        TreeNode node = new TreeNode(Integer.parseInt(vals[i[0]]));
        // convers string into integer
        i[0]++; // move foward
        node.left = dfsDeserialize(vals, i); // left subtree
        node.right = dfsDeserialize(vals, i); // right subtree
        return node;
    }
}
