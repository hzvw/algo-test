package com.zhang.leetcode.bak;

/**
 * ClassName: _213_
 * Package: com.zhang.leetcode.bak
 * Description:https://leetcode.cn/problems/house-robber-ii/description/
 *打家劫舍二
 * @Author Harizon
 * @Create 2025/2/15 23:28
 * @Version 1.0
 */
public class _213_ {
    public static void main(String[] args) {

        int ans = new _213_().rob(new int[]{1,2,3,1});
        System.out.println(ans);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        if(n == 2){
            return Math.max(nums[0], nums[1]);
        }

        int[] dp1 = new int[n-1];
        int[] dp2 = new int[n-1];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n-1; i++) {
            dp1[i] = Math.max(dp1[i-1], nums[i] + dp1[i-2]);
        }

        dp2[0] = nums[1];
        dp2[1] = Math.max(nums[1], nums[2]);
        for (int i = 2; i < n-1; i++) {
            int num = nums[i+1];
            dp2[i] = Math.max(dp2[i-1], num + dp2[i-2]);
        }
        return Math.max(dp1[n-2], dp2[n-2]);
    }

}
