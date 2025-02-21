package com.zhang.hot100;

import java.util.PriorityQueue;

/**
 * ClassName: _076_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/21 16:56
 * @Version 1.0
 */
public class _076_ {

    class MedianFinder {
        // 小根堆，存较大元素
        PriorityQueue<Integer> minQ = new PriorityQueue<>();

        //大根堆，存较小元素
        PriorityQueue<Integer> maxQ = new PriorityQueue<>((a, b) -> b-a);


        public MedianFinder() {

        }

        public void addNum(int num) {
            maxQ.offer(num);
            minQ.offer(maxQ.poll());
            if(minQ.size() - maxQ.size() > 1){
                maxQ.offer(minQ.poll());
            }
        }

        public double findMedian() {
            return minQ.size() == maxQ.size() ? (minQ.peek() + maxQ.peek()) / 2.0 : minQ.peek();
        }
    }
}
