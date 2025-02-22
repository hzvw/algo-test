package com.zhang.hot100;

/**
 * ClassName: _094_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/22 19:20
 * @Version 1.0
 */
public class _094_ {
    public static void main(String[] args) {
        String text1 = "bsbininm";
        String text2 = "jmjkbkjkv";
        new _094_().longestCommonSubsequence(text1, text2);


    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text2.length();
        int n = text1.length();

        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if(text2.charAt(i-1) == text1.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[m][n];
    }
}
