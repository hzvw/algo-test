package com.zhang.hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: _011_
 * Package: com.zhang.hot100
 * Description:滑动窗口最大值
 *
 * @Author Harizon
 * @Create 2025/2/18 16:36
 * @Version 1.0
 */
public class _011_ {
    public static void main(String[] args) {


    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        MyQueue myQueue = new MyQueue();
        for (int i = 0; i < k; i++) {
            myQueue.offer(nums[i]);
        }
        list.add(myQueue.getFirst());

        for (int i = k; i < nums.length; i++) {
            int in = nums[i];
            int out = nums[i-k];
            if(out == myQueue.getFirst()){
                myQueue.removeFirst();
            }
            myQueue.offer(in);
            list.add(myQueue.getFirst());
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    static class MyQueue{
        LinkedList<Integer> queue = new LinkedList<>();

        public MyQueue(){
        }

        void offer(int ele){
            while (!queue.isEmpty() && ele > queue.getLast()){
                queue.removeLast();
            }
            queue.addLast(ele);
        }

        int pop(){
            return queue.removeFirst();
        }

        int getFirst(){
            return queue.getFirst();
        }

        void removeFirst(){
            queue.removeFirst();
        }




    }




}
