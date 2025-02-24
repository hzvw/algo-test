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
        int[] nums = new int[n+2];
        for (int i = 0; i < n; i++) {
            nums[i+1] = heights[i];
        }

        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n+2; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]){
                int mid = stack.pop();
                int left = stack.peek();
                int right = i;
                res = Math.max(res, (right - left -1) * nums[mid]);
            }
            stack.push(i);
        }

        return res;
    }


}
