### Lab 06

#### Problem Statement:

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.

Return true if you can finish all courses. Otherwise, return false.

In order to solve, we need to ensure there is no circular dependencies within a course structure. Each class represents a node and points to a course that points to its pre requisites.

This describes a graph strcture where each node can point to any other node, but that node and its descendants cannot point to the initial node. There we can use topological sort to return whether a cycle exists in a graph.

#### Initialize indegree and graph

The in-degree is a hashmap of key:value pairs initalized to 0, of all nodes within the graph.
The graph converts the edge list into a key:value list

```python
def canFinish(numCourses, prerequisites):
    indegree = {node: 0 for node in range(numCourses)}
    graph = {i: [] for i in range(numCourses)}
```
From there we create the indegree and graph list to use for later
The queue is initialized with every course that has an indegree of 0

```python
    for course, prereq in prerequisites:
        graph[course].append(prereq)
        indegree[prereq] += 1

    queue = [course for course in indegree if indegree[course] == 0]
    completed = 0

```

Then we traverse through the queue decrementing the indegree neighbor nodes by one and append it if it reaches 0.

```python
    while queue:
        current_course = queue.pop(0)
        completed += 1

        for neighbor in graph[current_course]:
            indegree[neighbor] -= 1
            if indegree[neighbor] == 0:
                queue.append(neighbor)

```

Once its done, we should be able to determine whether it went through the whole graph.

```python
    return completed == numCourses

```