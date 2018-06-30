package com.deepakm.dsalgo.ds.trie;

public class Driver {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("he");
        trie.insert("hf");
        trie.insert("ge");

        boolean exists = trie.search("ge");
        System.out.println(exists);
        exists = trie.search("he");
        System.out.println(exists);
        exists = trie.search("hello");
        System.out.println(exists);

        //trie.print();
    }
}
