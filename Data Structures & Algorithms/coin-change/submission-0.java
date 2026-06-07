class Solution {
    public int coinChange(int[] coins, int amount) {
        /* given int arrya coins representing coins
        of different amounts and an integer 
        amount representing target amount of money

        we want to return the fewest number of coins that u need
        to make up the exact target amount
        
        i originally wanted to always use the largest coin
        aka a greedy approach, but it's not actually true
        so we wwant to explore all combos

        i would use bfs but its easier to use dynamic programming

        */

        // so this dp approach doesnt ask: how many coins
        // does it take to reach amoutn? rather,
        // we build answers from smaller amounts to larger ones

        int[] dp = new int[amount + 1]; // min coins needed to 
        // make the amount
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){ // look at prev solution's
            for(int j = 0; j < coins.length; j++){ // look at coins
                if(coins[j] <= i){ // if we have remaining coins
                // coins at iteration j are less than prev solutions iteration
                // what does this mean? since i is the amout
                // this is asking if we have the coins to reach the target
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    // so choose between using all coins at j
                    // or you do current iteration - prev iterations + 1
                    // successfully using prev's solution to build the next
                    // in other words, we choose the best value each iteration
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
        // if we cant make a solution
    }
}
