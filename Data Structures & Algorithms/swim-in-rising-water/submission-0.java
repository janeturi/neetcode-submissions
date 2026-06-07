class Solution {
    public int swimInWater(int[][] grid) {
        /*
        given 2d matrix where each int represents elevation at
        (i, j)

        rain falls at time = 0, causing water levels to rise
        at time t, water level across grid is t

        u can swim horizontally or vertically btwn two adjacent
        squares if og elevation of both squares is less than or
        equal to water levvel at time t

        return min amount it'll take to reach bottom right square

        so basically, we 'wait' and can only traverse 
        if the number adjacent if our number is more or equal

        instead of trying every path, the total time is the max height u ever step on
        so we want to find the min height that leads u to the end

        cost to reach cell = smallest possible max height
        */ 

        int n = grid.length;
        boolean[][] visit = new boolean[n][n];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        // sort by smallest cost bc we want to use the smallest path possible
        int[][] directions = {{0,1},{0,-1},{-1,0},{1,0}};

        minHeap.offer(new int[]{grid[0][0], 0,0}); // start at beginning
        visit[0][0] = true; // mark as visited

        while(!minHeap.isEmpty()){ // for as long as we havent reached the bottom
            int[] curr = minHeap.poll();  
            int t = curr[0], row = curr[1], col = curr[2];
            
            if (row == n - 1 && col == n - 1) return t; // if at border return time so far

            for(int[] dir : directions){
                int neiR = row + dir[0], neiC = col + dir[1]; // check surronding places

                if(neiR >= 0 && neiC >= 0 && neiR < n && neiC < n && !visit[neiR][neiC]){
                    // if valid
                    visit[neiR][neiC] = true; // mark visited
                    minHeap.offer(new int[]{Math.max(t, grid[neiR][neiC]), neiR, neiC});
                    // push neighbors onto the heap, push the bottleneck/largest
                    // bc we must choose between our current height or the next adjacent heihgt
                    // so adust time to be the larger one
                }
            }
        }
        return n * n;
    }
}
