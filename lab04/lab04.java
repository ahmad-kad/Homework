package lab04;

public class lab04 {
    public static TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode tmp = root.right;
            root.right = root.left;
            root.left = tmp;

            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }

    public static void printTree(TreeNode node, int level) {
        if (node != null) {
            System.out.println(". ".repeat(level) + node.val);
            printTree(node.left, level + 1);
            printTree(node.right, level + 1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        
        System.out.println("Original Tree: ");
        printTree(root, 0);

        TreeNode invertedRoot = invertTree(root);
        System.out.println("\nInverted Tree: ");
        printTree(invertedRoot, 0);
    }
}
