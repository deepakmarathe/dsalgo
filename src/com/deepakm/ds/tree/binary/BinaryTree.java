package com.deepakm.ds.tree.binary;

import java.util.*;

public class BinaryTree {
    private TreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(int data) {
        this.root = new TreeNode(data);
        this.root.left = null;
        this.root.right = null;
    }

    // used for experimentation.
    public TreeNode getRoot() {
        return root;
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

    public void preOrderIterative() {
        // V, L, R
        preOrderIterative(root);
    }

    private void preOrderIterative(TreeNode node) {
        if (node == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode n = stack.pop();
            System.out.println(n.data + ", ");
            if (n.right != null)
                stack.push(n.right);
            if (n.left != null)
                stack.push(n.left);
        }

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

    public void inOrderIterative() {
        inOrderIterative(root);
    }

    private void inOrderIterative(TreeNode node) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                if (stack.empty()) break;
                node = stack.pop();
                System.out.println(node.data);
                node = node.right;
            }
        }
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

    public void postOrderIterative() {
        postOrderIterative(root);
    }

    private void postOrderIterative(TreeNode node) {
        if (node == null) return;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(node);
        while (!s1.empty()) {
            TreeNode n = s1.pop();
            s2.push(n);
            if (n.left != null) {
                s1.push(n.left);
            }
            if (n.right != null) {
                s1.push(n.right);
            }
        }
        while (!s2.isEmpty()) {
            TreeNode n = s2.pop();
            System.out.println(n.data);
        }
    }

    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    private boolean containsNodeRecursive(TreeNode node, int data) {
        if (node == null) return false;
        if (data == node.data) return true;
        return data < node.data ? containsNodeRecursive(node.left, data) : containsNodeRecursive(node.right, data);
    }

    public int size() {
        return size(root);
    }

    private int size(TreeNode node) {
        if (node == null) return 0;
        return 1 + size(node.left) + size(node.right);
    }

    public int height() {
        return height(root);
    }

    private int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public long sum() {
        return sum(root);
    }

    private long sum(TreeNode node) {
        if (node == null) return 0;
        long sum = node.data + sum(node.left) + sum(node.right);
        return sum;
    }

    public boolean isBST() {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(TreeNode node, int minValue, int maxValue) {
        if (node == null) return true;
        if (node.data <= minValue || node.data > maxValue) return false;

        int data = node.data;
        return isBST(node.left, minValue, data) && isBST(node.right, data, maxValue);
    }

    public void levelOrder() {
        List<TreeNode> q = new LinkedList<>();
        q.add(root);
        levelOrder(q);
    }

    private void levelOrder(List<TreeNode> q) {
        if (q == null) return;
        if (q.size() == 0) return;

        List<TreeNode> tempQ = new LinkedList<>();

        for (TreeNode node : q) {
            if (node != null) {
                System.out.print(node.data + ", ");
                if (node.left != null)
                    tempQ.add(node.left);
                if (node.right != null)
                    tempQ.add(node.right);
            }
        }
        System.out.println();
        levelOrder(tempQ);
    }

    public void levelOrderReverse(){
        levelOrderReverse(root);
    }

    private void levelOrderReverse(TreeNode node) {
        if( node == null ) return ;
        Stack<TreeNode> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            node = queue.poll();
            if( node.right != null ) queue.offer(node.right);
            if( node.left != null ) queue.offer(node.left);
            stack.push(node);
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop().data);
        }
    }
}
