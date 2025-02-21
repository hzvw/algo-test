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
        List<int[]> list = new ArrayList<>();
        for (Integer key : count.keySet()) {
            list.add(new int[]{key, count.get(key)});
        }

        list.sort((a,b) -> b[1]-a[1]);

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i)[0];
        }

        return res;
    }
}
