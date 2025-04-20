package com.zhang.leetcode.bak;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: _063_
 * Package: com.zhang.leetcode.bak
 * Description:
 *
 * @Author Harizon
 * @Create 2025/4/20 17:38
 * @Version 1.0
 */
public class _063_ {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        Set<Integer>  set = new HashSet<>();
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(obstacleGrid[i][j] == 1){
                    set.add(i * n + j);
                }
            }
        }

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if(set.contains(i * n)){
                break;
            }
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            if(set.contains(j)){
                break;
            }
            dp[0][j] =  1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = set.contains(i * n + j) ? 0 : (dp[i-1][j]  + dp[i][j-1]);
            }
        }

        return dp[m-1][n-1];
    }
}
