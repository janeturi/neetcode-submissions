class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int rows = matrix.length;
        int cols = matrix[0].length;

        int top = 0;
        int bot = rows - 1;

        // each matrix is sorted in non-decreasing order
        // girst int of every row > last int of previous row 

        // binary search over rows
        while (top <= bot){
            int row = (top + bot) / 2;
            if (target > matrix[row][cols - 1]){
                top = row + 1;
                // if target is greater than the last element
                // of the row, move down
                // target is greater than min
            } else if (target < matrix[row][0]){
                bot = row - 1;
                // if the target is smaller than the first
                // element, move up
                // target is less than max
            } else {
                break;
                // target must be in this row so we stop
            }
        }
        if (!(top <= bot)){
            return false;
            // invalid row
        }
        int row = (top + bot) / 2;
        // isolate row
        int left = 0;
        int right = cols - 1;
         // once u have the row, you do binary search for it

        while(left <= right){
            int middle = (left + right) / 2;
            // middle in the specific row
            // so now we're finding the column
            if(target > matrix[row][middle]){
                left = middle + 1;
                // if the target is bigger than it's greater than the
                // mid col so left is moved and the 'window'
                // gets smaller
            } else if (target < matrix[row][middle]){
                right = middle - 1;
                // if the target is smaller than it's less htan
                // mid col so right is changed and the 'window'
                // gets smaller
            } else {
                return true;
                // return true if it exists
            }
        }
        return false;
    }
}
