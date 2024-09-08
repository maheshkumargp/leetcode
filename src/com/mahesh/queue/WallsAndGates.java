package com.mahesh.queue;

import java.util.*;

public class WallsAndGates {
    public static void wallsAndGates(int[][] rooms) {
        int row = rooms.length;
        int col = rooms[0].length;
        ArrayList<Map.Entry<Integer, Integer>> gates = new ArrayList<>();
        ArrayDeque<Map.Entry<Integer, Integer>> arrayDeque = new ArrayDeque<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rooms[i][j] == 0) gates.add(Map.entry(i, j));//arrayDeque.add(Map.entry(i, j));
            }
        }

        gates.forEach(gate -> {
            arrayDeque.add(gate);
            int count = 1;
            Set<Map.Entry<Integer, Integer>> visited = new HashSet<>();
            Map.Entry<Integer, Integer> entry;
            while (!arrayDeque.isEmpty()) {
                int size = arrayDeque.size();
                for (int j = 0; j < size; j++) {
                    Map.Entry<Integer, Integer> pos = arrayDeque.poll();

                    int leftCol = pos.getValue() - 1;
                    entry = Map.entry(pos.getKey(), leftCol);
                    if (leftCol > -1 && rooms[pos.getKey()][leftCol] > 0) {
                        if (!visited.contains(entry)) {
                            visited.add(entry);
                            arrayDeque.add(entry);
                        }
                        rooms[pos.getKey()][leftCol] = Math.min(rooms[pos.getKey()][leftCol], count);
                    }

                    int rightCol = pos.getValue() + 1;
                    entry = Map.entry(pos.getKey(), rightCol);
                    if (rightCol < col && rooms[pos.getKey()][rightCol] > 0) {
                        if (!visited.contains(entry)) {
                            visited.add(entry);
                            arrayDeque.add(entry);
                        }
                        rooms[pos.getKey()][rightCol] = Math.min(rooms[pos.getKey()][rightCol], count);
                    }

                    int bottomRow = pos.getKey() + 1;
                    entry = Map.entry(bottomRow, pos.getValue());
                    if (bottomRow < row && rooms[bottomRow][pos.getValue()] > 0) {
                        if (!visited.contains(entry)) {
                            visited.add(entry);
                            arrayDeque.add(entry);
                        }
                        rooms[bottomRow][pos.getValue()] = Math.min(rooms[bottomRow][pos.getValue()], count);
                    }

                    int topRow = pos.getKey() - 1;
                    entry = Map.entry(topRow, pos.getValue());
                    if (topRow > -1 && rooms[topRow][pos.getValue()] > 0) {
                        if (!visited.contains(entry)) {
                            visited.add(entry);
                            arrayDeque.add(entry);
                        }
                        rooms[topRow][pos.getValue()] = Math.min(rooms[topRow][pos.getValue()], count);
                    }


                }
                count++;
            }
        });

    }

    public static void main(String[] args) {
//        int[][] customArray = {
//                {2147483647, -1, 0, 2147483647},
//                {2147483647, 2147483647, 2147483647, -1},
//                {2147483647, -1, 2147483647, -1},
//                {0, -1, 2147483647, 2147483647}
//        };

        int[][] customArray = {
                {2147483647, -1, 0, 2147483647},
                {2147483647, 2147483647, 2147483647, -1},
                {2147483647, -1, 2147483647, -1},
                {0, -1, 2147483647, 2147483647}};
        int row = customArray.length;
        int col = customArray[0].length;
        wallsAndGates(customArray);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(customArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}
