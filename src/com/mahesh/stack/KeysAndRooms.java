package com.mahesh.stack;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;

public class KeysAndRooms {
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> visited = new HashSet<>();
        visited.add(0);
        ArrayDeque<Integer> deque = new ArrayDeque<>(rooms.get(0));
        while (!deque.isEmpty()) {
            Integer popped = deque.pop();
            if (!visited.contains(popped)) {
                visited.add(popped);
                deque.addAll(rooms.get(popped));
            }
        }

        for (int i = 0; i < rooms.size(); i++) {
            if (!visited.contains(i)) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> listOfLists = List.of(
                List.of(1,  3),
                List.of(3,0,1),
                List.of(2),List.of(0)
        );
        System.out.println(canVisitAllRooms(listOfLists));
    }
}
