

import java.util.LinkedList;
import java.util.Queue;

public class hw11 {

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            System.out.println("unchanged");
            return image;
        }

        int originalColor = image[sr][sc];
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});

        while (!queue.isEmpty()) {
            int[] currentPixel = queue.poll();
            int x = currentPixel[0];
            int y = currentPixel[1];

            if (x < 0 || x >= image.length || y < 0 || y >= image[0].length || image[x][y] != originalColor) {
                continue;
            }

            image[x][y] = newColor;

            for (int[] dir : directions) {
                queue.add(new int[]{x + dir[0], y + dir[1]});
            }
        }

        return image;
    }
    public static void printFloodedMatrix(String label, int[][] originalImage, int sr, int sc, int color) {
        System.out.println(label + ":\nOriginal Matrix:");
        printMatrix(originalImage);
        int[][] floodedImage = floodFill(originalImage, sr, sc, color);
        System.out.println("\nFlooded Matrix:");
        printMatrix(floodedImage);
        System.out.println("");
    }
    
    public static void printMatrix(int[][] image) {
        for (int[] row : image) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] image1 = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr1 = 1, sc1 = 1, color1 = 2;
    
        printFloodedMatrix("Case 1", image1, sr1, sc1, color1);
    
        int[][] image2 = {{0, 1, 2}, {0, 4, 5}, {0, 7, 8}};
        int sr2 = 0, sc2 = 0, color2 = 1;
    
        printFloodedMatrix("Case 2", image2, sr2, sc2, color2);
    
        int[][] image3 = {{0, 0, 0}, {0, 0, 0}};
        int sr3 = 0, sc3 = 0, color3 = 1;
    
        printFloodedMatrix("Case 3", image3, sr3, sc3, color3);
    }
    
    
    
}
