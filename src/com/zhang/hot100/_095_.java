package com.zhang.hot100;

/**
 * ClassName: _095_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/22 19:38
 * @Version 1.0
 */
public class _095_ {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m+1][n+1];

        for (int j = 0; j < n+1; j++) {
            dp[0][j] = j;
        }
        for (int i = 0; i < m+1; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j]  = min(dp[i-1][j-1] + 1, dp[i-1][j] + 1, dp[i][j-1] + 1);
                }
            }
        }

        return dp[m][n];
    }

    int min(int a, int b, int c){
        return Math.min(Math.min(a,b), c);
    }

}
