package com.zhang.od.e;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName: _069_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/15 22:56
 * @Version 1.0
 */
public class _069_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = arr.length;

        if(n == 1){
            System.out.println(arr[0]);
            return;
        }
        if(n == 2){
            System.out.println(Math.max(arr[0], arr[1]));
            return;
        }
        int[] arr1 = new int[n-1];
        int[] arr2 = new int[n-1];

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr[i];
            arr2[i] = arr[i+1];
        }
        System.out.println(Math.max(m1(arr1), m1(arr2)));
    }

    static int m1(int[] arr){
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1], arr[i] + dp[i-2]);
        }
        return dp[n-1];
    }


}
