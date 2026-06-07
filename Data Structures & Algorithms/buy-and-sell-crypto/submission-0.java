class Solution {
    public int maxProfit(int[] prices) {
        /* 'repeatedly iterating over the same elements,
         the sliding window maintains a range 
         (or “window”) that moves step-by-step through 
         the data, updating results incrementally.'

        */

        int maxP = 0;
        int minBuy = prices[0];

        for(int sell : prices){ // traverse prices
            maxP = Math.max(maxP, sell - minBuy); // max price will
            // either be 0/current max price OR
            // prices[i] - minBuy vv
            minBuy = Math.min(minBuy, sell); // minBuy will either 
            // be index 0, or with each pass/traversal,
            // change sell
        }
        return maxP;
    }
}
