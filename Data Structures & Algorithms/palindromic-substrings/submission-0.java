class Solution {
    public int countSubstrings(String s) {
        // expand outword, each char expansion counts as another palindrome

        int res = 0;
        for(int i = 0; i < s.length(); i++){
            res += countPali(s, i, i); // odds
            res += countPali(s, i, i + 1); // evens
        }
        return res;
    }

    private int countPali(String s, int left, int right){
        int res = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            res++;
            left--;
            right++;
        }
        return res;
    }
}
