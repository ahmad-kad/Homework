Write a small markdown file explaining the high-level approach(es) you used to solve the above problem. 

## High-level approaches
Steps taken:
- Create BST
- Add a function to find the specific node
- Compare sides of nodes (p,q)
- Search that side until both nodes are on separate sides or if one is a root node

### Recursive
Find the values of p and q within the node through **traversal**
### Check conditions:
 - if p and q are on the same side of the tree, *call the function* recusively on that side.
 - if p and q are on opposites sides of the tree, return root


### Iterative
Find the values of p and q within the node through **traversal**
####Check conditions:
 - if p and q are on the same side of the tree, *move* root to that side
 - if p and q are on opposites sides of the tree, return root