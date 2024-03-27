#!/usr/bin/env python
# coding: utf-8

# In[1]:


## Init


# In[2]:


class TreeNode(object):
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right


# In[3]:


def print_queue(queue):
    for node in queue:
        print(node.val)


# In[4]:


from typing import List, Optional


def levelOrder(root: Optional[TreeNode]) -> List[List[int]]:
    ## Check if root is null
    if root is None:
        return None
    
    ## Add root to array (list)

    ## Add children to Array (list)
    
    ## Add Their Children to array (list)
    def bfs(root: TreeNode) -> List[List[int]]:
        result,queue = [],[root]
        while queue:
            level_values,level_size = [],len(queue)
            #print(f"level_size = {level_size}")
            for _ in range(level_size):
                node = queue.pop(0)
                level_values.append(node.val)

                # add left and/or right node if they exist to queue
                queue.extend([child for child in [node.left, node.right] if child])

                #print(f"level values: {level_values}")
            #print_queue(queue)
            result.append(level_values)
            #print(f"result: {result}")
        return result

    return bfs(root)
   




# In[5]:


def levelOrder2(root: Optional[TreeNode]) -> List[List[int]]:
    if not root:
        return None

    result, queue = [], [root]

    while queue:
        level_values, next_level = [], []

        for node in queue:
            level_values.append(node.val)
            if node.left:
                next_level.append(node.left)
            if node.right:
                next_level.append(node.right)

        result.append(level_values)
        queue = next_level

    return result


# In[6]:


# BST
root = TreeNode(4)
root.left = TreeNode(3)
root.right = TreeNode(8)
root.left.left = TreeNode(1)
root.right.left = TreeNode(5)
root.right.right = TreeNode(9)

root2 = TreeNode()


# In[7]:


# Function to print the level order traversal
def print_level_order(tree):
    result = levelOrder(tree)
    if result is not None:
        print("Level Order Traversal:")
        lst = []
        for level in result:
            lst.append(level)
        print(lst)
    else:
        print("Tree is empty")



# In[8]:


tree1 = TreeNode(3)
tree1.left = TreeNode(9)
tree1.right = TreeNode(20)
tree1.right.left = TreeNode(15)
tree1.right.right = TreeNode(7)

tree2 = None  # Empty tree

# Edge case: Single node tree
tree3 = TreeNode(5)

# Edge case: Left-skewed tree
tree4 = TreeNode(1)
tree4.left = TreeNode(2)
tree4.left.left = TreeNode(3)
tree4.left.left.left = TreeNode(4)

# Edge case: Right-skewed tree
tree5 = TreeNode(1)
tree5.right = TreeNode(2)
tree5.right.right = TreeNode(3)
tree5.right.right.right = TreeNode(4)

# Edge case: Complete binary tree with depth 3
tree6 = TreeNode(1)
tree6.left = TreeNode(2)
tree6.right = TreeNode(3)
tree6.left.left = TreeNode(4)
tree6.left.right = TreeNode(5)
tree6.right.left = TreeNode(6)
tree6.right.right = TreeNode(7)


# Test cases
print("Test Case 1:")
print_level_order(root)
print()

print("Test Case 2:")
print_level_order(tree1)
print()

print("Test Case 3:")
print_level_order(tree2)
print()

print("Test Case 4 (Single node tree):")
print_level_order(tree3)
print()

print("Test Case 5 (Left-skewed tree):")
print_level_order(tree4)
print()

print("Test Case 6 (Right-skewed tree):")
print_level_order(tree5)
print()

print("Test Case 7 (Complete binary tree with depth 3):")
print_level_order(tree6)


# In[9]:


get_ipython().system('jupyter nbconvert --to script hw10.ipynb')

