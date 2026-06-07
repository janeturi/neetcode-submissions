class Solution {

    private static final int[][] directions = {{1, 0}, {-1, 0}, {0,1}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) {
        // same concept as last, form ad find islands
        // and do area formulas in each  
        int rows = grid.length;
        int cols = grid[0].length;
        int area = 0;

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == 1){
                    area = Math.max(area, dfs(grid, r, c));
                }
            }
        }
        return area;
    }

    private int dfs(int[][] grid, int r, int c){
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length ||
        grid[r][c] == 0) return 0; // out of bounds or water

        grid[r][c] = 0; // mark as visited
        int res = 1; // start at 1 
        for (int[] dir : directions){
            res += dfs(grid, r + dir[0], c + dir[1]);
            // counts the size of the grid, adds all to res
            // which counts the area of all 4 neighbors 
        }
        return res;
    }
}
