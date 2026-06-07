class Solution {
    public boolean isValidSudoku(char[][] board) {
        /*
        most optimal: brute force it--
        for every row, every col, & every 3x3, keep a set of 
        seen digits
        -> if duplicate is found, board is deemed invalid
        */
        for(int row = 0; row < 9; row++){
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 9; i++){ // initializing row
            // to go through all the rows duh..
                if (board[row][i] == '.') continue; // if it's empty, we move on
                // to the next i
                if(seen.contains(board[row][i])) // if there's a duplicate
                // from what we've already seen
                return false; // return false
                seen.add(board[row][i]); // now mark everything we go through 
                // as seen
            }
        }

        for(int col = 0; col < 9; col++){
            Set<Character> seen = new HashSet<>();
            for(int i = 0; i < 9; i++){
                if(board[i][col] == '.') continue;
                if(seen.contains(board[i][col])) return false;
                seen.add(board[i][col]);
            }
        }

        for(int square = 0; square < 9; square++){ // checks each box
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 3; i++) { // mini row inside the indiv box
                for(int j = 0; j < 3; j++){ // mini col inside the indiv box
                    int row = (square / 3) * 3 + i; // divide by
                    // 3 to tell us what row of boxes exactly it's in
                    // then multiplies to convert them to actual row in the box
                    // this works bc u get 0 3 6 as options (the boxes), 
                    // divide by 3 to get the row of indiv box
                    // then multiply by 3 + mini row, (bc everything in
                    // a sqaure is atm in 3s)
                    int col = (square % 3) * 3 + j;
                    // same thing
                    if (board[row][col] == '.') continue;
                    if (seen.contains(board[row][col])) return false;
                    seen.add(board[row][col]);
                }
            }
        }
        return true;
    }
}
