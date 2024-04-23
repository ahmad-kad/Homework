package hw.hw12;

import java.util.*;

public class hw12 {

    // Prim's Algorithm
    public static int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        Set<Integer> mst = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        int minCost = Arrays.stream(wells).min().getAsInt();
        
        Map<Integer, List<int[]>> graph = convertToGraph(n, pipes);
        int start = graph.keySet().iterator().next();
        
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        queue.addAll(graph.get(start));
        
        visited.add(start);

        while (!queue.isEmpty()) {
            int[] edge = queue.poll();
            int house1 = edge[0];
            int house2 = edge[1];
            int cost = edge[2];
            int minWell = Math.min(wells[house1 - 1], wells[house2 - 1]);
            
            if (cost > minWell) {
                System.out.println("Better use the well cost");
                System.out.println(minWell);
                cost = minWell;
            }

            if (!visited.contains(house2)) {
                visited.add(house2);
                mst.add(house1);
                mst.add(house2);
                minCost += cost;

                for (int[] neighborEdge : graph.get(house2)) {
                    int neighbor = neighborEdge[0];
                    int edgeCost = neighborEdge[1];
                    if (!visited.contains(neighbor)) {
                        queue.add(new int[]{house2, neighbor, edgeCost});
                    }
                }
            }
        }

        System.out.println("MST: " + mst);
        return minCost;
    }

    public static Map<Integer, List<int[]>> convertToGraph(int n, int[][] pipes) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] pipe : pipes) {
            int house1 = pipe[0];
            int house2 = pipe[1];
            int cost = pipe[2];
            graph.get(house1).add(new int[]{house2, cost});
            graph.get(house2).add(new int[]{house1, cost});
        }
        return graph;
    }

    public static void main(String[] args) {
        int n = 3;
        int[] wells = {1, 2, 2};
        int[][] pipes = {{1, 2, 1}, {2, 3, 1}};
        System.out.println(minCostToSupplyWater(n, wells, pipes)); // Output: 3
    }
}
