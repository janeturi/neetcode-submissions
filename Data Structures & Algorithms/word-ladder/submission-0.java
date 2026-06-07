class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // for each word, we try replacing each character with all 26 letters
        // if the resulting word exists in the word set, it's a valid neighbor

        if (!wordList.contains(endWord) || beginWord.equals(endWord)) return 0; // nullcheck

        Set<String> words = new HashSet<>(wordList); // convert to set for O(1) lookups
        int res = 0;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord); // queue keeps track of the words we're using

        while(!q.isEmpty()){
            res++; // word 1
            for(int i = q.size(); i > 0; i--){
                String node = q.poll(); // start with 1 eord
                if(node.equals(endWord)) return res; // if word is found, end

                for(int j = 0; j < node.length(); j++){
                    for(char c = 'a'; c <= 'z'; c++){ // check for each letter in alphabet
                        if (c == node.charAt(j)) continue; // skip letters already searched through

                        String nei = node.substring(0, j) + c + node.substring(j + 1);
                        // creates new word with new letters placed

                        if(words.contains(nei)){ // if word we're looking at is in word list
                            q.offer(nei); // add to queue
                            words.remove(nei); // reset to check again, also preventus from using the same word
                        }
                    }
                }
            }
        }
        return 0;
    }
}
