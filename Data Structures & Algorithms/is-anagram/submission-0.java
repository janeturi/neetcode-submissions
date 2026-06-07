class Solution {
    public boolean isAnagram(String s, String t) {

            //logic: 1. basecase: if they have different lengths,
    // they can't be annagrams
    
    //other: make hashmap to compare easily, uses a count of frequencies 
    // to check if they have the same freq of characters used- if the freqs are the same,
    // then thye'll be the same
        if (s.length() != t.length()){
            return false; // if length is equal, automatically not an anagram
        
        }

        HashMap<Character, Integer> countS = new HashMap<>();
        HashMap<Character, Integer> countT = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            countS.put(s.charAt(i), // gets current int
            countS.getOrDefault(s.charAt(i), 0) + 1); // gets next char 

            countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i), 0) + 1);
        }
        return countS.equals(countT);

    }
}
