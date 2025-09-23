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
        int[] nums = {60,20,20,10,30};
        System.out.println(new _007_().trap(nums));
    }


    public int trap(int[] nums) {

        int res = 0;
        LinkedList<Integer> st = new LinkedList<>();
        st.addLast(0);
        for (int i = 1; i < nums.length; i++) {
            while (!st.isEmpty() && nums[i] > nums[st.getLast()]){
                int right = i;
                int mid = st.removeLast();
                if(!st.isEmpty()){
                    int left = st.getLast();

                    res += (Math.min(nums[left], nums[right]) - nums[mid]) * (right-left-1);
                }
            }
            st.addLast(i);
        }
        return res;
    }





}
