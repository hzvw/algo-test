package dp;

public class _09_coin_change {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        if(amount < 0 ) return -1;

        int min = Integer.MAX_VALUE;
        for(int i = 0; i<coins.length; i++){
            int t = coinChange(coins, amount-coins[i]);
            if(t == -1) continue;
            if(t < min) min = t;
        }
        return min == Integer.MAX_VALUE ? -1 : min+1;
    }

    int dp(int[] nums, int n){
        int[] dp = new int[n+1];
        dp[0] = 0;

        for(int j = 0; j<dp.length; j++){
            int min = Integer.MAX_VALUE;
            for(int i = 0; i<nums.length; i++){
                if(n-nums[i] < 0) continue;
                int t = dp[n-nums[i]];
                if(t < min) min = t;
            }
            dp[j] = Math.min(dp[j], min);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        _09_coin_change obj = new _09_coin_change();
        int[] coins = {1,2,5};
        int amount = 11;
        int res = obj.coinChange(coins, amount);
        System.out.println(res);
    }



}
