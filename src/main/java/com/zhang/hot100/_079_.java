package com.zhang.hot100;

import java.util.Arrays;

/**
 * ClassName: _079_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/21 23:50
 * @Version 1.0
 */
public class _079_ {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};

        new _079_().jump(nums);


    }

    public int jump(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            int step = nums[i];

            for (int j = 1; j <= step; j++) {
                if(i+j<n) {
                    dp[i+j] = Math.min(dp[i+j], dp[i] + 1);
                }
            }
        }

//        for (int i = 0; i < n; i++) {
//            System.out.print(dp[i] + " ");
//        }

        return dp[n-1];
    }
}
