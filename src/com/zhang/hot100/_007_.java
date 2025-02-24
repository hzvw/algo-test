package com.zhang.hot100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ClassName: _007_
 * Package: com.zhang.hot100
 * Description:接雨水
 *
 * @Author Harizon
 * @Create 2025/2/18 1:51
 * @Version 1.0
 */
public class _007_ {
    public static void main(String[] args) {
        int[] nums = {6,5,3,7,10,1};
        System.out.println(new _007_().trap(nums));
    }


    public int trap(int[] height) {
        int res = 0;
        if(height.length < 2){
            return 0;
        }

        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]){
                int mid = stack.pop();
                if(!stack.isEmpty()){
                    int left = stack.peek();
                    int right = i;
                    res += (right - left - 1) * (Math.min(height[left], height[right]) - height[mid]);
                }
            }
            stack.push(i);
        }
        return res;
    }





}
