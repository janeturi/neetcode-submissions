class Solution {
    public int rob(int[] nums) {
        // given array nums where nums[i] 
        // is the money the ith house has
        // planning to rob moneyfrom houses but u cant rob
        // two adjacent houses if both are broken into

        // return max amount of money w/o alerting the police
        int h1 = 0, h2 = 0;
        // best up to house i - 2
        // best up to house i - 1

        for(int cur : nums){
            int temp = Math.max(cur + h1, h2);
            // robbing (current money + first house money)
            // or skipping and going to h2, whatever gives most money
            h1 = h2; // mve foward
            h2 = temp;
        }
        return h2; // return answer
    }
}
