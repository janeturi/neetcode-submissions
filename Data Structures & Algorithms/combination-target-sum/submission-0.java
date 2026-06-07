class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        // given an array of distinct nums
        // and a target integer target
        // we want to return a list of all unique combos of nums where
        // the chosen numbers sum to target
        // same number may be chosen from nums an unlimited number of times
        // two combos are the same if the freq of each of the chosen
        // numbers r the same, otherwise, diff
        // combos can be any order and numbers in combos can be any order
        res = new ArrayList<>();
        Arrays.sort(nums); // sort nums so that once a number makes
        // the sum exveed target, all numbers after also exceed target
        // so we stop exploring

        dfs(0, new ArrayList<>(), 0, nums, target); // start from beginning
        // start at index 0, make a new array for the current num
        // total is nums, keep target
        return res;
    }

    private void dfs(int i, List<Integer> cur, int total, int[] nums, int target){
        if(total == target){
            res.add(new ArrayList<>(cur)); // add current number to result
            // if our total reaches target
            return;
        }

        for(int j = i; j < nums.length; j++){
            // start at i so we can reuse the same number, so like
            // we explore all ways with the minimum and so on
            if(total + nums[j] > target) return; // break early if we exceed
            cur.add(nums[j]); // else, add it to the current array
            dfs(j, cur, total + nums[j], nums, target); // now do it w the 
            // new info, start at j, current sum updated, total updated, target the same
            cur.remove(cur.size() - 1); // remove the element that we've tried 
            // so we can try the others
        }
    }
}
