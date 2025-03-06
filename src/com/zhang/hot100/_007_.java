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
        int[] nums = {60,30,30,10,70};
        System.out.println(new _007_().trap(nums));
    }


    public int trap(int[] height) {
        int res = 0;
        Deque<Integer> st = new LinkedList<>();
        st.push(0);
        for (int i = 1; i < height.length; i++) {
            while (!st.isEmpty() && height[i] > height[st.peek()]){
                int right = i;
                int mid = st.pop();
                if(!st.isEmpty()){
                    int left = st.peek();
                    res += (right-left-1) * (Math.min(height[left], height[right]) - height[mid]);
                }
            }
            st.push(i);
        }

        return res;
    }





}
