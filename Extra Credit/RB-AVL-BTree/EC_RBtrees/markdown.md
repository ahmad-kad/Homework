## Red-Black Trees

### Description
Red black trees are self-balancing binary search trees that efficiently insert, delete, ands search.
They are balanced sturtuaclly where the height of the tree is low in relation to number of nodes.

### Rules of Red Black Trees
- Nodes must be red or black
- The root is always black
- No red node can have a red parent
    - Black nodes can have black or red children
- Every path from a node to descendant leaves must have the same number of black nodes.

#### Nodes

```python
class Node:
    def __init__(self, value, left=None, right=None, parent=None, color="RED"):
        self.value = value
        self.parent = parent
        self.left = left
        self.right = right
        self.color = color
```

Above describes the feature of the node. The parent and color property is added compared to a regular BST node.
Its important that the color defaults to red, since Red-Black trees always inserts Red nodes then recolors the tree.

#### Init

```python
 def __init__(self):
        self.nil = Node(value=None, color="BLACK")
        self.root = self.nil
```

#### Searching

Here its important to create a special node that holds no values and is black. This node will be the leaf nodes for the tree.

```python
    def search(self, value):
        current = self.root
        while current != self.nil:
            if value == current.value:
                print(f"Found Node with Val {value}")
                return current  
            elif value < current.value:
                current = current.left
            else:
                current = current.right
        print(f"Couldn't find Node with value: {value}")
        return None
```

Searching in Red Black trees is the same as searching in Binary Search Trees.

#### Insertion

```python
def insert(self, value):
        # Create node
        newNode = Node(value=value, left=self.nil, right=self.nil, parent=self.nil)
        parent = None

        # Case insert at root
        if self.root == self.nil:
            self.root = newNode
        else:
            # traverse to find insertion location
            current = self.root
            while current != self.nil:
                parent = current
                current.print_node()
                if newNode.value < current.value:
                    current = current.left
                else:
                    current = current.right

            # Assigns new node
            newNode.parent = parent
            if newNode.value < parent.value:
                parent.left = newNode
            else:
                parent.right = newNode

            newNode.left = self.nil
            newNode.right = self.nil
            newNode.color = "RED"

        self.recolor(newNode)
```

    Here we intialize the node and traverse storing the current spot as parent each time until there's an open spot. This ensures we can assign the parent node for the new node and figure out its orientation (left or right)

    We end by assigning left and right values to the nil objects and start the recoloring process.

#### Recoloring

    ```python
    
    def recolor(self, node):
        while node.parent.color == "RED":
            if node.parent == node.parent.parent.left:
                uncle = node.parent.parent.right
                if uncle.color == "RED":
                    node.parent.color = "BLACK"
                    uncle.color = "BLACK"
                    node.parent.parent.color = "RED"
                    node = node.parent.parent
                else:
                    if node == node.parent.right:
                        node = node.parent
                        self.lRotation(node)
                    node.parent.color = "BLACK"
                    node.parent.parent.color = "RED"
                    self.rRotation(node.parent.parent)
            else:
                uncle = node.parent.parent.left
                if uncle.color == "RED":
                    node.parent.color = "BLACK"
                    uncle.color = "BLACK"
                    node.parent.parent.color = "RED"
                    node = node.parent.parent
                else:
                    if node == node.parent.left:
                        node = node.parent
                        self.rRotation(node)
                    node.parent.color = "BLACK"
                    node.parent.parent.color = "RED"
                    self.lRotation(node.parent.parent)

        self.root.color = "BLACK"  # Set root to black        
```

Recoloring is needed for insertion and deletion. Here is the insertion recoloring method
There are 4 cases:
- Uncle is Red
- Uncle is Black and Node is the Right Child
- Uncle is Black and Node is the Left Child
- Root is always black

Uncles is the parents sibling node from the grandparent.

##### Rotations

```python
   def rRotation(self, node):
        y = node.left
        node.left = y.right
        if node.left != self.nil:
            node.left.parent = node
        y.parent = node.parent
        if node.parent == self.nil:
            self.root = y
        elif node == node.parent.right:
            node.parent.right = y
        else:
            node.parent.left = y
        node.parent = y
        y.right = node

    def lRotation(self, node):
        y = node.right
        node.right = y.left
        if node.right != self.nil:
            node.right.parent = node
        y.parent = node.parent
        if node.parent == self.nil:
            self.root = y
        elif node == node.parent.left:
            node.parent.left = y
        else:
            node.parent.right = y
        node.parent = y
        y.left = node
```
Rotations are what allows Red Black trees to self balance. The basic description is that you have a 3 left or right skewed subtree and set the middle node as the parent of the previous parent and node's child.

#### Deletion

```python

def remove(self, node):
        if node:
            if node == self.root:
                self.root = self.nil
            
            # Delete node with NO child (leaf node)
            if node.left == self.nil and node.right == self.nil:
                if node.value > node.parent.value:
                    node.parent.right = self.nil
                else:
                    node.parent.left = self.nil
                return

            # Delete node with ONE child
            if node.left == self.nil or node.right == self.nil:
                child = node.left if node.left != self.nil else node.right
                self.transplant(node, child)
                if node.color == "BLACK":
                    if child.color == "RED":
                        child.color = "BLACK"
                    else:
                        self.finodeDoubleBlack(child)
            
            # Delete node with TWO children
            else:
                successor = self.findSuccessor(node.right)
                node.value = successor.value
                self.remove(successor)
```

Deleting nodes havae 4 cases:
1. Delete a leaf node
2. Delete a node with one child
3. Delete a node with two children
4. Delete a node results in a double black condition

#### Transplants

```python
 def transplant(self, node, child):
        if node.parent == self.nil:
            self.root = child
        elif node == node.parent.left:
            node.parent.left = child
        else:
            node.parent.right = child
```

We use the transplant method in the 2nd case (delete node with one child)
It joins the parent and child of the node removing the node from the tree.

Then we check if it results into a double black node. If it is, we have to implement the following function


#### Double Black

```python
def finodeDoubleBlack(self, current):
    while current != self.root and current.color == "BLACK":
        # Left side of Tree
        if current == current.parent.left:
            uncle = current.parent.right
            # Case 1 : Sibling is Red
            if uncle.isRed():
                uncle.color = "BLACK"
                current.parent.color = "RED"
                self.left_rotate(current.parent)
                uncle = current.parent.right
            # Case 2 : Both Nephew and Siblings are black
            if uncle.left.color == "BLACK" and uncle.right.color == "BLACK":
                uncle.color = "RED"
                current = current.parent
            else:
                # Case 3: Red Nephew Opposite Double Black Node
                if uncle.right.color == "BLACK":
                    uncle.left.color = "BLACK"
                    uncle.color = "RED"
                    self.right_rotate(uncle)
                    uncle = current.parent.right

                # Case 4: Red Nephew Same Side as Double Black Node
                uncle.color = current.parent.color
                current.parent.color = "BLACK"
                uncle.right.color = "BLACK"
                self.left_rotate(current.parent)
                current = self.root

        # Right Side of Tree
        else:
            uncle = current.parent.left
            # Case 1
            if uncle.isRed():
                uncle.color = "BLACK"
                current.parent.color = "RED"
                self.right_rotate(current.parent)
                uncle = current.parent.left
            # Case 2
            if uncle.right.color == "BLACK" and uncle.left.color == "BLACK":
                uncle.color = "RED"
                current = current.parent
            else:
                # Case 3
                if uncle.left.color == "BLACK":
                    uncle.right.color = "BLACK"
                    uncle.color = "RED"
                    self.left_rotate(uncle)
                    uncle = current.parent.left
                # Case 4
                uncle.color = current.parent.color
                current.parent.color = "BLACK"
                uncle.left.color = "BLACK"
                self.right_rotate(current.parent)
                current = self.root
    current.color = "BLACK"
```

4 cases:
1. Sibling is Red
2. Both Nephews of Sibling are black
3. Red Nephew opposite of Double Black Node:
4. Red Nephew is aligned on the same side as Double Black Node

##### Successors

```python
def findSuccessor(self, node):
        current = node
        while current.left != self.nil:
            current = current.left
        return current
```

This is a basic function to find the left most node in the subtree