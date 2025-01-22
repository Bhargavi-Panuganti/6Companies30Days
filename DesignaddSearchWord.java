// TrieNode: A node of the Trie Data Structure
class TrieNode {
    TrieNode[] child;   // 26 children (0-25 => a-z)
    boolean wordEnd;    // flag to mark the end of a word

    public TrieNode() {
        child = new TrieNode[26];  // by default, all indices are null
        wordEnd = false;          // initialize wordEnd to false
    }
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();  // initialize root node
    }

    // Add a word to the Trie
    public void addWord(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            if (curr.child[ch - 'a'] == null) {
                curr.child[ch - 'a'] = new TrieNode();  // create a new node if absent
            }
            curr = curr.child[ch - 'a'];  // move to the next node
        }
        curr.wordEnd = true;  // mark the end of the word
    }

    // Search for a word in the Trie (handles '.' as a wildcard)
    public boolean search(String word) {
        return searchRec(word, root);
    }

    // Recursive helper for searching
    private boolean searchRec(String word, TrieNode root) {
        TrieNode curr = root;

        if (word.isEmpty()) {
            return curr.wordEnd;  // base case: check if it's a valid word
        }

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            // Handle '.' as a wildcard
            if (ch == '.') {
                // Explore all possible paths for the next level
                for (TrieNode childNode : curr.child) {
                    if (childNode != null && searchRec(word.substring(i + 1), childNode)) {
                        return true;  // found a match
                    }
                }
                return false;  // no matches found
            }

            // Handle normal characters
            if (curr.child[ch - 'a'] == null) {
                return false;  // character mismatch
            }
            curr = curr.child[ch - 'a'];  // move to the next node
        }

        return curr.wordEnd;  // check if the word ends here
    }
}
