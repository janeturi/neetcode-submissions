class Solution {

    private int rows, cols;
    private int[][] directions = new int[][] {{1,0}, {-1,0}, {0, -1}, {0, 1}};
    public void solve(char[][] board) {
        // given 2d matrix containing x and 0
        // if a continuous group of 0 is surronded by x's
        // its considered surronded and return its new form
        rows = board.length;
        cols = board[0].length;
        capture(board);

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(board[r][c] == 'O'){ // if they're not reachable, they'll
                // switched to x
                    board[r][c] = 'X';
                } else if (board[r][c] == 'T'){
                    // if they are reachable, go back to 'o' bc
                    // they aren't surronded
                    board[r][c] = 'O';
                }
            }
        }
    }

    private void capture(char[][] board){
        Queue<int[]> q = new LinkedList<>();
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if (r == 0 || r == rows - 1 || c == 0 || c == cols - 1 &&
                board[r][c] == 'O') q.offer(new int[]{r, c});
                // if 'o' is on border, add to queue
            }
        }

        while(!q.isEmpty()){
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];
            if(board[r][c] == 'O'){
                board[r][c] = 'T'; // mark all o's as temporary
                for(int[] dir : directions){
                    int nr = r + dir[0], nc = c + dir[1];
                    if(nr >= 0 && nr < rows &&
                    nc >= 0 && nc < cols) q.offer(new int[]{nr, nc});
                    // add other o's to queue if they're reachable

                }
            }
        }
    }
}