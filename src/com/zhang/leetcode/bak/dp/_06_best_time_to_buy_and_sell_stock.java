package dp;

/**
 *
 * 2022-01-21
 * 买卖股票的最佳时机
 *
 */
public class _06_best_time_to_buy_and_sell_stock {

    public int maxProfit(int[] prices) {
        int max = 0;
        int min = prices[0];
        for(int i = 1; i<prices.length; i++){
            if(prices[i] - min > max){
                max = prices[i] - min;
            }
            if(prices[i] < min){
                min = prices[i];
            }
        }
        return max;
    }
}
