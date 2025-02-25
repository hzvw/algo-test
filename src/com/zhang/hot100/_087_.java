package com.zhang.hot100;

import java.util.Arrays;

/**
 * ClassName: _087_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/22 14:03
 * @Version 1.0
 */
public class _087_ {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        new _087_().lengthOfLIS(nums);

    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        //dp[i]表示i之前包括i的以nums[i]结尾的最长递增子序列的长度
        for (int i = 1; i < n ; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public int lengthOfLIS2(int[] nums) {
        int[] dp= new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i <nums.length ; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
