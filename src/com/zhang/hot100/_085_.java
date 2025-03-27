package com.zhang.hot100;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

/**
 * ClassName: _085_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/22 1:38
 * @Version 1.0
 */
public class _085_ {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0){
            return 0;
        }

        if(coins == null || coins.length == 0){
            return 0;
        }

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if(dp[j-coins[i]] != Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j], dp[j-coins[i]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public int coinChange2(int[] coins, int amount) {
        if (amount == 0){
            return 0;
        }

        if(coins == null || coins.length == 0){
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        int n = coins.length;
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= amount ; j++) {
                if(dp[j - coins[i]] != Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j], dp[j-coins[i]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] nums = {186,419,83,408};
        int amount = 6249;
        new _085_().coinChange2(nums, amount);

    }

}
