class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        res.clear();
        // given an array nums of unique integers, return all posible 
        // permutations (order u can organize it in)
        backtrack(nums, 0); // start
        return res;
    }

    public void backtrack(int[] nums, int idx){
        if(idx == nums.length) { // base case where the array given is
        // size 1 or we're at the end basicaly
            List<Integer> perm = new ArrayList<>(); // list of permutations
            for(int num : nums) perm.add(num); // add each number
            res.add(perm); // add each perm array to res array
            return;
        }

        for(int i = idx; i < nums.length; i++){
            swap(nums, idx, i); // swap with every remaining number
            // at each index (but beginning idx is fixed)
            // one at a time
            // so first swap handles the postfix after the prefix
            backtrack(nums, idx + 1); // backtrack using recursion
            // so we can try every permutation starting with a specific idx
            // and this handles the prefix
            swap(nums, idx, i); // swap back to original so we can
            // swap again (like path.remove(path.size() - 1))
        }
    }

    private void swap(int[] nums, int i, int j){
        // normal swap thing 
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
