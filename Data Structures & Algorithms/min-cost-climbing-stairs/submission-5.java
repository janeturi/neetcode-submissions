class Solution {
    public int minCostClimbingStairs(int[] cost) {
        for (int i = cost.length - 3; i >= 0; i--){
            // we go backwards, so remove - 3 
            // to account for the possible steps
            cost[i] += Math.min(cost[i + 1], cost[i + 2]);
            // update the cost for each time, choosing between
            // cost of choosing one or the other option
        }
        return Math.min(cost[0], cost[1]);
        // so return min cost
    }
}