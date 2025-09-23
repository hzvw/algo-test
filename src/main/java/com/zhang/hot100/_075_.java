package com.zhang.hot100;

import java.util.*;

/**
 * ClassName: _075_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/21 16:47
 * @Version 1.0
 */
public class _075_ {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        for (Integer key : count.keySet()) {
            int value = count.get(key);
            if(pq.size() < k){
                pq.offer(new int[]{key, value});
            }else{
                int[] top = pq.peek();
                if(value > top[1]){
                    pq.poll();
                    pq.offer(new int[]{key, value});
                }
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll()[0];
        }
        return res;
    }
}
