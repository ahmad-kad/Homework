package hw.hw07;

import java.util.Arrays;

public class hw07 {
    public static int minServers(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] servers = new int[intervals.length];
        int serverCount = 0;

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            if (serverCount > 0 && servers[serverCount - 1] <= start) {
                serverCount--;
            }
            servers[serverCount++] = end;
        }
        
        return serverCount;
    }

    public static void main(String[] args) {
        int[][] intervals1 = {{0, 1}, {1, 2}, {2, 3}};
        System.out.println(minServers(intervals1));
        
        int[][] intervals2 = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(minServers(intervals2));
    }
}
