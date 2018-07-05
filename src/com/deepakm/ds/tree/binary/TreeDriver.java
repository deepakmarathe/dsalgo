package com.deepakm.ds.tree.binary;

public class TreeDriver {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(100);
        tree.getRoot().left = new TreeNode(10);
        tree.getRoot().right = new TreeNode(110);

        tree = new BinaryTree();
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

        System.out.println("Sum : " + tree.sum());

        System.out.println("isBST : " + tree.isBST());

        tree.levelOrder();

        System.out.println("postorderIterative : ");
        tree.postOrderIterative();

        System.out.println("preOrderIterative : ");
        tree.preOrderIterative();

        System.out.println("inOrderIterative : ");
        tree.inOrderIterative();

        System.out.println("Level order in reverse : ");
        tree.levelOrderReverse();

        System.out.println("Spiral Traversal : ");
        tree.spiralTraversal();

        TreeNode node1 = tree.getRoot().left.right;
        TreeNode node2 = tree.getRoot().left;
        TreeNode lca = tree.lowestCommonAncestorBST(node1, node2);
        System.out.println("Lowest Common Ancestor : " + lca.data);

        lca = tree.lowestCommonAncestorBT(node1, node2);
        System.out.println("Lowest common ancestor : " + lca.data);
    }
}
