package hw.hw12;

import java.util.*;

public class hw12 {
    public static int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        Set<Integer> mst = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        int minCost = Arrays.stream(wells).min().getAsInt();

        Map<Integer, List<int[]>> graph = convertToGraph(n, pipes);
        int start = graph.keySet().iterator().next();

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        for (int[] neighbor : graph.get(start)) {
            queue.offer(new int[]{start, neighbor[0], neighbor[1]});
        }
        visited.add(start);

        while (!queue.isEmpty()) {
            int[] edge = queue.poll();
            int house1 = edge[0];
            int house2 = edge[1];
            int cost = edge[2];

            if (!visited.contains(house2)) {
                visited.add(house2);
                mst.add(Arrays.hashCode(new int[]{house1, house2, cost}));
                minCost += cost;

                for (int[] neighbor : graph.get(house2)) {
                    if (!visited.contains(neighbor[0])) {
                        queue.offer(new int[]{house2, neighbor[0], neighbor[1]});
                    }
                }
            }
        }

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
        int n = 2;
        int[] wells = {1, 1};
        int[][] pipes = {{1, 2, 1}, {1, 2, 2}};
        System.out.println(minCostToSupplyWater(n, wells, pipes));
    }
}
