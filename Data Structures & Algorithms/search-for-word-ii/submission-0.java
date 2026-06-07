class TrieNode {
    Map<Character, TrieNode> children; // holds pointers of full words
    boolean isWord; // boolean that returns t/f if word or not

    public TrieNode(){
        children = new HashMap<>();
        isWord = false;
    }

    public void addWord(String word){
        TrieNode cur = this; // add words to hashmap to store
        // all words and letters into the trie
        for(char c : word.toCharArray()){
            cur.children.putIfAbsent(c, new TrieNode());
            cur = cur.children.get(c);
        }
        cur.isWord = true; // marked as a full word
    }
}

public class Solution {

    private Set<String> res;
    private boolean[][] visit;

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for(String word : words) root.addWord(word);

        int rows = board.length;
        int cols = board[0].length;
        res = new HashSet<>();
        visit = new boolean[rows][cols];

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                dfs(board, r, c, root, "");
            }
        }
        return new ArrayList<>(res);
    }

    private void dfs(char[][] board, int r, int c, TrieNode node, String word){
        int rows = board.length;
        int cols = board[0].length;

        if(r < 0 || c < 0 || r >= rows || c >= cols || visit[r][c] ||
        !node.children.containsKey(board[r][c])){
            return;
        }

        visit[r][c] = true;
        node = node.children.get(board[r][c]);
        word += board[r][c];
        if(node.isWord) res.add(word);

        dfs(board, r + 1, c, node, word);
        dfs(board, r - 1, c, node, word);
        dfs(board, r, c + 1, node, word);
        dfs(board, r, c - 1, node, word);

        visit[r][c] = false;

    }
}
