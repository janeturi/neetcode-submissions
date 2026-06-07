class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // given an array nums of unique integers, we want to return
        // all possible subsets (selection of elements in any order
        // w no duplicates)
        
        // why not use a hashset? order matters in a hashset,
        // and we dont care about it
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>()); 

        for(int num : nums){ // for eahc num in input array
            int size = res.size();
            for(int i = 0; i < size; i++){ 
                // for each subset in res
                List<Integer> subset = new ArrayList<>(res.get(i));
                // create a new subset including nums
                subset.add(num); // add num to subset
                res.add(subset); // then add ubset to res
            }
        } // this handles duplicates because after the initial first numbers
        // in the array, we dont look back at it
        return res;
    }
}
