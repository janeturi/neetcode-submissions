class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>(); // map will
        // store indeces of the last time we've seen a character
        int left = 0; // start of the window 
        int length = 0;

        for(int i = 0; i < s.length(); i++){  // traverse hashmap + right
        // boundary
            if(map.containsKey(s.charAt(i))){ // if we've found a duplicate 
            // / if we've seen this before
                left = Math.max(map.get(s.charAt(i)) + 1, left);
                // this looks for repeated characters,
                // so if there's a duplicate character, we mvoe the window
            }
            map.put(s.charAt(i), i); // add to map when traversing
            length = Math.max(length, i - left + 1); // length is found by
            // either being 0 (or being updated, since we're looking for
            // longest) or index - left + 1, which means right - left boundary + 1
            // for index reasons
        }
        return length;
    }
}
