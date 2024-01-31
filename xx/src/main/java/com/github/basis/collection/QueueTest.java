package com.github.basis.collection;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueTest {

    public static void main(String[] args) {
        ArrayBlockingQueue<Object> arrayQueue = new ArrayBlockingQueue<Object>(4);
        arrayQueue.add(1);
        arrayQueue.add(2);
        arrayQueue.add(3);
        arrayQueue.offer(4);
        // when space is full return false, and fail to insert an element 
        System.out.println(arrayQueue.offer(5));
        // Inserts the specified element at the tail of this queue, 
        // waiting for space to become available if the queue is full.
//        arrayQueue.put(6);
        System.out.println(arrayQueue);
        System.out.println(arrayQueue.remove());
        System.out.println(arrayQueue.poll());
        System.out.println(arrayQueue.poll());
        System.out.println(arrayQueue.poll());
        // remove function when it is null throw NoSuchElementException 
//        System.out.println(arrayQueue.remove());
        System.out.println(arrayQueue);
        
        LinkedBlockingDeque<Object> linkedQueue = new LinkedBlockingDeque<>();
        linkedQueue.add(1);
        linkedQueue.add(2);
        linkedQueue.add(3);
        System.out.println(linkedQueue);
        System.out.println(linkedQueue.remove());
        System.out.println(linkedQueue.remove());
        System.out.println(linkedQueue);
        
        ConcurrentLinkedQueue<Object> cq = new ConcurrentLinkedQueue<Object>();
        System.out.println(cq);
    }
}
