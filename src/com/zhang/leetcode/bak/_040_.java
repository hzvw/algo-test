package com.zhang.leetcode.bak;

/**
 * ClassName: _040_
 * Package: com.zhang.leetcode.bak
 * Description:
 *
 * @Author Harizon
 * @Create 2025/4/20 17:55
 * @Version 1.0
 */
public class _040_ {
    public static void main(String[] args) {
        String[] matrix = {"10100","10111","11111","10010"};

        System.out.println(new _040_().maximalRectangle(matrix));


    }

    public int maximalRectangle(String[] matrix) {
        int m = matrix.length;
        int n = matrix[0].length();
        char[][] cs = new char[m][n];
        for (int i = 0; i < m; i++) {
            cs[i] = matrix[i].toCharArray();
        }
        int res = 0;
        Node[][] dp = new Node[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new Node();
            }
        }
        dp[0][0].x = cs[0][0] == '1' ? 1: 0;
        dp[0][0].y = cs[0][0] == '1' ? 1: 0;
        for (int i = 1; i < m; i++) {
            dp[i][0].y = cs[i][0] == '1' ? 1 : 0;
            dp[i][0].x = cs[i][0] == '1' ? dp[i-1][0].x + 1 : 0;
        }
        for (int j = 1; j < n; j++) {
            dp[0][j].x = cs[0][j]== '1' ? 1:0;
            dp[0][j].y = cs[0][j] == '1' ? dp[0][j-1].y + 1 : 0;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                Node node = dp[i][j];
                if(cs[i][j] == '0'){
                    node.x = 0;
                    node.y = 0;
                }else{
                    node.x = Math.max(1, dp[i][j-1].x);
                    node.y = Math.max(1, dp[i-1][j].y);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dp[i][j].x * dp[i][j].y);
            }
        }

        return res;
    }

    static class Node{
        int x;
        int y;
    }

}
