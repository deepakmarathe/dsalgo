package com.deepakm.ds.trie;

import java.util.Map;

public class Trie {

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void print() {
        print(root, 0);
    }

    private void print(TrieNode node, int level) {
        if (node == null) return;
        if (node.endOfWord == true) return;

        System.out.println("level : " + level);
        for (Map.Entry<Character, TrieNode> c : node.children.entrySet()) {
            System.out.print(c.getKey() + " ");
            print(c.getValue(), level + 1);
        }
    }

    public void insert(String word) {
        if (word == null) return;
        if (word.length() == 0) return;

        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) {
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }

        current.endOfWord = true;
    }

    public void insertRecursive(String word) {
        insertRecursive(root, word, 0);
    }

    private void insertRecursive(TrieNode current, String word, int index) {
        if (word == null) return;
        if (word.length() == 0) return;
        if (index == word.length()) {
            current.endOfWord = true;
            return;
        }
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);

        if (node == null) {
            node = new TrieNode();
            current.children.put(ch, node);
        }
        insertRecursive(node, word, index + 1);
    }

    public boolean search(String word) {
        if (word == null) return true;
        if (word.length() == 0) return true;

        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.endOfWord;
    }

    public boolean searchRecursive(String word) {
        return searchRecursive(root, word, 0);
    }

    private boolean searchRecursive(TrieNode current, String word, int index) {
        if (word == null) return true;
        if (word.length() == 0) return true;
        if (word.length() == index) return current.endOfWord;
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if (node == null) return false;
        return searchRecursive(node, word, index + 1);
    }

    public void delete(String word) {
        delete(root, word, 0);
    }

    private boolean delete(TrieNode current, String word, int index) {
        if (word == null) return true;
        if (word.length() == 0) return true;
        if (word.length() == index) {
            if (!current.endOfWord) return false;
            current.endOfWord = false;
            return current.children.size() == 0;
        }
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if (node == null) return false;
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1);

        if (shouldDeleteCurrentNode) {
            current.children.remove(ch);
            return current.children.size() == 0;
        }
        return false;
    }

}
