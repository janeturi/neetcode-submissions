class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer>  count = new HashMap<>(); // maxfreq count
        int res = 0;

        int left = 0;
        int maxFreq = 0; // highest freq of a character seen so far

        for (int right = 0; right < s.length(); right++){
            count.put(s.charAt(right), count.getOrDefault(s.charAt(right) , 0) + 1);
            // putting things into array, also checking if it exists
            // if it does, then it's overwritten with a new value with each pass
            // this happens bc it means that the frequency of a character
            // has increased
            
            maxFreq = Math.max(maxFreq, count.get(s.charAt(right)));
            // max freq, gets updated with each pass and is updated to the frequency
            // given in the map
            while((right - left + 1) - maxFreq > k){
                // while the size of the window - the max frequency 
                // is greater than the # of replacement things
                // that means we need more replacements in order to 
                // get only one distinct character, so window needs to change
                count.put(s.charAt(left), count.get(s.charAt(left)) - 1);
                // this decrements the left freq as the window moves
                // cout.get(s.chatAr(left)) - 1 is getting the freq value
                // and the put part is updating it
                left++; // left window moves up
            }
            res = Math.max(res, right - left + 1); // gets updated each inc,  
            // either length of the one before or changes
        }
        return res;

    }
}
