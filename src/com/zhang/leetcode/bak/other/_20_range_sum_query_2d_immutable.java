package com.zhang.leetcode.bak.other;
/* leetcode 304 */
public class _20_range_sum_query_2d_immutable {
    static class NumMatrix {

        int[][] preSum;
        public NumMatrix(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            preSum = new int[m+1][n+1];
            preSum[0][0] = 0;
            for(int i = 1; i<=m; i++){
                for(int j = 1; j<=n; j++){
                    preSum[i][j] = preSum[i-1][j] + preSum[i][j-1]
                            + matrix[i-1][j-1] - preSum[i-1][j-1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return preSum[row2+1][col2+1] - preSum[row1][col2+1]
                    - preSum[row2+1][col1] + preSum[row1][col1];
        }
    }

}
