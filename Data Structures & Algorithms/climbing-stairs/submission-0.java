class Solution {
    public int climbStairs(int n) {
        // given int n representing num of steps to reach top
        // u can use either 1 or 2

        // return the number of distinct ways to climb to the top

        int curr = 1, prev = 1;
        // curr = ways to reach curr step
        // prev = ways to reach prev step
        // start both as 1

        for(int i = 0; i < n - 1; i++){
            // same as fib
            int temp = curr; 
            curr = curr + prev;
            prev = temp;
        }
        return curr;
    }
}
