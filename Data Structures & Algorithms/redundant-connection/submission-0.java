class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        /* given connected undirected graph with n nodes
        labeled from 1 to 9, initially w/o cycles and n-1 edges
        
        one edge is added onto the graph with two different
        vertices chosen from 1 to n and was not an edge
        that previously existed

        return an edge that can be removed so that the graph
        is still a connected non cyclical graph
        */
        // all next builds adjacency list
        int n = edges.length; 
        int[] indegree = new int[n + 1];
        List<List<Integer>> adj = new ArrayList<>(n + 1);

        for(int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        
        for(int[] edge : edges){
            int u = edge[0], v = edge[1]; 
            adj.get(u).add(v); // connects th e2
            adj.get(v).add(u);
            indegree[u]++; // bc a connection exists, indegree++
            indegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            if(indegree[i] == 1) q.offer(i); // if there's a connection, offer to queue
        }

        while(!q.isEmpty()){ // while queue isnt empty,
        // meaning theres a connection somewhere
            int node = q.poll();
            indegree[node]--;
            for(int nei : adj.get(node)){
                indegree[nei]--; // we get rid of the 'node' in a way,
                // so we remove it from adj list
                if(indegree[nei] == 1) q.offer(nei); // if the next node
                // has a connection, we move onto that one and check 
            }
        }

        for(int i = edges.length - 1; i >= 0; i--){ // now we move backwards
        // to return the edge appearing last 
            int u = edges[i][0], v = edges[i][1]; // look at the cur
            // and next node
            if(indegree[u] == 2 && indegree[v] > 0) return new int[]{u, v};
            // if indegree == 2, there's a cycle
        }

        return new int[0];
        
    }
}
