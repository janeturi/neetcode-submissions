class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        // given a network of n directed nodes, labeled from
        // 1 to n
        // given times, a list of directed edges where
        // times[i] 
        // ui is source node
        // vi is target node
        // ti is time it takes for a signal to travel from source to target
        // given int k - node being sent in signal form
        // return min time it takes for all of the n nodes to recieve the signal
        // if it's impossible, return -1

        // use dijkstra to find shortest path when all edge weights are non-negative

        // we want to always expand on the node w currently the smallest
        // known time

        // once a node is picked from minheap, shortest time is final

        // use minheap to process closest node

        Map<Integer, List<int[]>> edges = new HashMap<>();
        // keep track

        for(int[] time : times){
            edges.computeIfAbsent(time[0], key -> new ArrayList<>()).add(new int[]{time[1], time[2]});
            // make a list for each node
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        // initialize minHeap to store {distance, node}
        // use minHeap intentionally to store in order 
        minHeap.offer(new int[]{0, k});
        // process first node, but later we will store the next
        

        Set<Integer> visited = new HashSet<>();
        int t = 0;
        while (!minHeap.isEmpty()){
            int[] curr = minHeap.poll(); // use a minHeap to auto sort by distance!
            int dist1 = curr[0], node1 = curr[1]; // {distance, node}
            if(visited.contains(node1)) continue; // skip if seen b4

            visited.add(node1); // add to visited
            t = dist1; // current time

            if(edges.containsKey(node1)){ // if reachable 
                for(int[] next : edges.get(node1)){ // go to next node
                    int node2 = next[0], dist2 = next[1]; // 
                    if(!visited.contains(node2)) minHeap.offer(new int[]{dist1 + dist2, node2});
                    // go to next node if we haven't processed it bfore
                    // plus add to res
                }
            }
        }
        return visited.size() == n ? t : -1; // if all nodes have been visited, return
        // max time
    }
}
