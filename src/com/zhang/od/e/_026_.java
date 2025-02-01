package com.zhang.od.e;

import java.util.Scanner;

/**
 * ClassName: _026_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/2/2 1:00
 * @Version 1.0
 */
public class _026_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int bag = sc.nextInt();
        int[] v = arr;
        int[] w = arr;

        int[][] dp = new int[n+1][bag+1];
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < bag+1; j++) {
                if(w[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], v[i-1] + dp[i-1][j-w[i-1]]);
                }
            }
        }
        System.out.println(dp[n][bag]);

    }

}
