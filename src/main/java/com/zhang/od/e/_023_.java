package com.zhang.od.e;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName: _023_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/1 21:10
 * @Version 1.0
 */
public class _023_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = Integer.parseInt(sc.nextLine());
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] w = new int[arr.length];
        int[] v = new int[arr.length];
        for(int i = 0; i<arr.length;i++){
            w[i] = i+1;
            v[i] = arr[i];
        }

        int bag = M;

//        int[][] dp = new int[w.length+1][M+1];
//        for(int i = 1; i<w.length+1; i++){
//            for(int j = 1; j<M+1; j++){
//
//                if(w[i-1] > j){
//                    dp[i][j] = dp[i-1][j];
//                }else{
//                    dp[i][j] = Math.max(dp[i-1][j], v[i-1] + dp[i][j-w[i-1]]);
//                }
//            }
//        }

        int[] dp = new int[bag+1];
        for(int i =1; i<w.length+1; i++){
            for(int j = 1; j<M+1; j++){
                if(w[i-1] > j){

                }else{
                    dp[j] = Math.max(dp[j], v[i-1]+ dp[j-w[i-1]]);
                }
            }
        }

        System.out.println(dp[M]);
    }

}
