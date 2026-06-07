class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder newStr = new StringBuilder();

        for(char c : s.toCharArray()){ // traversing String via 
            if(Character.isLetterOrDigit(c)){ // ignores white space, only letter or digit
                newStr.append(Character.toLowerCase(c)); // adds to new string in lowercase
            }
        }
        return newStr.toString().equals(newStr.reverse().toString());
        // all in one to achieve o(n) time rather than naother for loop
        // that'd make it o(n^2)
        // so new string -> to string = new string -> to string -> reversed

    }
}
