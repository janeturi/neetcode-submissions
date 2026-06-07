/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
    // given a node in a connected undirected graph,
    // = graph with no directions, return a 
    // deep copy = independent graph structure where all nodes 
    // (vertices) and edges are distinct instances from the 
    // original graph.    
    // in other words, u want to create a copy of a graph 
    // problem: we cant just do: go to next node
    // bc it's an undirected graph, meaning we'll get stuck in a cycle

    Map<Node, Node> oldToNew = new HashMap<>();
    // store copies of old nodes in a hashmap
    // so if we run into a cycle, we return the copy instead 
    // so we aren't in an infinite loop
    return dfs(node, oldToNew); // start with first node and the empty hash
    }

    private Node dfs(Node node, Map<Node, Node> oldToNew){
        if(node == null) return null;// null check
        if(oldToNew.containsKey(node)) return oldToNew.get(node);
        // if we see a cycle, return the copy

        Node copy = new Node(node.val); // create a copy using
        // value of the thing if we haven't seen it b4
        oldToNew.put(node, copy); // add value

        for(Node n : node.neighbors){
            copy.neighbors.add(dfs(n, oldToNew)); 
            // use dfs to add all next pointers to a node to return
            // the graph
        }
        return copy;
    }
}