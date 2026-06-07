class Solution {

    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    //all possivle directions
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == '1'){ // if the grid has 1, aka is a 
                // piece of land
                    dfs(grid, r, c); // we use dfs that traverses all the 
                    // way down the 'branch' aka all through the island's
                    // rows and columns
                    // until we reach 0
                    islands++;  // for each dfs call, that means there;s
                    // an isaldn
                }
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, int r, int c){
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length ||
        grid[r][c] == '0') return; // ways an island is invalid
        // out of bounds or 0

        grid[r][c] = '0'; // mark as visited aka 0 bc we
        // already explored it
        for(int[] dir : directions){
            dfs(grid, r + dir[0], c + dir[1]); // explore all directions
            // for dfs
        }
    }
}
