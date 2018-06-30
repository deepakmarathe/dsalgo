package com.deepakm.problems;

import com.deepakm.ds.tree.binary.TreeNode;

/**
 * Given 2 binary search trees, tell whether the 2 trees are same or not.
 */
public class SameTree {
    public boolean sameTree(TreeNode root1, TreeNode root2){
        if( root1 == null && root2 == null ) return true;
        if( root1 == null || root2 == null ) return false;
        return root1.data == root2.data && sameTree(root1.left, root2.left) && sameTree(root1.right, root2.right);
    }

    public static void main(String[] args) {
        SameTree sameTree = new SameTree();
        TreeNode root1 = new TreeNode(10);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(11);

        TreeNode root2 = new TreeNode(10);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(11);

        TreeNode root3 = new TreeNode(11);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(12);

        boolean isSame = sameTree.sameTree(root1, root3);
        System.out.println(isSame);
    }
}
