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
        int[] res = new int[nums.length];
        LinkedList<Integer> st = new LinkedList<>();

        // 单减栈
        st.addLast(0);
        for (int i = 1; i < nums.length; i++) {
            while (!st.isEmpty() && nums[i] > nums[st.getLast()]){
                int right = i;
                int left = st.removeLast();
                res[left] = right-left;
            }
            st.addLast(i);
        }
        return res;
    }
}
