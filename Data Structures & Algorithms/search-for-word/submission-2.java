public class Solution {
    private int rows;
    private int cols;

    public boolean exist(char[][] board, String word) {
        // for a word to be present it must be possible to form it
        // w a path in the board with horizontally or vertically
        // neighboring cells 
        // + the same cell may not be used more than once in a word
        rows = board.length;
        cols = board[0].length;

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(dfs(board, word, r, c, 0)) return true;
                // auto continue if there is no word yet, or if the word
                // is just 1 letter
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int i){
        if(i == word.length()) return true; // if i == len(word) we've matched
        // all cgaracters

        if(r < 0 || c < 0 || r >= rows ||
         c >= cols || board[r][c] != word.charAt(i) 
         || board[r][c] == '#') return false; // if out of bounds
         // or current cell doesnt match the word there

        board[r][c] = '#'; // spot we've seen, mark as seen 
        boolean res = dfs(board, word, r + 1, c, i + 1) ||
        dfs(board, word, r - 1, c, i + 1) || 
        dfs(board, word, r, c + 1, i + 1) ||
        dfs(board, word, r, c - 1, i + 1);
        // do dfs in 4 directions, row moving left or right 
        // and c moving up or down.
        // no dupes so add + 1 to i
        board[r][c] = word.charAt(i);
        // restore the cell back to what it was to attempt to make
        // new words
        return res;
    }
}
