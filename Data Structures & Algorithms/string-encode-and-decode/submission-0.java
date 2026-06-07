class Solution {
    /* 
    notes:
    - stringbuilder is a way of making strings without making entirely
    new string objects
    intuition: 
    -> store string lengths, append it w/ length#string so that
    we can seperate each string from eachother.
    -> for decoding, we read characters until we reach # to find the length
    then extract exactly that many characters as the string
    */
    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder(); // not actually a string
        // just treated like one!
        for(String s : strs){
            res.append(s.length()).append('#').append(s); // append# after length then append 
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0; // marks the start
        while (i < str.length()){ // i keeps track of the length of the encoded string
        // so we're making sure we never go above that
            int j = i; // j is keeping track of the ends of strings
            while (str.charAt(j) != '#') {
                j++; // while we haven't hit a hashtag, j = end is pushed 
                // back by a bit more.
            }
            int length = Integer.parseInt(str.substring(i, j));// tells u the length 
            // of the current word (i points to start, j points to end!)
            // 
            i = j + 1; //still the same word, but i is moved to after the #
            j = i + length; // same word, end is moved to find the end of word
            res.add(str.substring(i, j)); // append it to the result
            i = j; // now we move onto the rest of the endcoded string
        }
        return res;
    }
}
