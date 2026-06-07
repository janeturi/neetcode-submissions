class Solution {
    public String longestPalindrome(String s) {
        // given string s, return longest substring of s 
        // that is a plaindrome

        int resLen = 0, resIdx = 0;
        // starting index of result + length of result


        // treat each idx as a possible center
        // expand left and right while characters match
        // track longest palindrome found each time we expand
        for(int i = 0; i < s.length(); i++){
            // odd length
            // so theres one letter in mid that stays the same
            int left = i, right = i;
            while(left >= 0 && right < s.length() &&
            s.charAt(left) == s.charAt(right)){
                // while left and right pointers r valid
                // and also a palindrome bc the letters
                // at both pointers r same
                if(right - left + 1 > resLen){
                    // if new palindrome is greater than curr result length
                    resIdx = left; // update res
                    // so residx becomes left
                    resLen = right - left + 1;
                    // and length is the new bigger length
                }
                left--; // expand outwards
                right++; 
            }

            // even length, so no center one
            left = i;
            right = i + 1;
            // same logic as before, but accounting for the right
            while(left >= 0 && right < s.length() &&
            s.charAt(left) == s.charAt(right)){
                if(right - left + 1 > resLen){
                    resIdx = left;
                    resLen = right - left + 1;
                }
                left--;
                right++;
            }
        }

        return s.substring(resIdx, resIdx + resLen);
    }
}
