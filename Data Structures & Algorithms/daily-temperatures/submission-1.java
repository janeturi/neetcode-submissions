class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // given array of temps where temp[i] = temp on i
        // result = # of days after the ith day
        // before a warmer temp appears on a future day
        // if there is no day in the future where a warmer
        // temp will appear, set res[i] to 0

        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>(); // [temp, day]
        // stores pairs for days that havent found a warmer day yet

        for(int i = 0; i < temperatures.length; i++){
            int t = temperatures[i];
            while(!stack.isEmpty() && t > stack.peek()[0]){
                // while stack isnt empty &
                // current temp is warmer than the first day
                int[] pair = stack.pop();
                // pop top element,
                // pair is just holding temp, day again but for one 
                // day (pair is (temp, day))
                res[pair[1]] = i - pair[1];
                // res is updated
                
            }
            stack.push(new int[]{t, i});
            // push onto stack
            // if a day is not warmer, you can just add it to the stack
       
    }
    return res;
     // if it IS warmer, you add it to res.

}
}
