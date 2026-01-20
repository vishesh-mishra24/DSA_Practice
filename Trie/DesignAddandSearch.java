class WordDictionary {

    // Trie Node
    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    private TrieNode root;

    // Constructor
    public WordDictionary() {
        root = new TrieNode();
    }

    // Add a word into the data structure
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.isEnd = true;
    }

    // Search a word with '.' wildcard
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    // DFS helper for wildcard search
    private boolean dfs(String word, int index, TrieNode node) {
        if (node == null) return false;

        if (index == word.length()) {
            return node.isEnd;
        }

        char c = word.charAt(index);

        // If wildcard '.', try all children
        if (c == '.') {
            for (TrieNode child : node.children) {
                if (child != null && dfs(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } 
        // Normal character
        else {
            return dfs(word, index + 1, node.children[c - 'a']);
        }
    }
}
