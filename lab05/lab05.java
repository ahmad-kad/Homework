package lab05;

public class lab05 {
    public static void printTree(TreeNode node, int level) {
        if (node != null) {
            for (int i = 0; i < level; i++) {
                System.out.print("  ");
            }
            System.out.println(node.val);
            printTree(node.left, level + 1);
            printTree(node.right, level + 1);
        }
    }
    
    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if ((root.left != null && root.left.val >= root.val) || 
            (root.right != null && root.right.val <= root.val)) {
            return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        printTree(root, 0);
        System.out.println(isValidBST(root));
    }
}