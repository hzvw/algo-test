package com.zhang.leetcode.bak.dp;

public class _08_best_time_to_buy_and_sell_stock_ii {
    public int maxProfit(int[] prices) {
        int profit = 0;

        for(int i = 1; i<prices.length; i++){
            int temp = prices[i] - prices[i-1];
            if(temp > 0){
                profit += temp;
            }
        }
        return profit;
    }

}
