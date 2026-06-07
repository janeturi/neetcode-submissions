class Solution {
    public int numDecodings(String s) {
        
        // strings consisting of uppercase characters 
        // are encoded into a number

        /*

        to decode, digits are grouped and mapped into
        letters usingn the reverse of the mapping 
        so 1012 -> jab or jl butttt not 01 bc it starts with 
        01 which isnt allowed for some reasn

        retur numbre of ways to decode it

        */

        int dp = 0, dp2 = 0; // dp 2 -> grup 2 together
        int dp1 = 1; // -> group 1 together
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) == '0'){ // no leading 0s
                dp = 0;
            } else {
                dp = dp1; // start with 1 digit
                if(i + 1 < s.length() && //if valid
                (s.charAt(i) == '1' || s.charAt(i) == '2'
                && s.charAt(i + 1) < '7')){
                    // aka if of range and valid two digit
                    // number 
                    // so if it starts at 1 -> 0-9, if
                    // it starts at 2 -> 0-6
                    dp += dp2; // add to count 
                }
            }

            dp2 = dp1; // slide window 
            dp1 = dp; // dp1 moves to the next 1 iwndow
            // dp1 is also the. res
            dp = 0; // reset count
        }
        return dp1;
    }
}
