package leetcode;

public class ImplementTrie {
    class TrieNode {
        boolean c = false;

        TrieNode[] children = new TrieNode[26];
    }

    public class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                TrieNode child = node.children[index];
                if (null == child) {
                    child = new TrieNode();
                    node.children[index] = child;
                }
                node = child;
            }
            node.c = true;
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            if (null == word || "".equals(word)) {
                return false;
            }
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                TrieNode child = node.children[index];
                if (null != child) {
                    node = node.children[index];
                } else {
                    return false;
                }
            }
            return node.c;
        }

        public boolean startsWith(String prefix) {
            if (null == prefix || "".equals(prefix)) {
                return false;
            }
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                int index = c - 'a';
                TrieNode child = node.children[index];
                if (null != child) {
                    node = node.children[index];
                } else {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Trie t = new ImplementTrie().new Trie();

        t.insert("abc");
        t.insert("acd");

        System.out.println(t.search("acd"));
        System.out.println(t.startsWith("ac"));
    }
}
