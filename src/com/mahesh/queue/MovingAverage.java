package com.mahesh.queue;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {

    int total;
    Queue<Integer> avgQueue;
    int size;

    public MovingAverage(int size) {
        avgQueue = new LinkedList<>();
        this.size = size;
    }

    public double next(int val) {
        if (avgQueue.size() == size) {
            total = total - avgQueue.poll();
            total = total + val;
            avgQueue.offer(val);
        } else {
            total = total + val;
            avgQueue.offer(val);
        }
        return (double) total / avgQueue.size();
    }
}
