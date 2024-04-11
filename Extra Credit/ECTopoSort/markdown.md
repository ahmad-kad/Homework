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

```python
def topoSortDFS(graph):
    visited = set()
    stack = []
 ```
 ```python   
    def dfs(node):
        visited.add(node)
        for neighbor in graph[node]:
            if neighbor not in visited:
                dfs(neighbor)
        stack.append(node)
```

```python    
    for node in graph:
        if node not in visited:
            dfs(node)
    
    return stack[::-1]
```