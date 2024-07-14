package com.mahesh.sliding.window;

import java.util.LinkedList;
import java.util.Queue;

class MovingAverage {

    int slidingWindowSize;
    Queue<Integer> queue;
    int currentSize;
    double currTotal;

    public MovingAverage(int size) {
        this.slidingWindowSize = size;
        this.queue = new LinkedList<>();
        this.currentSize = 0;
        this.currTotal = 0;
    }

    public double next(int val) {
        if (currentSize < slidingWindowSize) {
            queue.add(val);
            currTotal = currTotal + val;
            currentSize++;

        } else {
            int removed = queue.poll();
            queue.add(val);
            currTotal = currTotal - removed + val;


        }
        return (currTotal / currentSize);
    }

    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println(movingAverage.next(1)); // return 1.0 = 1 / 1
        System.out.println(movingAverage.next(10)); // return 5.5 = (1 + 10) / 2
        System.out.println(movingAverage.next(3)); // return 4.66667 = (1 + 10 + 3) / 3
        System.out.println(movingAverage.next(5)); // return 6.0 = (10 + 3 + 5) / 3
    }
}