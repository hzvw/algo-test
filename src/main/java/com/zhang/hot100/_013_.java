package com.zhang.hot100;

import java.util.Arrays;

/**
 * ClassName: _013_
 * Package: com.zhang.hot100
 * Description:最大子数组和
 *
 * @Author Harizon
 * @Create 2025/2/18 17:02
 * @Version 1.0
 */
public class _013_ {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3};
        System.out.println(new _013_().maxSubArray(nums));

    }

    public int maxSubArray(int[] nums) {
        int res  = 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
        }
        res = Arrays.stream(dp).max().getAsInt();
        return res;
    }

}
