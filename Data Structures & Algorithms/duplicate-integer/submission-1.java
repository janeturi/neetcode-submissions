class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> seen = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            // i need to find a way to check for duplicates
            if(seen.containsKey(nums[i])) {
                return true;
            }
            seen.put(nums[i], i);
        }
            return false;
    }

}