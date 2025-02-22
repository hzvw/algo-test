package com.zhang.hot100;

/**
 * ClassName: _093_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/22 18:14
 * @Version 1.0
 */
public class _093_ {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int i = n-1; i >= 0 ; i--) {
            for (int j = i; j < n; j++) {
                if(s.charAt(i) == s.charAt(j)){
                    if(i == j){
                        dp[i][j] = true;
                    }else if(j - i == 1){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
            }
        }

        int res = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(dp[i][j] && j-i+1 > res){
                    res = Math.max(res, j - i + 1);
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, right + 1);
    }

    // 回文子串的数量
    public int countSubstrings(String s) {
        int n = s.length();

        boolean[][] dp = new boolean[n][n];

        int count = 0;

        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if(s.charAt(i) == s.charAt(j)){
                    if(i == j){
                        dp[i][j] = true;
                    }else if(j - i == 1){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                    if(dp[i][j]){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
