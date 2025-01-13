package com.zhang.hot100;

/**
 * ClassName: _221_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/9 1:23
 * @Version 1.0
 */
public class _221_ {
    public static void main(String[] args) {



    }


    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m+1][n+1];
        int max = 0;
        for(int i = 1; i<=m ;i++){
            for(int j = 1; j<=n; j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }

}
