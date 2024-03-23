#!/usr/bin/env python
# coding: utf-8

# In[1]:


class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):

        self.val = val
        self.left = left
        self.right = right


# In[2]:


def print_tree(node, level=0):
    if node is not None:
        print("  " * level + str(node.val))
        print_tree(node.left, level + 1)
        print_tree(node.right, level + 1)


# In[3]:


def isBST(root):
    if root is None:
        return True
    if (root.left and root.left.val >= root.val) or (root.right and root.right.val <= root.val):
        return False
    return isBST(root.left) and isBST(root.right)


# In[4]:


root = TreeNode(4)
root.left = TreeNode(3)
root.right = TreeNode(8)

root.left.left = TreeNode(1)
#root.left.right = TreeNode(1)
root.right.left = TreeNode(5)
root.right.right = TreeNode(9)

print_tree(root)


# In[6]:


print(isBST(root))


# In[2]:


get_ipython().system('jupyter nbconvert --to script lab05.ipynb')

