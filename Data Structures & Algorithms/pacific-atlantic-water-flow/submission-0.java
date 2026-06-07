class Solution {
    private int[][] directions = {{1, 0}, {-1,0}, {0,1}, {0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // given rectangular island heights
        // where heights[r][c] represents thee height above
        // sea level of the cell at coordinate (r, c)
        // water flows in 4 directions from cell
        // to a neighboring cell with height equal or lower
        // water can flow into ocean from cells adjacent
        // 2 the ocean
        // find all cells where wter can flow forom that cell
        // to both pacific and atlantic oceans
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] pac = new boolean[rows][cols]; // boolean with size heights
        // will turn true if we can go through there
        boolean[][] atl = new boolean[rows][cols]; // same for atlantic

        Queue<int[]> pacQueue = new LinkedList<>();
        Queue<int[]> atlQueue = new LinkedList<>();

        for(int c = 0; c < cols; c++){
            pacQueue.add(new int[]{0, c}); // adds top row of paciric
            atlQueue.add(new int[]{rows - 1, c}); // bottom of atlantic
        }
        for(int r = 0; r < rows; r++){
            pacQueue.add(new int[]{r, 0}); // adds leftmost column of pacific
            atlQueue.add(new int[]{r, cols - 1}); // adds rightmost column of atlantic
            // we do this because we want to move backwards from the ocean
            // into the source waters
        }

        bfs(pacQueue, pac, heights);
        bfs(atlQueue, atl, heights);

        List<List<Integer>> res = new ArrayList<>();
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(pac[r][c] && atl[r][c]){ // if it can travel
                // back to both pacific and to atl
                // add to result
                    res.add(Arrays.asList(r, c));
                }
            }
        }
        return res;
    }

    private void bfs(Queue<int[]> q, boolean[][] ocean, int[][] heights){
        while(!q.isEmpty()){ // queue of sources
            int[] cur = q.poll(); 
            int r = cur[0], c = cur[1];
            ocean[r][c] = true; // set current as visited
            for(int[] d : directions){
                int nr = r + d[0], nc = c + d[1]; // go backwards to origin  in 
                // both directions
                if(nr >= 0 && nr < heights.length && 
                nc >= 0 && nc < heights[0].length &&
                !ocean[nr][nc] && heights[nr][nc] >= heights[r][c]){
                    // if valid and also not have been visited 
                    // and also the node we visit next into isnt smaller
                    q.add(new int[]{nr, nc}); // add to queue 
                    // so we can go backwards
                }
            }
        }
    }
}
