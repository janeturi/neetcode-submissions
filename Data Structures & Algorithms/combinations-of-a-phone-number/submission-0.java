class Solution {

    private List<String> res = new ArrayList<>(); // res array
    private String[] digitToChar = {"", "", "abc", "def", 
    "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"}; // map digits to char

    public List<String> letterCombinations(String digits) {
        // given a string digits made up of digits from 2 thru
        // 9 inclusive

        // a digit can represent any one of the characters it
        // maps to

        // return all possible letter combos that digits
        // could represent

        // backtrack when a letter is given or the number
        // changes and try new options
        if(digits.isEmpty()) return res; // if input string is empty
        // return empty list
        backtrack(0, "", digits); // start int i, with no current string or
        // letters currently added
        return res;
    }

    private void backtrack(int i, String curStr, String digits){
        if(curStr.length() == digits.length()){  // we have changed everything
        // return to res the currret word we've formed
            res.add(curStr);
            return;
        }
        String chars = digitToChar[digits.charAt(i) - '0'];
        for(char c : chars.toCharArray()){ // for each c in the digits
        // array, backtrack and find a new thing
            backtrack(i + 1, curStr + c, digits);
        }
    }
}
