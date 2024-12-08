package com.mahesh.stack;

import java.util.*;

public class FloodFill {

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Set<Map.Entry<Integer, Integer>> visited = new HashSet<>();
        int row = image.length;
        int col = image[0].length;
        Map.Entry<Integer, Integer> entry = Map.entry(sr, sc);
        ArrayDeque<Map.Entry<Integer, Integer>> arrayDeque = new ArrayDeque<>();
        arrayDeque.add(entry);
        int srcColor = image[sr][sc];
        while (!arrayDeque.isEmpty()) {
            Map.Entry<Integer, Integer> pos = arrayDeque.poll();
            image[pos.getKey()][pos.getValue()] = color;
            int leftCol = pos.getValue() - 1;
            entry = Map.entry(pos.getKey(), leftCol);
            if (leftCol > -1 && image[pos.getKey()][leftCol] == srcColor) {
                if (!visited.contains(entry)) {
                    visited.add(entry);
                    arrayDeque.add(entry);
                }
            }

            int rightCol = pos.getValue() + 1;
            entry = Map.entry(pos.getKey(), rightCol);
            if (rightCol < col && image[pos.getKey()][rightCol] == srcColor) {
                if (!visited.contains(entry)) {
                    visited.add(entry);
                    arrayDeque.add(entry);
                }
            }

            int bottomRow = pos.getKey() + 1;
            entry = Map.entry(bottomRow, pos.getValue());
            if (bottomRow < row && image[bottomRow][pos.getValue()] == srcColor) {
                if (!visited.contains(entry)) {
                    visited.add(entry);
                    arrayDeque.add(entry);
                }
            }

            int topRow = pos.getKey() - 1;
            entry = Map.entry(topRow, pos.getValue());
            if (topRow > -1 && image[topRow][pos.getValue()] == srcColor) {
                if (!visited.contains(entry)) {
                    visited.add(entry);
                    arrayDeque.add(entry);
                }
            }
        }

        return image;
    }

    public static void main(String[] args) {
       // char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
int [][] grid ={{1,1,1},{1,1,0},{1,0,1}};
        int[][] x = floodFill(grid, 1, 1, 2);
        System.out.println(Arrays.deepToString(x));

    }
}
