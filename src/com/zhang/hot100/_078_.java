package com.zhang.hot100;

/**
 * ClassName: _078_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/21 23:35
 * @Version 1.0
 */
public class _078_ {
    public boolean canJump(int[] nums) {
        if(nums ==  null || nums.length == 0){
            return false;
        }

        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;

        for (int i = 0; i < n; i++) {
            if(dp[i]){
                int step = nums[i];
                for (int j = 0; j <= step; j++) {
                    if( i+j < n) dp[i+j] = true;
                }
            }
        }

        return dp[n-1];
    }
}
