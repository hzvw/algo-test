package com.zhang.hot100;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * ClassName: _072_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/21 3:17
 * @Version 1.0
 */
public class _072_ {
    public int[] dailyTemperatures(int[] nums) {
        Deque<Integer> st = new LinkedList<>();
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            while(!st.isEmpty() && nums[i] > nums[st.peek()]){
                int left = st.pop();
                result[left] = i - left;
            }
            st.push(i);
        }
        return result;
    }
}
