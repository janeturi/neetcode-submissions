class Solution {
    public int largestRectangleArea(int[] heights) {
        // largest rectange in histogram
        // given array of ints heights where heights[i] 
        // is the heihgt of an indiv bar
        // width of each bar is 1
        // we want to return the area of the largest rectangle
        // that be formed among the bars
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        // stores indices of the different squares
        for(int i = 0; i <= n; i++){
            while(!stack.isEmpty() && (i == n || heights[stack.peek()] >= heights[i])) {
                // while the stack isn't empty,
                // and we are at height 0/past the last bar 
                // OR height of the current bar is
                // less thna or equal to the height of the bar that
                // hasn't gotten their height cut off with a smaller rectangle
                int height = heights[stack.pop()];
                // we update the height to the shorter bar
                int width = stack.isEmpty() ? i : i - stack.peek() - 1; 
                // if the stack is empty, width is just i
                // if the stack is not empty, then the width is
                // the right - the one before the popped bar
                maxArea = Math.max(maxArea, height * width);
                // reg area formula
            }
            stack.push(i);
            //push each indices
        }
        return maxArea;
    }
}
