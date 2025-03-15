package com.mahesh.queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WallsAndGates_2 {

    public static void wallsAndGates(int[][] rooms) {
        Queue<List<Integer>> myQueue = new LinkedList<>();
        int rowLength = rooms.length;
        int colLength = rooms[0].length;

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (rooms[i][j] == 0) myQueue.offer(List.of(i, j));
            }
        }

        int count = 1;

        while (!myQueue.isEmpty()) {
            int size = myQueue.size();
            for (int i = 0; i < size; i++) {
                List<Integer> curr = myQueue.poll();
                Integer y = curr.get(1);
                Integer x = curr.get(0);

                int left = x - 1;
                if (left >= 0) {
                    int leftNode = rooms[left][y];
                    if (leftNode != 0 && leftNode != -1 && leftNode > count) {
                        rooms[left][y] = count;
                        myQueue.offer(List.of(left, y));
                    }
                }

                int right = x + 1;
                if (right < rowLength) {
                    int rightNode = rooms[right][y];
                    if (rightNode != 0 && rightNode != -1 && rightNode > count) {
                        rooms[right][y] = count;
                        myQueue.offer(List.of(right, y));
                    }
                }

                int up = y - 1;
                if (up >= 0) {
                    int upNode = rooms[x][up];
                    if (upNode != 0 && upNode != -1 && upNode > count) {
                        rooms[x][up] = count;
                        myQueue.offer(List.of(x, up));
                    }
                }

                int down = y+1;
                if(down<colLength){
                    int downNode=rooms[x][down];
                    if(downNode!=0 && downNode!=-1 && downNode>count){
                        rooms[x][down]=count;
                        myQueue.offer(List.of(x,down));
                    }
                }
            }
            count++;
        }
    }

    public static void main(String[] args) {
        int[][] customArray1 = {
                {2147483647, -1, 0, 2147483647},
                {2147483647, 2147483647, 2147483647, -1},
                {2147483647, -1, 2147483647, -1},
                {0, -1, 2147483647, 2147483647}
        };

        int[][] customArray = {
                {2147483647, -1, 0, 2147483647},
                {2147483647, 2147483647, 2147483647, -1},
                {2147483647, -1, 2147483647, -1},
                {0, -1, 2147483647, 2147483647}};
        int row = customArray.length;
        int col = customArray[0].length;
        wallsAndGates(customArray);
        for (int[] ints : customArray) {
            for (int j = 0; j < col; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

}
