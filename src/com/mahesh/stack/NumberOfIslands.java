package com.mahesh.stack;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NumberOfIslands {

    public static int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        Set<Map.Entry<Integer, Integer>> visited = new HashSet<>();
        Map.Entry<Integer, Integer> entry;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                entry = Map.entry(i, j);
                if (grid[i][j] == '1' && !visited.contains(entry)) {
                    visited.add(entry);
                    runBFS(entry, visited, grid, row, col);
                    count++;
                }
            }
        }
        return count;
    }

    private static void runBFS(Map.Entry<Integer, Integer> entry, Set<Map.Entry<Integer, Integer>> visited, char[][] grid, int row, int col) {
        ArrayDeque<Map.Entry<Integer, Integer>> arrayDeque = new ArrayDeque<>();
        arrayDeque.add(entry);
        while (!arrayDeque.isEmpty()) {
            Map.Entry<Integer, Integer> pos = arrayDeque.poll();

            int leftCol = pos.getValue() - 1;
            entry = Map.entry(pos.getKey(), leftCol);
            if (leftCol > -1 && grid[pos.getKey()][leftCol] == '1') {
                if (!visited.contains(entry)) {
                    visited.add(entry);
                    arrayDeque.add(entry);
                }
            }

            int rightCol = pos.getValue() + 1;
            entry = Map.entry(pos.getKey(), rightCol);
            if (rightCol < col && grid[pos.getKey()][rightCol] == '1') {
                if (!visited.contains(entry)) {
                    visited.add(entry);
                    arrayDeque.add(entry);
                }
            }

            int bottomRow = pos.getKey() + 1;
            entry = Map.entry(bottomRow, pos.getValue());
            if (bottomRow < row && grid[bottomRow][pos.getValue()] == '1') {
                if (!visited.contains(entry)) {
                    visited.add(entry);
                    arrayDeque.add(entry);
                }
            }

            int topRow = pos.getKey() - 1;
            entry = Map.entry(topRow, pos.getValue());
            if (topRow > -1 && grid[topRow][pos.getValue()] == '1') {
                if (!visited.contains(entry)) {
                    visited.add(entry);
                    arrayDeque.add(entry);
                }
            }
        }

    }

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};

        System.out.println(numIslands(grid));

    }

}
