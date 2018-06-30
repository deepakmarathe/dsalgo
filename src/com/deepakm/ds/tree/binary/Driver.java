package com.deepakm.ds.tree.binary;

public class Driver {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.add(100);
        tree.add(10);
        tree.add(200);
        tree.add(50);

        System.out.println("Preorder ");
        tree.preOrder();

        System.out.println("inorder");
        tree.inOrder();

        System.out.println("postorder");
        tree.postOrder();

        System.out.println("contains 200 ? : " + tree.containsNode(200));
        System.out.println("contains 12? : " + tree.containsNode(12));

        System.out.println("size : " + tree.size());

        System.out.println("Height : " + tree.height());
    }
}
