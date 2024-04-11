## B-Trees

B-trees are tree structures where nodes contains multiple keys and children
keys refer to the data itself, like subnodes and children are the children of those keys.

B-Trees are used in databases because it optimizes on calls. B-trees are shorter than other tree types because they contain more data per node.

### Node Structure
```python
class Node:
    def __init__(self,leaf=False):
        self.keys = []
        self.children = []
        self.leaf = leaf
```

#### B-Tree Attributes
```python
    def __init__(self,degree):
        self.root = Node(True)
        self.degree = degree
```

degree refers to the amount of keys present in node.

#### Searching

```python
    def search(self, key, node= Node):
        node = self.root if node == None else node
        i=0
        while i < len(node.keys) and key > node.keys[i]:
            i+=1
        if i < len(node.keys) and key == node.keys[i]:
            return (node,i)
        elif node.leaf:
            return None
        else:
            return self.search(key,node.children[i])
```

To search a B-Tree, we need to iterate through each key and node.
There are 3 cases:
1. Target is within the root node iterate through the root and return the node and its location within it (the array value)
2. Node does not contain key and its a leaf. This indicates value is not present and return nothing
3. If the node contains children, search through each child until found starting from the left of the subtree

#### Insertion

```python
def insert(self,k):
        #degree = self.degree
        root = self.root

        # check if root is full
        if self.isFull(root):
        #if len(root.keys) == (2*degree)-1:
            newRoot = Node()
            self.root = newRoot
            newRoot.children.insert(0,root)
            self.splitChild(newRoot,0)
            self.insertNotFull(newRoot,k)
        else:

            self.insertNotFull(newRoot,k)

```
Inserting nodes can be complicated but can be generalized into two cases.
1. Node is full (the number of keys are equal to the degree)
2. Node is NOT full (basic insert to an array)

##### Inserting into leaf

1. Create a null key as a placeholder for the addition null
2. Use a while loop to shift keys up a value until inserted key is greater

```python
    def insertNotFull(self,x,target):
        i = len(x.keys)-1
        if x.leaf:
            x.keys.append(None)
            while i>=0 and target<x.keys[i]:
                x.keys[i+1] = x.keys[i]
                i-=1
            x.keys[i+1]=target
        else:
            while i>=0 and target < x.keys[i]:
                i-=1
            i+=1

            if self.isFull(x.children[i]):
                self.splitChild(x,i)
                if target > x.keys[i]:
                    i+=1
            self.insertNotFull(x.childen[i],target)
```
#### Checking whether a node is full
```python
    def isFull(self,x):
        i = len(x.keys)-1
        return True if len(x.keys == (2*self.degree)-1) else False
```
This function is used to to check whether a node is full.

#### If the node is full

We split the node into two and set them as the children of adjacent keys
```python
    def splitChild(self,x,i):
        degree = self.degree

        # where y also has full children
        y = x.children[i]

        # add new node to x
        z = Node(y.leaf)
        x.children.insert(i+1,z)

        # get median key of y into x - this removes a full child list into two
        x.keys.insert(i,y.keys[degree-1])

        # split two sides into y and z
        z.keys = y.keys[degree:(2*degree)-1]
        y.keys = y.keys[0:degree-1]

        # reassign childen of y into y and z if not leaf
        if not y.leaf:
            z.children = y.children[degree:2*degree]
            y.children = y.children[0:degree-1]
```

##### Deletion

Deletion requries searching through each node and traversing the through the tree.
Deletion has cases:
1. Delete from Leaf
2. Delete from Internal Node

```python
def delete(self,node,key):
    if node is None:
            return False

    i = 0
    while i < len(node.keys) and key > node.keys[i]:
        i += 1

    if i < len(node.keys) and key == node.keys[i]:
    
        if node is leaf:
            del node.keys[i]
        else:
            if node.children[i].keys:
                #predecessor = get max from left child
                node.keys[i] = predecessor
                delete node from child
            else:
                #successor = get min from right child
                node.keys[i] = successor
                delete node from child

    if node.leaf:
        return false

    if i == len(node.keys):
        child = node.children[i - 1]
    else:
        child = node.children[i]


    if len(affected_child.keys) < self.t:
        #merge with sibling
        if i == len(node.keys) and i > len(child.keys):
            return self.delete(node.children[i - 1], key)
        else:
            return self.delete(node.children[i], key)
    else:
        return self.delete(node.children[i], key)


```