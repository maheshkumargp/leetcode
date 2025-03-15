package com.mahesh.queue;

import java.util.ArrayList;
import java.util.List;

class MyCircularQueue {

    List<Integer> myQueue;
    int first;
    int last;
    int length;

    public MyCircularQueue(int k) {
        myQueue=new ArrayList<>(k);
        first=-1;
        last=-1;
        length=k;
    }

    public boolean enQueue(int value) {
        int newPos =(last+1)%length;
        if(first==-1 || newPos!=(first+1)){
            last=newPos;
            myQueue.add(last,value);
            return true;
        }
        return false;
    }

    public boolean deQueue() {
        if(first==last) return false;
        first= (first+1)%length;
        return true;

    }

    public int Front() {
        if((first+1<length) && (first+1)>=0 && first<last) return myQueue.get((first+1)%length);
        return -1;

    }

    public int Rear() {
        if(last<length && last>=0) return myQueue.get(last);
        return -1;

    }

    public boolean isEmpty() {
        if(first==last) return false;
        return true;
    }

    public boolean isFull() {
        if(((last+1)%length)==first) return true;
        return false;

    }

    public static void main(String[] args) {
        
          MyCircularQueue obj = new MyCircularQueue(3);
        System.out.println(obj.enQueue(1));
        System.out.println(obj.enQueue(2));
        System.out.println(obj.enQueue(3));
        System.out.println(obj.enQueue(4));
        System.out.println(obj.Rear());
        System.out.println(obj.isFull());
        System.out.println(obj.deQueue());
        System.out.println(obj.enQueue(4));
        System.out.println(obj.Rear());
    }
}