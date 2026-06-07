class Solution {
    public String minWindow(String s, String t) {
        if(t.isEmpty()) return ""; 

        Map<Character, Integer> countT = new HashMap<>();
        // counts freq of characters in T
        Map<Character, Integer> window = new HashMap<>();
        // if the freq of characters in the window matches T,
        // then the characters should be the same

        for(char c : t.toCharArray()){
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        } // put into t hashmap

        int have = 0; // how many characters current meet required 
        // count
        int need = countT.size();
        // how many distinct characters are needed to match
        int[] res = {-1, -1}; // stores best window
        int resLen = Integer.MAX_VALUE; // for storing best window
        
        int left = 0; // initalize left side of window

        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right); // 
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (countT.containsKey(c) && window.get(c).equals(countT.get(c))) {
                have++; // if the right side of the window is in countT
                // + it's count in window matches countT, increment
                // have
            }

            while(have == need){ // valid window
                if((right - left + 1) < resLen) {
                    // current window is smaller than the result length
                    // so need to adjust 
                    resLen = right - left + 1;
                    res[0] = left;
                    res[1] = right;
                }

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                // this is for us needing to mvoe the window,
                // we need to adjust the window hashmap
                // and update have, plus update left
                if(countT.containsKey(leftChar) && window.get(leftChar) <
                countT.get(leftChar)) {
                    have--;
                }
                left++;
            }
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
        // ? operator returns true if statement is ttrue
        // so its saying, if the length is Integer.MaxValue, return ""
        // if not, then return the substring
    }
}
