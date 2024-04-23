#!/usr/bin/env python
# coding: utf-8

# In[101]:


# Prim's algorithm

from typing import List
import heapq

def minCostToSupplyWater(n: int, wells: List[int], pipes: List[List[int]]) -> int:
    mst  = set()
    visited = set()
    minCost = min(wells)
    
    graph = convertToGraph(n,pipes)
    start = list(graph.keys())[0]
    
    queue = [(start, neighbor,cost) for neighbor, cost in graph[start]]
    heapq.heapify(queue)
    
    visited.add(start)

    while queue:
        house1, house2, cost  = heapq.heappop(queue)
        minWell = min(wells[house1-1],wells[house2-1])
        
        if cost > minWell:
            print("Better use the well cost")
            print(minWell)
            cost = minWell

        if house2 not in visited: 
            visited.add(house2) 
            mst.add((house1, house2, cost)) 
            minCost += cost  
            
            for neighbor, edge_cost in graph[house2]:
                if neighbor not in visited:
                    heapq.heappush(queue, (house2, neighbor,edge_cost))
    
    print(f"MST: {mst}")
    return minCost
    

def convertToGraph(n, pipes):
    graph = {i + 1: [] for i in range(n)}
    for pipe in pipes:
        house1, house2, cost = pipe
        graph[house1].append((house2, cost))
        graph[house2].append((house1, cost))
    return graph


# In[102]:


n = 2
wells = [1,1]
pipes = [[1,2,3],[1,2,4]]

minCostToSupplyWater(n,wells,pipes)


# In[103]:


def quicksort(pipes):
    if len(pipes) <= 1:
        return pipes
    pivot = pipes[len(pipes) // 2][-1]
    left = [pipe for pipe in pipes if pipe[-1] < pivot]
    middle = [pipe for pipe in pipes if pipe[-1] == pivot]
    right = [pipe for pipe in pipes if pipe[-1] > pivot]
    return quicksort(left) + middle + quicksort(right)


# In[104]:


# Kruskal's algoirthm using quicksort
def minCostToSupplyWater2(n: int, wells: List[int], pipes: List[List[int]]) -> int:
    visited = set()
    sortedList = quicksort(pipes)
    mst = []

    for x in sortedList:
        if x[0] and x[1] not in visited:
            visited.add(x[0])
            visited.add(x[1])
            mst.append(x)

    print(f"MST : {mst}")
    total = 0
    total += sum(x[-1] for x in mst) + min(wells)

    #print(sortedList)
    #print(mst)
    #print(total)
    return total


# In[105]:


n = 3
wells = [1,1,1]
pipes = [[1,2,1],[1,2,2],[2,3,1],[3,1,5]]

minCostToSupplyWater(n,wells,pipes)


# In[106]:


# Test Case
n = 2
wells = [1,1]
pipes = [[1,2,1],[1,2,2]]

minCostToSupplyWater2(n,wells,pipes)


# In[107]:


# Single Case
n = 1
wells = [1]
pipes = []

minCostToSupplyWater(n,wells,pipes)


# In[108]:


n = 4
wells = [1, 2, 3, 4]
pipes = [[1, 2, 1], [2, 3, 2], [3, 4, 3]]

minCostToSupplyWater(n,wells,pipes)


# In[109]:


# Uneven well cost
n = 4
wells = [1, 2, 3, 4]
pipes = [[1, 2, 1], [1, 3, 1], [2, 4, 1], [3, 4, 1]]

minCostToSupplyWater(n,wells,pipes)


# In[110]:


get_ipython().system('jupyter nbconvert --to script hw12.ipynb')

