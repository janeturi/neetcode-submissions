class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /* my idea: split up an array into 3, 
        mid - left = # that u look for on the right, 
        if unsuccessful, left ++?
        may not be efficietn with large arrys.
        ans is kind of similar, have a fixed num and then search for the other two
        */
        Arrays.sort(nums); // !
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            if (nums[i] > 0) break; // all remaining nums are positive, sum cant be 0
            if (i > 0 && nums[i] == nums [ i - 1]) continue; // skips current
            // iteration of for loop if we've detected a duplicate 

            int left = i + 1;
            int right = nums.length - 1;

            while(left < right){ // same logic as before
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0){
                    right--;
                } else if (sum < 0){
                    left++;
                } else {  
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++; // now move again to find other potential triplets
                    right--;
                    while (left < right && nums[left] == nums[left - 1]){ // security against
                    // dupe triplet
                        left++;
                    }
                }
            }
        }
        return res;
    }
}
