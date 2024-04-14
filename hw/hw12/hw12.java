package hw.hw12;

import java.util.*;

public class hw12 {

    // Prim's Algorithm
    public int minCostToSupplyWater1(int n, int[] wells, int[][] pipes) {
        Set<Integer> mst = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        int minCost = Arrays.stream(wells).min().orElse(0);
        
        Map<Integer, List<int[]>> graph = convertToGraph(n, pipes);
        int start = graph.keySet().iterator().next();

        Arrays.sort(wells);
        int minWell = wells[0];
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        queue.add(new int[]{start, start, 0});
        
        visited.add(start);
        
        while (!queue.isEmpty()) {
            int[] edge = queue.poll();
            int house1 = edge[0], house2 = edge[1], cost = edge[2];
            
            if (!visited.contains(house2)) {
                visited.add(house2);
                mst.add(house1 * n + house2);
                minCost += cost;
                
                for (int[] neighbor : graph.get(house2)) {
                    if (!visited.contains(neighbor[0])) {
                        queue.add(new int[]{house2, neighbor[0], neighbor[1]});
                    }
                }
            }
        }
        
        return minCost + minWell;
    }
    

    private Map<Integer, List<int[]>> convertToGraph(int n, int[][] pipes) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i + 1, new ArrayList<>());
        }
        for (int[] pipe : pipes) {
            int house1 = pipe[0], house2 = pipe[1], cost = pipe[2];
            graph.get(house1).add(new int[]{house2, cost});
            graph.get(house2).add(new int[]{house1, cost});
        }
        return graph;
    }

    public static void main(String[] args) {
        hw12 waterSupply = new hw12();
        
        int n = 2;
        int[] wells = {1, 1};
        int[][] pipes = {{1, 2, 1}, {1, 2, 2}};
        
        System.out.println("Prim's Algorithm Minimum Cost: " + waterSupply.minCostToSupplyWater1(n, wells, pipes));
    }
}
