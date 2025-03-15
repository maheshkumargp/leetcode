package com.mahesh.tree;

import java.util.List;
import java.util.Stack;

public class NumOfIsland {

    public static int numIslands(char[][] grid) {
        Stack<List<Integer>> stack = new Stack<>();

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    stack.push(List.of(i, j));
                }

                while (!stack.isEmpty()) {
                    List<Integer> pair = stack.pop();
                    grid[pair.get(0)][pair.get(1)] = '0';
                    int left = pair.get(0) - 1;
                    int right = pair.get(0) + 1;
                    int up = pair.get(1) - 1;
                    int down = pair.get(1) + 1;
                    if (left >= 0 && grid[left][pair.get(1)] == '1') {
                        stack.push(List.of(left, pair.get(1)));
                    }

                    if (right < grid.length && grid[right][pair.get(1)] == '1') {
                        stack.push(List.of(right, pair.get(1)));
                    }
                    if (up >= 0 && grid[pair.get(0)][up] == '1') {
                        stack.push(List.of(pair.get(0), up));
                    }
                    if (down < grid[0].length && grid[pair.get(0)][down] == '1') {
                        stack.push(List.of(pair.get(0), down));
                    }


                }

            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};

        System.out.println(numIslands(grid));

    }

}
