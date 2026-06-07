class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // given an array nums of integers, which may contain dupes
        // return all subset
        // no duplicate subsets tho
        res.clear();
        Arrays.sort(nums);
        backtrack(0, new ArrayList<>(), nums);
        return res;
    }

    private void backtrack(int i, List<Integer> subset, int[] nums){
        res.add(new ArrayList<>(subset)); // add current subset
        for(int j = i; j < nums.length; j++){ // traverse through nums again
            if(j > i && nums[j] == nums[j - 1]) continue; // if duplicate 
            // besides the ones b4
            subset.add(nums[j]); // add number 
            backtrack(j + 1, subset, nums); // go to next, index to avoid dupes
            subset.remove(subset.size() - 1); // backtrack and try new options
            // basically, at each index, recursively fill in the postfix numbers
            // while the rest are fixed
        }
    }
}
