class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // same concept as before but
        //we want to return a valid ordering of courses
        // u can take to finish all courses
        // if there are many valid answers, return any of them
        // if its ot possible, return a empty array
        // i think kahn work's and we end early once we reach numCourses - 1
        // or dfs whihc was my first thought :)
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            indegree[pre[1]]++;
            adj.get(pre[0]).add(pre[1]);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0) q.add(i);
        }

        int finish = 0; 
        int[] output = new int[numCourses];
        while(!q.isEmpty()){
            int node = q.poll();
            output[numCourses - finish - 1] = node;
            finish++;
            for(int nei : adj.get(node)){
                indegree[nei]--;
                if(indegree[nei] == 0) q.add(nei);
            }
        }
        if(finish != numCourses){
            return new int[0];
        }
        return output;
    }
}
