class Solution {
    public boolean validTree(int n, int[][] edges) {
        // undirected tree, write to check whether
        // edges make up a valid tree

        // tree is not valid if there's a cycle

        // so if we detect a cycle, it's invalid

        if(edges.length > n - 1) return false; 
        // a tree with n nodes must have exactly n-1 edges

        List<List<Integer>> adj = new ArrayList<>();
        // put adjacent nodes together
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
            // connect edges together
        }

        Set<Integer> visit = new HashSet<>(); // set of visited nodes
        if(!dfs(0, -1, visit, adj)) return false;
        // run dfs + if it fails, returns false

        return visit.size() == n;
        // last check, that every node is used
    }

    private boolean dfs(int node, int parent, Set<Integer> visit, List<List<Integer>> adj){
        if(visit.contains(node)) return false; // if
        // we've alr visited a node

        visit.add(node); // add node when visited

        for(int nei : adj.get(node)){
            if(nei == parent) continue; // if neighbor is parent
            // continue to avoid false cycle detection

            if(!dfs(nei, node, visit, adj)) return false;
            // if fails dfs from next node
        }

        return true;
    }
}
