package com.zhang.hot100;

import java.util.PriorityQueue;

/**
 * ClassName: _215_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/3/7 19:47
 * @Version 1.0
 */
public class _215_ {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
        }

        int res = 0;
        for (int i = 0; i < k; i++) {
            res = pq.poll();
        }
        return res;
    }
}
