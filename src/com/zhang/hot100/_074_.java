package com.zhang.hot100;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * ClassName: _074_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/21 16:30
 * @Version 1.0
 */
public class _074_ {


    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        MyPQ<Integer> tMyPQ = new MyPQ<>((a,b) -> a-b);
        for (int i = 0; i < nums.length; i++) {
            tMyPQ.offer(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(tMyPQ.poll());
        }


    }

    public int findKthLargest(int[] nums, int k) {
        //PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        MyPQ<Integer> myPQ = new MyPQ<>((a,b)-> b-a);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            myPQ.offer(nums[i]);
        }

        int res = 0;
        for (int i = 0; i < k; i++) {
            res = myPQ.poll();
        }

        return res;
    }


    static class MyPQ<T>{
        private ArrayList<T> buffer = new ArrayList<>();
        private int size = 0;

        private Comparator<T> comparator;

        public MyPQ(Comparator<T> comparator) {
            this.comparator = comparator;
        }

        void offer(T t){
            buffer.add(t);
            heapInsert(size);
            size++;
        }

        T poll(){
            T res = buffer.get(0);
            swap(0, size-1);
            size--;
            heapify(0);
            buffer.remove(size);
            return res;
        }

        private void heapInsert(int i){
            while (comparator.compare(buffer.get(i), buffer.get((i-1)/2)) < 0){
                swap(i, (i-1) / 2);
                i = (i-1)/2;
            }
        }

        private void heapify(int i){
            int l = i * 2 + 1;
            while (l < size){
                int best = l + 1 < size && comparator.compare(buffer.get(l+1), buffer.get(l)) < 0 ? l+1 : l;
                best = comparator.compare(buffer.get(best), buffer.get(i)) < 0 ? best : i;
                if(best == i){
                    break;
                }
                swap(best, i);
                i = best;
                l = i * 2 + 1;
            }
        }

        private void swap(int i, int j){
            T t = buffer.get(i);
            buffer.set(i, buffer.get(j));
            buffer.set(j, t);
        }

    }

}
