package com.zhang.hot100;

/**
 * ClassName: _077_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/21 17:34
 * @Version 1.0
 */
public class _077_ {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        new _077_().maxProfit(prices);


    }

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][2];
        // dp[i][0] 表示第i天持有股票，手上的最大现金
        // dp[i][1] 表示第i天不持有股票，手上的最大现金
        // 初始化
        dp[0][0] = - prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < n; i++) {
            //买卖股票的最佳时机一，只能买卖一次，所以是0-price[i]
            dp[i][0] = Math.max(dp[i-1][0], 0-prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);
            // 买卖股票最佳时机二，可以买卖多次
            //dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]-prices[i]);
            //dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);
        }
        return Math.max(dp[n-1][0], dp[n-1][1]);
    }

}
