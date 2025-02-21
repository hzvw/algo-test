package com.zhang.hot100;

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

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            pq.offer(nums[i]);
        }

        int res = 0;
        for (int i = 0; i < k; i++) {
            res = pq.poll();
        }

        return res;
    }
}
