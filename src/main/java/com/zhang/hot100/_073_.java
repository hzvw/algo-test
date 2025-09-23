package com.zhang.hot100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ClassName: _073_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/21 14:14
 * @Version 1.0
 */
public class _073_ {
    public static void main(String[] args) {
        int[] nums = {2,1,5,6,2,3};
        System.out.println(new _073_().largestRectangleArea(nums));
    }

    public int largestRectangleArea(int[] heights) {
        int res = 0;
        int n = heights.length;
        Deque<Integer> st = new LinkedList<>();
        int[] nums = new int[n+2];
        for (int i = 0; i < n; i++) {
            nums[i+1] = heights[i];
        }
        // 单调增栈
        for (int i = 0; i < n+2; i++) {
            while (!st.isEmpty() && nums[i] < nums[st.peek()]){
                int right = i;
                int mid = st.pop();
                if(!st.isEmpty()){
                    int left = st.peek();
                    res = Math.max(res, nums[mid] * (right - left - 1));
                }
            }
            st.push(i);
        }
        return res;
    }


}
