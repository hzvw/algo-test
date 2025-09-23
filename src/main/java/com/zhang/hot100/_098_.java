package com.zhang.hot100;

import java.beans.EventHandler;

/**
 * ClassName: _098_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/22 20:25
 * @Version 1.0
 */
public class _098_ {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        new _098_().sortColors(nums);
    }

    public void sortColors(int[] nums) {
        int n = nums.length;
        int a = 0;
        for (int i = 0; i < n; i++) {
            if(nums[i] == 0){
                swap(nums, i, a);
                a++;
            }
        }
        a = n-1;
        for (int i = n-1; i >= 0; i--) {
            if(nums[i] == 2){
                swap(nums, i, a);
                a--;
            }
        }
    }

    void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
