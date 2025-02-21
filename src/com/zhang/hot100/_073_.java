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

    public int largestRectangleArea2(int[] heights) {
        int res = 0;
        Deque<Integer> stack = new LinkedList<>();

        int n = heights.length;
        for (int i = 0; i < n; i++) {
            int h = heights[i];
            while (!stack.isEmpty() && h < heights[stack.peek()]){
                res = Math.max(res, heights[stack.pop()] * (stack.isEmpty() ? i : (i - stack.peek() - 1)));
            }
            stack.push(i);
        }

        while (!stack.isEmpty()){
            res = Math.max(res, heights[stack.pop()] * (stack.isEmpty() ? n : n - stack.peek() - 1));
        }
        return res;
    }


    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> stack = new LinkedList<>();// 维护单调递增栈
        int maxs = Integer.MIN_VALUE;
        // 从左往右考虑
        for(int i=0; i<n; i++){
            // 从右往左考虑可以出栈的元素
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                int curh = heights[stack.pop()];
                // 处理相同高度的情况，相同高度的矩形一起考虑
                while(!stack.isEmpty() && heights[stack.peek()] == curh){
                    stack.pop();
                }
                int width = 0;
                if(stack.isEmpty()){// 当前高度是目前为止所有矩形中最低的，计算整个宽度
                    width = i;
                }else{
                    width = i - stack.peek() - 1;// 计算矩形的宽度
                }
                maxs = Math.max(maxs, width * curh);
            }
            // 最新高度进栈
            stack.push(i);
        }
        // 假设数组中有第n个矩形，它的高度为0
        while(!stack.isEmpty()){
            int curh = heights[stack.pop()];
            // 处理相同高度
            while(!stack.isEmpty() && heights[stack.peek()] == curh){
                stack.pop();
            }
            int width = 0;
            if(stack.isEmpty()){// 当前高度是目前为止所有矩形中最低的，计算整个宽度
                width = n;
            }else{
                width = n - stack.peek() - 1;// 计算矩形的宽度
            }
            maxs = Math.max(maxs, width * curh);
        }
        return maxs;
    }
}
