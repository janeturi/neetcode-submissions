class Solution {
    // remember attacked positions using hash sets :)
    Set<Integer> col = new HashSet<>(); //  column conflicts
    Set<Integer> posDiag = new HashSet<>(); // pos diagonal conflict (r + c)
    Set<Integer> negDiag = new HashSet<>(); // eg diag conflict (r - c)
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n]; // set up board
        for(char[] row : board){
            Arrays.fill(row, '.');
        }

        backtrack(0, n, board); // set start
        return res;
    }

    private void backtrack(int r, int n, char[][] board){
        if(r == n){ // if we've reached the end of the board's first row
        // we've filled it so we can go ahead and add it to the result
            List<String> copy = new ArrayList<>();
            for(char[] row : board){ // use copy so we only add that specific row
            // and we can still change it later on
                copy.add(new String(row));
            }
            res.add(copy);
            return;
        }

        for(int c = 0; c < n; c++){
            if(col.contains(c) || posDiag.contains(r+c) || 
            negDiag.contains(r - c)) continue; // skip the current selection if
            // everything there is invalid, but continue so we can try the others

            col.add(c);
            posDiag.add(r + c);
            negDiag.add(r - c);
            board[r][c] = 'Q';
            // if valid, add to hash sets and board

            backtrack(r + 1, n, board); // backtrack to try other options of
            // n queen
            // so remove everyhting
            col.remove(c);
            posDiag.remove(r + c);
            negDiag.remove(r - c);
            board[r][c] = '.';
        }
    }
}
