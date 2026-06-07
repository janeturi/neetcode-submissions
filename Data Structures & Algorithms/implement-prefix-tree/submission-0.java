public class TrieNode {
    // use prefix tree, designed to manipulate and do fast
    // string operations
    HashMap<Character, TrieNode> children = new HashMap<>(); // children
    // store links to the next letter in a word 
    boolean endOfWord = false; // complete word ends at this node, square
}

public class PrefixTree {
    private TrieNode root;

    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root; // start at root
        for(char c : word.toCharArray()){
            cur.children.putIfAbsent(c, new TrieNode()); // add children to
            // hashmap if missing
            cur = cur.children.get(c); // then switch cur to the next child
        }
        cur.endOfWord = true; // when you've gone through a word, mark true
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()){ // go through word
            if(!cur.children.containsKey(c)) return false; // if child/wprd doesnt exist, return false
            cur = cur.children.get(c); // move through
        }
        return cur.endOfWord; // returns true if the word exists bc we've
        // finished the word
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()){
            if(!cur.children.containsKey(c)) return false; // if current doesnt eecist
            cur = cur.children.get(c); // move down
        }
        return true; // return true if theres a pointer thing that contains the
        // prefix
    }
}
