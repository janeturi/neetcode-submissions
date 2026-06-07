class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) { // if the size of the
        // 2nd string is smaller than the possible permutation we're
        // looking for
            return false;
        }
        
        HashMap<Character, Integer> s1Count = new HashMap<>();
        // idea is that we count what's inside the current window
        // this hashmap will store the freq we're looking for
        HashMap<Character, Integer> s2Count = new HashMap<>();
        // by the end, what frequencies match will be a permutation
        for (int i = 0; i < s1.length(); i++) {
            s1Count.put(s1.charAt(i), s1Count.getOrDefault(s1.charAt(i), 0) + 1);
            s2Count.put(s2.charAt(i), s2Count.getOrDefault(s2.charAt(i), 0) + 1);
            // remember this general thing for making freq maps
        }
        
        if (s1Count.equals(s2Count)) { // no window needed
            return true;
        }
        
        int left = 0;
        for (int right = s1.length(); right < s2.length(); right++) {
            char charRight = s2.charAt(right); // right boundary
            s2Count.put(charRight, s2Count.getOrDefault(charRight, 0) + 1);
            // hashmap change to adjust for window
            char charLeft = s2.charAt(left);
            s2Count.put(charLeft, s2Count.get(charLeft) - 1);
            // remember this too
            if (s2Count.get(charLeft) == 0) {
                // null spaces
                s2Count.remove(charLeft);
            }
            
            left++; // window moving
            
            if (s1Count.equals(s2Count)) { // if freq 1 = freq 2
                return true;
            }
        }
        
        return false;        
    }
}
