# AVL Trees

AVL trees is another type of self-balancing binary search trees anmed avter Adelson-Velsky and Landis.
It creates a height attribute in the node where after a reaching a certain threshold (+- 2) nodes will automatically shift

#### Node Class
```python
class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None
        self.height = 1
```
The node class is simple its initialized to 1 with left and right attributes

### Functions


#### Search - Traversal
Searching and Traversing through an AVL tree is no different from Binary Search Trees
```python
def search(self, target):
    #print("search")
    current = self.root
    while current:
        if current.value == target:
            return current
        elif current.value > target:
            current = current.left
        else:
            current = current.right
    return None 

def traversal(self,node):
    #print("traversal")
    if node:
        print(node.value, end=" ")
        self.traversal(node.left)
        self.traversal(node.right)    
```

#### Insert


```python
    def insert(self,node,value):
        #print("insert")

        if not node:
            return Node(value)
        
        # Insert left or right
        if value < node.value:
            node.left = self.insert(node.left,value)
        else:
            node.right = self.insert(node.right,value)

        # Updates height to calculate balance
        node.height = 1 + max(self.getHeight(node.left), self.getHeight(node.right))
        balance = self.getBalance(node)

        # Check if require balance
        if balance > 1:
            if value <  node.left.value:
                return self.rotateRight(node)
            else:
                return self.rotateLeftRight(node)
        if balance < -1:
            if value > node.right.value:
                return self.rotateLeft(node)
            else:
                return self.rotateRightLeft(node)
            
        return node     
```
Nodes are inserted the same way but it updates height and calculates the balance of the node.
There are 4 cases depending on the structure of nodes:
1. Rotate Right 
2. Rotate Left
3. Rotate Right Left
4. Rotate Right

Rotating nodes is straightfoward. Get the middle node from and set it as the parent. The parent becomes the node's left. Then update the height.

```python
    def rotateLeft(self,x):
        #print("Left Rotation")
        y = x.right
        tmp = y.left
        y.left = x
        x.right = tmp

        x.height = 1 + max(self.getHeight(x.left), self.getHeight(x.right))
        y.height = 1 + max(self.getHeight(y.left), self.getHeight(y.right))

        return y

    def rotateRight(self,y):
        #print("Right Rotation")
        x = y.left
        tmp = x.right
        x.right = y
        y.left = tmp

        x.height = 1 + max(self.getHeight(x.left), self.getHeight(x.right))
        y.height = 1 + max(self.getHeight(y.left), self.getHeight(y.right))

        return x

    def rotateLeftRight(self,node):
        node.left = self.rotateLeft(node.left)
        return self.rotateRight(node)

    def rotateRightLeft(self,node):
        node.right = self.rotateRight(node.right)
        return self.rotateLeft(node)
```

##### Getting balance
```python
    def getBalance(self,node):
        #print("Get Balance")
        return self.getHeight(node.left) - self.getHeight(node.right) if node else 0
```


#### Removal

```python
    def delete(self,node,value):
        #print("delete")
        if not node:
            return None
        if value < node.value:
            node.left = self.delete(node.left,value)
        elif value > node.value:
            node.right = self.delete(node.right,value)
        else:
            if not node.left or not node.right:
                if not node.left:
                    return node.right
                else:
                    return node.left
            else:
                child = self.findMin(node.right)
                node.value = child.value
                node.right = self.delete(node.right,child.value)

        node.height = 1 + max(self.getHeight(node.left),self.getHeight(node.right))
        balance = self.getBalance(node)

        if balance > 1:
            if self.getBalance(node.left) >= 0:
                return self.rotateRight(node)
            else:
                return self.rotateLeftRight(node)
        if balance < -1:
            if self.getBalance(node.right) <= 0:
                return self.rotateLeft(node)
            else:
                node.right = self.rotateRight(Node)
                return self.rotateRightLeft(node)
        
        return node
```

There are two cases:
1. One child - resulting in replacing node with child node
2. Two children - replace the node with the smalled node (traversing to the leftmost positon of the subtree)

Then we ensure balance is correct and balance if its not.

```python
    def getHeight(self, node):
        #print("Get Height")
        return node.height if node else 0

    def findMin(self,node):
        while node.left:
            node = node.left
        return node
```