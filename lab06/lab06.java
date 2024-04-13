package lab06;
import java.util.*;

public class lab06 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            indegree.put(i, 0);
            graph.put(i, new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            graph.get(course).add(prereq);
            indegree.put(prereq, indegree.get(prereq) + 1);
        }
        System.out.println("Graph: " + graph);
        System.out.println("Indegrees: " + indegree);

        // creates the queue starting from 0 in degrees
        Queue<Integer> queue = new LinkedList<>();
        for (int course : indegree.keySet()) {
            if (indegree.get(course) == 0) {
                queue.offer(course);
            }
        }

        int completed = 0;

        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            completed++;

            for (int neighbor : graph.get(currentCourse)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return completed == numCourses;
    }

    public static void main(String[] args) {
        lab06 cs = new lab06();
        int numCourses = 2;
        int[][] prerequisites = {{0,1}};
        System.out.println(cs.canFinish(numCourses, prerequisites)); // Output: true
    }
}
