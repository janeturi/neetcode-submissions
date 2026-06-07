class Solution {
    public int minCostConnectPoints(int[][] points) {
        /*
        given 2d array points where points are coords

        cost of connecting two points [xi - xj] + [yi - yj]

        return min cost to connect all points 2gether

        -> dijkstra? -> kind of but no, bc we want to use cost
        which is best found using prim's algo. dijkstra is for shortest paths

        */

        int n = points.length, node = 0;
        int[] dist = new int[n];
        boolean[] visit = new boolean[n]; // mark visited nodes to make sure
        // we don't miss any or create a loop
        Arrays.fill(dist, 10000000); // placeholder bc we want shortest cost/dist too
        int edges = 0, res = 0;

        while (edges < n - 1){ // while edges are unprocessed 
            visit[node] = true;  // mark true
            int nextNode = -1; // pplaceholder bc we need to look at options
            for(int i = 0; i < n; i++){
                if (visit[i]) continue; // ksip if we've seen this node alr
                int curDist = Math.abs(points[i][0] - points[node][0]) +
                Math.abs(points[i][1] - points[node][1]); 
                // compute manhatten dist
                dist[i] = Math.min(dist[i], curDist);
                // compare distances, choose the minimum cost
                if(nextNode == -1 || dist[i] < dist[nextNode]) nextNode = i;
                // if no next node/outgoing edges or if the node we're on has a better dist
            
            }

            res += dist[nextNode]; // add to full cost
            node = nextNode; // move on
            edges++; // mark as processed
        }
        return res;
    }
}
