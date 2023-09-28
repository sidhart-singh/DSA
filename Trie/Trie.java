package Trie;

import java.util.HashMap;

class TrieNode {

    HashMap<Character, TrieNode> children;
    boolean endOfWord;

    public TrieNode() {
        this.children = new HashMap<>();
        this.endOfWord = false;
    }
}

public class Trie {

    TrieNode root = null;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = this.root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!current.children.containsKey(c)) {
                current.children.put(c, new TrieNode());
            }
            current = current.children.get(c);
        }

        current.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode current = this.root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!current.children.containsKey(c)) {
                return false;
            }
            current = current.children.get(c);
        }

        // Return if the current char is marked as the end of a word or not
        return current.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = this.root;

        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!current.children.containsKey(c)) {
                return false;
            }
            current = current.children.get(c);
        }

        return true;
    }
}