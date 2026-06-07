class Solution {
    public int[] twoSum(int[] nums, int target) {
        // plan: use a complement, if target - i = j and j exists
        // then we found a thingy!!!

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) { // traverse through the array of numbers
            int tmp = target - nums[i]; // make the complement thingy

            if (map.containsKey(tmp)) { // if it has a the key in the map alr
                return new int[] { 
                    map.get(tmp), i }; // make a new int array to return it
            }

            map.put(nums[i], i); // then put it into the int array
        }

        return new int[0]; // 

    }
}
