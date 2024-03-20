

class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):

        self.val = val
        self.left = left
        self.right = right


def invertTree(root):
    if root:
        tmp = TreeNode()
        tmp = root.right
        root.right = root.left
        root.left = tmp

        invertTree(root.left)
        invertTree(root.right)

    return root


def print_tree(node, level=0):
    if node is not None:
        print("  " * level + str(node.val))
        print_tree(node.left, level + 1)
        print_tree(node.right, level + 1)




root = TreeNode(1)
root.left = TreeNode(2)
root.right = TreeNode(8)
root.left.left = TreeNode(3)
root.left.right = TreeNode(4)
root.right.left = TreeNode(5)
root.right.right = TreeNode(6)

print_tree(root)


print_tree(invertTree(root))
