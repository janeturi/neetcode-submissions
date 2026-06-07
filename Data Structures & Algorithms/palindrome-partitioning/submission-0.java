class Solution {
    public List<List<String>> partition(String s) {
        // given a string s, split s into substrings
        // where every substring is a palindrome
        // return all possible lists of palindromic substrings
        // backtrack part: when u cant form a palindrome] anymore?
        List<List<String>> res = new ArrayList<>(); // all palindromes
        List<String> part = new ArrayList<>(); // current list of substring
        dfs(0, s, part, res); // start at beginning
        return res;
    }

    private void dfs(int i, String s, List<String> part, List<List<String>> res){
        // i is index of the next substring
        
        if(i >= s.length()){ // then the whole string has been gone through
            res.add(new ArrayList<>(part)); // add the partition to res
            return;
        }

        for(int j = i; j < s.length(); j++){ // for each substring
        // in a larger string
            if(isPali(s, i, j)){ // if the substring is a paplindrome
                part.add(s.substring(i, j + 1)); // add to part
                dfs(j + 1, s, part, res); // move on to the next letter
                part.remove(part.size() - 1); // try other options 
                // by undoing the last move made
            }
        }
    }

    private boolean isPali(String s, int left, int right){
        while(left < right){ // two pointers
            if(s.charAt(left) != s.charAt(right)){ 
                return false;
            }
            left++; // left moves up
            right--; // right moves down
            // if theyre not the same its not a palindrome
        }
        return true;
    }
}
