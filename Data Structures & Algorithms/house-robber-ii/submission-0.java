class Solution {
    public int rob(int[] nums) {
        // circle -> cannot rob first + last house
        return Math.max(nums[0], 
        Math.max(helper(Arrays.copyOfRange(nums, 1, nums.length)),
        // rob houses excluding first house
        helper(Arrays.copyOfRange(nums, 0, nums.length - 1))));
        // rob houses excluding last house
        // so return the max of the two subproblems
    }

    private int helper(int[] nums){
        int rob1 = 0, rob2 = 0;

        for(int num : nums){
            int temp = Math.max(rob1 + num, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
}
