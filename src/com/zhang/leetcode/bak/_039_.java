package com.zhang.leetcode.bak;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ClassName: _039_
 * Package: com.zhang.leetcode.bak
 * Description:
 *
 * @Author Harizon
 * @Create 2025/4/20 19:41
 * @Version 1.0
 */
public class _039_ {
    public static void main(String[] args) {
        int[] heihgts = {60, 20, 20, 10, 30};
        System.out.println(new _039_().largestRectangleArea(heihgts));
    }


    public int largestRectangleArea(int[] heights) {
        Deque<Integer> st = new LinkedList<>();

        int n = heights.length;
        int[] nums = new int[n+2];
        for (int i = 1; i <= n ; i++) {
            nums[i] = heights[i-1];
        }

        st.push(0);

        int res = 0;
        // 单增栈
        for (int i = 1; i < n+2; i++) {
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
