package com.zhang.od.e;

import javax.swing.*;
import java.util.HashSet;
import java.util.Scanner;

/**
 * ClassName: _084_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/17 17:36
 * @Version 1.0
 */
public class _084_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();

        HashSet<Integer> set = new HashSet<>();
        int m = A.length();
        int n = B.length();

        // (m+1)*(n+1)个点

//        int[][] dp = new int[n+1][m+1];
        int[][] dp = new int[2][m+1];

        for (int j = 0; j < m+1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < n+1; i++) {
            dp[1][0] = i; //这个初始化要注意
            for (int j = 1; j < m+1; j++) {

                char b = B.charAt(i-1);
                char a = A.charAt(j-1);
                if(a == b){
                    dp[1][j] = dp[0][j-1] + 1;
                }else{
                    dp[1][j] = Math.min(dp[0][j] + 1, dp[1][j-1] + 1);
                }
            }
            for (int j = 0; j < m+1; j++) {
                dp[0][j] = dp[1][j];
            }
        }
        System.out.println(dp[1][m]);
    }

}
