package leetcode;

/**
 * Created by lsy on 2016/4/19.
 */
public class ImplementTrie208 {
    private TrieNode root;

    public ImplementTrie208() {
        root = new TrieNode();
    }

    class TrieNode {
        // Initialize your data structure here.
        private String word;
        private TrieNode next;

        public TrieNode() {

        }
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode t = root;
        while (t.next != null) {
            t = t.next;
        }
        t.word = word;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode t = root;

        while (t.word != null) {
            if (t.word == word) {
                return true;
            }
            if (t.next == null) {
                break;
            }
            t = t.next;
        }
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (prefix == null) {
            return false;
        }
        int len = prefix.length();
        TrieNode t = root;
        while (t.word != null) {
            if (t.word.length() >= len && t.word.substring(0, len) == prefix) {
                return true;
            }
            if (t.next == null) {
                break;
            }
            t = t.next;
        }
        return false;
    }

    public static void main( String[] args){
        ImplementTrie208 im = new ImplementTrie208();
        im.insert("a");
        System.out.println(im.search("a"));
        System.out.println(im.startsWith("a"));
    }
}
