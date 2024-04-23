## Problem Statement:

There are n houses in a village. We want to supply water for all the houses by building wells and laying pipes.

Return the minimum total cost to supply water to all houses.

## Overview

The problem requries an MST (Minimum Spanning Tree) in order to keep costs low and keep the graph intact.
We will remove the unecessary edges and keep the shortest connections and hoping to get the lowest cost possible.

We can do this in two greedy ways. Prim's Algorithm and Kruskal's Algorithm.

### Prim's Algorithm

Prim's algorithm does the following:
- traverses through each node marking which node its visited
- then it gets all the node's neighbors and checks whether the cost of the well is cheaper than connecting a pipe and setting to the minimum of both
- then it checks if the nodes have been visited and skips if both nodes are present within the set
- it looks at what the minimum weighted edge and adds it to the queue/MST
- This continues until all nodes are visited.

### Kruskal's Algorithm

Steps:
- Sort the edge list by cost
- Iterate through the edge list and add both nodes to a set of visited nodes and the edge to another array. (another edge list)
- If both nodes are in the visited set, then continue
- This proceeds until all nodes are visited

** Special Note:

Kruskal's algorithm may lead into disjointed sets, where representations like [[1,2,1],[2,3,5],[3,4,1]] will remove the connection form the middle edge thinking its not needed.

In order to fix, we'd need to check for disjointed sets and ensure we don't delete any edges that would connect two graphs together.
