package com.zhang.hot100;

/**
 * ClassName: _017_
 * Package: com.zhang.hot100
 * Description:缺失的第一个正数
 *
 * @Author Harizon
 * @Create 2025/2/18 18:29
 * @Version 1.0
 */
public class _017_ {
    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        System.out.println(new _017_().firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] >= 1 && nums[i] <= n && nums[nums[i]-1] != nums[i]){

                System.out.println("i = " + i);
                System.out.println("nums[i] = " + nums[i]);
                System.out.println("nums[i]-1=" + (nums[i] - 1));
                System.out.println("nums[nums[i]-1] = " + nums[nums[i]-1]);
                swap(nums, i, nums[i]-1);
            }
        }
        for (int i = 0; i < n; i++) {
            if((i+1) != nums[i]){
                return i+1;
            }
        }

        return n+1;
    }

    static void swap(int[] nums, int i, int j){
        System.out.println("交换" + i + "--" + j);
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
