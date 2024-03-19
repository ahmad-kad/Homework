package hw.hw9;
public class hw9 {

    // Traversal
    public TreeNode findNode(TreeNode root, int pVal) {
        TreeNode current = root;
        while (current != null) {
            if (current.val == pVal) {
                return current;
            } else if (pVal < current.val) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }

    // Recursive
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }

        // Both Nodes Left
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // Both Nodes Right
        else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        // Catches if one is root or if nodes in Left and Right nodes.
        else {
            return root;
        }
    }

    public static void main(String[] args) {
        // System Args
        int pVal = Integer.parseInt(args[0]);
        int qVal = Integer.parseInt(args[1]);

        // BST
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(9);

        hw9 tree = new hw9();
        TreeNode p = tree.findNode(root, pVal);
        TreeNode q = tree.findNode(root, qVal);

        TreeNode ancestor = tree.lowestCommonAncestor(root, p, q);
        if (ancestor != null) {
            System.out.println("Lowest Common Ancestor: " + ancestor.val);
        } else {
            System.out.println("p or q is not present in the tree.");
        }
    }
}
