package com.deepakm.ds.tree.binary;

public class BinaryTree {
    private TreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    public void add(int data) {
        root = addRecursive(root, data);
    }

    private TreeNode addRecursive(TreeNode current, int data) {
        if (current == null) {
            return new TreeNode(data);
        }
        if (data < current.data) {
            current.left = addRecursive(current.left, data);
        } else if (data > current.data) {
            current.right = addRecursive(current.right, data);
        } else {
            // value already exists.
            return current;
        }
        return current;
    }

    public void preOrder() {
        // V, L, R
        preOrderRecursive(root);
    }

    private void preOrderRecursive(TreeNode node) {
        if (node == null) return;
        System.out.println(node.data);
        preOrderRecursive(node.left);
        preOrderRecursive(node.right);
    }

    public void inOrder() {
        // L, V, R
        inOrderRecursive(root);
    }

    private void inOrderRecursive(TreeNode node) {
        if (node == null) return;
        inOrderRecursive(node.left);
        System.out.println(node.data);
        inOrderRecursive(node.right);
    }

    public void postOrder() {
        // L, R, V
        postOrderRecursive(root);
    }

    private void postOrderRecursive(TreeNode node) {
        if (node == null) return;

        postOrderRecursive(node.left);
        postOrderRecursive(node.right);
        System.out.println(node.data);
    }

    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    private boolean containsNodeRecursive(TreeNode node, int data) {
        if (node == null) return false;
        if (data == node.data) return true;
        return data < node.data ? containsNodeRecursive(node.left, data) : containsNodeRecursive(node.right, data);
    }

    public int size(){
        return size(root);
    }

    private int size(TreeNode node) {
        if (node == null ) return 0;
        return 1 + size(node.left) + size(node.right);
    }

    public int height(){
        return height(root);
    }

    private int height(TreeNode node) {
        if( node == null ) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public long sum(){
        return sum(root);
    }

    private long sum(TreeNode node) {
        if( node == null ) return 0;
        long sum = node.data + sum(node.left) + sum(node.right);
        return sum;
    }
}
