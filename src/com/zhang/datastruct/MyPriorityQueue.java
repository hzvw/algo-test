package com.zhang.datastruct;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: MyPriorityQueue
 * Package: com.zhang.datastruct
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/23 19:23
 * @Version 1.0
 */
public class MyPriorityQueue {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,5};
        MyPriorityQueue myPriorityQueue = new MyPriorityQueue();
        for (int num : nums) {
            myPriorityQueue.offer(num);
        }
        while (!myPriorityQueue.isEmpty()){
            System.out.println(myPriorityQueue.poll());
        }

    }

    int size = 0;
    LinkedList<Integer> buffer = new LinkedList<>();

    void offer(int num){
        buffer.add(num);
        size++;
        heapInsert(size-1);
    }

    int poll(){
        int res = buffer.get(0);
        swap(0, size-1);
        buffer.removeLast();
        size--;
        heapify(0);
        return res;
    }

    boolean isEmpty(){
        return size == 0;
    }

    private void heapInsert(int i){
        while (buffer.get(i) > buffer.get((i-1)/2)){
            swap(i, (i-1)/2);
            i = (i-1)/2;
        }
    }

    private void heapify(int i){
        int l = i * 2 + 1;
        while (l <size){
            int best = (l+1) < size && buffer.get(l+1) > buffer.get(l) ? (l+1) : l;
            best = buffer.get(best) > buffer.get(i) ? best : i;
            if(best == i){
                break;
            }
            swap(i, best);

            i = best;
            l = i * 2 + 1;
        }
    }

    private void swap(int i , int j){
        int t = buffer.get(i);
        buffer.set(i, buffer.get(j));
        buffer.set(j, t);
    }
}
