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
        List<Integer> res = new ArrayList<>();
        MyQueue queue = new MyQueue();
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        res.add(queue.getFirst());

        int j = k;
        while (j < nums.length){
            int in = nums[j];
            int out = nums[j-k];
            if(out == queue.getFirst()){
                queue.removeFirst();
            }
            queue.add(in);

            res.add(queue.getFirst());
            j++;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 单调减队列，从头到尾是减的，所以头放的是最大值
     */
    static class MyQueue{
        LinkedList<Integer> buffer = new LinkedList<>();

        public void add(int ele){
            while(!buffer.isEmpty() && ele > buffer.getLast()){
                buffer.removeLast();
            }
            buffer.add(ele);
        }

        public int getFirst(){
            return buffer.getFirst();
        }

        public void removeFirst(){
            buffer.removeFirst();
        }


    }


}
