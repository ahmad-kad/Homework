## Topological Sort

### Khans and BFS

    Khan's algorithm and BFS for topological sort is incredibly similar and is effectivly BFS.
    1. Add the 0 degree nodes into a queue
    2. Decrement neighbors
    3. Append any neighbor that reached degree 0 to queue

#### Mapping the degrees
    In order to find which nodes to start from, we must 
```python
def topplogicalSort(graph):
    result = []
    degree = {node : 0 for node in graph}
    for node in graph:
        for neighbor in graph[node]:
            degree[neighbor] += 1
```

##### Kahns

```python
    queue = [node for node in graph if degree[node] == 0]

```

##### No elements in Queue:

If there are no elements in the Queue then there is no 0 in-degree node. No 0 in-degree node indicates a cycle and a non-DAG graph.
Topological Sort only works with DAG graphs.

```python
if not queue:
    return None
```
#### Iterating through Queue
The queue takes the current node and appends the first element into the final sorted array. It then decrements each neighbor's in-degree by one and if equal to zero adds it to the queue. This continues until there is no longer a queue and the elements are sorted topologically.

```python
    while queue:
        current_node = queue.pop(0)
        result.append(current_node)
        for neighbor in graph[current_node]:
            degree[neighbor] -= 1
            if degree[neighbor] == 0:
                queue.append(neighbor)
```
#### Checking Cycles
If all nodes in graph is equal to result, then there is no cycle. Else, a cycle is detected

```python
if len(result) == len(graph):
    return result
else:
    return None
```
### DFS

#### initializiation
```python
    visited = set()
    stack = []
```
Visited: Ensures that the algorithm doesn't revist any nodes during DFS Traversal
Ancestors: Catches cycles. It also prevents false positives in cases where DFS needs to traverse through a junction.
Stack: Stack is required to perform DFS operation.


```python
    def dfs(node, ancestors):
        visited.add(node)
        ancestors.add(node)

        for neighbor in graph[node]:
            if neighbor in ancestors:
                return False
            
            if neighbor not in visited:
                if not dfs(neighbor, ancestors):
                    return False
        
        ancestors.remove(node)
        stack.append(node)
        return True
```
    DFS takes in a node currently being visited and a set containing all previous nodes called ancestors
    It adds to the visted and ancestor set and itereates through the graph
        The ancestor set is to check previously visited within the recusion stack to exit quickly
        If neighhbor isn't in visited then start traversing in that direction
    After exploring all neighbors, it removes the current node from the ancestors set and appends it to the stack.
   


```python
    for node in graph:
        if node not in visited:
            if not dfs(node, set()):
                return False
```

    This loop iterates over each node in the graph and for unvisited node, it calls the dfs function with an new empty set as the ancestors for the new branch.
    If dfs returns False it indicates a cycle and Topological Sort fails

``` python
    return stack[::-1] if stack else False

```

    If there is no false condition, the stack will be organized in reverse order. stack[::-1] will return the sorted array. 