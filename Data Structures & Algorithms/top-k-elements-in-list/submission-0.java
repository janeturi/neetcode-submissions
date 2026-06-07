class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // ok thoughts:
        // i guess it's making u return k most frequent numbers
        // so if u input 2, then you get the 2 most frequent numbers
        // in an array 

        /* 
        1. build map that is going to be used for num -> freq for each indiv number
        2. build the list of groups freq, which will get updated everytime something
        appears i times
        3. makes a new empty array list for each index, bc it must exist
        before trying to do anything with it
        4. iterates through all nums in parameter nums, then marks it in the map (otherwise, puts a 0)
        and then also updates the freq by 1
        5. goes back to bucket array we made, going through the number -> freq pair
        6. then prepare to make the result array by 

        */

        Map<Integer, Integer> count = new HashMap<>(); // to assign num -> freq


        List<Integer>[] freq = new List[nums.length + 1]; // for bucket list

        for(int i = 0; i < freq.length; i++){ // initializing an array for each thing in freq
            freq[i] = new ArrayList<>();
        }

        for(int n : nums){ 
            count.put(n, count.getOrDefault(n, 0) + 1); // building hash table
        }
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            freq[entry.getValue()].add(entry.getKey()); // building freq array list
        }

        int[] res = new int[k]; // return exactly k numbers
        int index = 0;
        for (int i = freq.length - 1; i > 0 && index < k; i--){
            // undo + 1 from b4
            // also, i starts at the highest frequencies, and then makes 
            // the added numbers are 
            for (int n: freq[i]){ // go through freq
                res[index++] = n; // stores the number and then index moves
                // onto the next spot that's avaliable
                if(index == k){ // if index reaches k, then we return the array :)
                    return res;
                }
            }
        }
        return res;
    }
}