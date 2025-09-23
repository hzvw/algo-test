package com.zhang.leetcode.bak;

import java.util.LinkedList;

/**
 * ClassName: _239_
 * Package: com.zhang.leetcode.bak
 * Description:
 *
 * @Author Harizon
 * @Create 2025/4/20 20:18
 * @Version 1.0
 */
public class _239_ {
    public static void main(String[] args) {


    }

    public int[] maxSlidingWindow(int[] nums, int k){
        int[] res = new int[nums.length-k + 1];
        MyQueue queue = new MyQueue();
        for (int i = 0; i < k; i++) {
            queue.addLast(nums[i]);
        }
        int index = 0;
        res[index++] = queue.getFirst();

        for (int i = k; i < nums.length; i++) {
            int out = nums[i-k];
            int in = nums[i];
            if(out == queue.getFirst()){
                queue.removeFirst();
            }
            queue.addLast(in);
            res[index++] = queue.getFirst();
        }

        return res;
    }

    static class MyQueue {
        LinkedList<Integer> list = new LinkedList<>();

        void addLast(int x){
            while (!list.isEmpty() && x > list.getLast()){
                list.removeLast();
            }
            list.addLast(x);
        }

        int getFirst(){
            return list.getFirst();
        }

        void removeFirst(){
            list.removeFirst();
        }
    }

}
