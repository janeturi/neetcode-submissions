class Solution {
    private Map<Integer, List<Integer>> preMap = new HashMap<>();
    private Set<Integer> visiting = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // must take course b first if you want to take course a
        // pair [0, 1] indicates that u must take course 1 b4 
        // taking course 0
        // numCourses -> max amount needed to take

        // return true if it's possible to finish all
        // courses, otherwisse retturn false

        // we use kahn's algorithm to repeatedly take courses
        // with zero prereqs (which is where we count the number
        // of incoming edges and remove that way)
        // when we finish a course, we remove its dependency effect
        // from other courses

        // if some courses are never taken, cycle exists -> return false
        // if all courses can be taken, no cycle -> return true
        int[] indegree = new int[numCourses]; // collect number of indegrees

        List<List<Integer>> adj = new ArrayList<>(); 
        // keeps track of indegrees

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>()); // building indegree list
        }

        for (int[] pre : prerequisites) {
            indegree[pre[1]]++; // anything that is a prereq
            // gets their count added
            adj.get(pre[0]).add(pre[1]);
            // if they have no prereqs, add the other nodes 
            // that point to that node
        }

        Queue<Integer> q = new LinkedList<>(); // queue to remove nodes

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) { // if no connections
                q.add(i); // add to queue
            }
        }

        int finish = 0;
        while (!q.isEmpty()) { // while there are still nodes that 
        // have no connefctions and havent been removed
        // so we make this to remove them
            int node = q.poll();
            finish++; // num of nodes that have been removed from queue
            // or have no connections nymore
            for (int nei : adj.get(node)) {
                indegree[nei]--; //num of indegrees gets removed bc its
                // being removed
                if (indegree[nei] == 0) {
                    q.add(nei); // if it reaches 0, add to queue
                }
            }
        }

        return finish == numCourses; // if all have been processed 
        // and removed
    }
}
