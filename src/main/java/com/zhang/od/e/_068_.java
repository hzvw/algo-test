package com.zhang.od.e;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName: _068_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/15 22:25
 * @Version 1.0
 */
public class _068_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();

        int bag = sc.nextInt();
        int n = arr.length;
        int[][] dp = new int[n+1][bag+1];

        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int num = arr[i-1];
            for (int j = 0; j <= bag; j++) {
                if(j < num){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-num];
                }
            }
        }
        System.out.println(dp[n][bag]);
    }

}
