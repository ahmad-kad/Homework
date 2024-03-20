package lab05;

import java.util.ArrayList;
import java.util.List;

public class lab05 {
    public static void printTree(TreeNode node, int level) {
        if (node != null) {
            System.out.println("  ".repeat(level) + node.val);
            printTree(node.left, level + 1);
            printTree(node.right, level + 1);
        }
    }

    public static void inorderTraversal(TreeNode node, List<Integer> inorder) {
        if (node != null) {
            inorderTraversal(node.left, inorder);
            inorder.add(node.val);
            inorderTraversal(node.right, inorder);
        }
    }

    public static boolean isBST(TreeNode root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isBSTUtil(TreeNode node, int min, int max) {
        if (node == null)
            return true;

        if (node.val <= min || node.val >= max)
            return false;

        return isBSTUtil(node.left, min, node.val) && isBSTUtil(node.right, node.val, max);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(19);
        root.right.right = new TreeNode(9);

        printTree(root, 0);

        List<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);
        System.out.println("Inorder traversal: " + inorder);

        System.out.println("Is BST: " + isBST(root));
    }
}