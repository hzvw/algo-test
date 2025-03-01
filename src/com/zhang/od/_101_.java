package com.zhang.od;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName: _101_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/8 2:09
 * @Version 1.0
 */
public class _101_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int res = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            res = Math.max(res, max_sub(arr[i]));

            for(int j = i+1; j<n; j++){
                for(int k = 0; k<m; k++){
                    arr[i][k] += arr[j][k];
                }
                res = Math.max(res, max_sub(arr[i]));
            }
        }
        System.out.println(res);



    }

    public static int max_sub(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1], 0) + nums[i];
        }
        return Arrays.stream(dp).max().getAsInt();
    }

}
