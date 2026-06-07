class Solution {
    public int countComponents(int n, int[][] edges) {
        // given graph of n nodes
        // given int n
        // given array edges where edges gives 2 pts
        // indiciating an edge btwn and a and b
        // return numb of connected components

        // my first intuition was to count the number of pairs
        // in edges, but it doesnt work bc we aren't
        // meant to return all 
        // edges, rather num of connected groups

        List<List<Integer>> adj = new ArrayList<>();
        boolean[] visit = new boolean[n];

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int res = 0;
        for (int node = 0; node < n; node++){
            if(!visit[node]){
                dfs(adj, visit, node);
                res++;
            }
        }
        return res;
    }

    private void dfs(List<List<Integer>> adj, boolean[] visit, int node){
        visit[node] = true;
        for(int nei : adj.get(node)){
            if (!visit[nei]){
                dfs(adj, visit, nei);
            }
        }
    }
}
