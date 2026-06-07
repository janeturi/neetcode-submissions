public class TrieNode {
    TrieNode[] children; // stores pointers between woords
    boolean word;

    public TrieNode(){
        children = new TrieNode[26]; // children is of size 26 si that
        // we can use whole alphabet
        word = false;
    }
}

class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            if(cur.children[c - 'a'] == null){ // if not in children list
                cur.children[c - 'a'] = new TrieNode(); // converts it into 
                // characters and also nodes so that characters point to eachother
                // to make words
            }
            cur = cur.children[c - 'a']; // move ahead to next node
        }
        cur.word = true; // cur.word becomes true bc the word exists nw
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int j, TrieNode root){
        // j says where to begin
        TrieNode cur = root;

        for(int i = j; i < word.length(); i++){
            // i is just for traversal
            char c = word.charAt(i);
            if(c == '.'){ // if c is a valid character in our alphabet
                for(TrieNode child : cur.children){
                    if(child != null && dfs(word, i + 1, child)){
                        return true; // we try ll possible letters and if the path returns a
                        // valid word, we return true
                    }
                }
                return false; // but if its empty not a match, return false
            } else {
                if (cur.children[c - 'a'] == null) return false; // if empty, return false
            }
            cur = cur.children[c - 'a']; // move through
        }
        return cur.word;
    }
}
