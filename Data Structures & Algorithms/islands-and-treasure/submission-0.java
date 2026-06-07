class Solution {
    public void islandsAndTreasure(int[][] grid) {
       // -1 -> water cell that can't be traversed -> backtracking
       // works but raises time complexity :( 
       // if reached
       // 0 -> treasure chest 
       // inf -> land

       // each land cell will hold the distance to its nearest
       // trewasure chest

        // idea is to not run from every land node, but rather
        // from the treasure chests to everywhere else
       Queue<int[]> q = new LinkedList<>();
       int rows = grid.length;
       int cols = grid[0].length;
       for(int i = 0; i < rows; i++){
        for(int j = 0; j < cols; j++){
            if(grid[i][j] == 0){
                q.add(new int[] {i, j}); // mark every treasure in queue
                // this is bc bfs automatically has everything by shortest dist
                // so top of a queue = closest treasure
                // then we add land later bc queue will act as having
                // been visited
            }
        }
       }
       if(q.size() == 0) return; // null check
       int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

       while(!q.isEmpty()){ // process treasures first then land
        int[] node = q.poll(); // current bfs cell (aka treasure)
        int row = node[0]; // now the row of the node represents the closest
        // known cell's node -> so now we're finding the treasure's closest land the first
        // few times we run it
        int col = node[1]; // and same for column
        for(int[] dir : dirs){
            int r = row + dir[0]; // move row by row
            int c = col + dir[1]; // and col by col
            if(r >= rows || c >= cols || r < 0 || c < 0 || grid[r][c] != Integer.MAX_VALUE){
                continue; // if out of bounds or has already been visited
            }
            q.add(new int[] {r, c}); // add unexplored nodes 

            grid[r][c] = grid[row][col] + 1; // move through nodes
        }
       }
    
    }
}
