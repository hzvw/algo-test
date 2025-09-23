package com.zhang.od.e;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName: _037_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/2 17:31
 * @Version 1.0
 */
public class _037_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        if(sum % 2 != 0){
            System.out.println(-1);
            return;
        }

        int bag = sum / 2;
        int[][] dp = new int[N+1][bag+1];
        Arrays.fill(dp[0], N);

        dp[0][0] = 0;
        for(int i = 1; i<=N; i++){
            int w =arr[i-1];
            for(int j = 1; j<=bag; j++){
                if(w > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i-1][j-w]);
                }
            }
        }

        System.out.println(dp[N][bag] == N ? -1 : dp[N][bag]);



    }

}
