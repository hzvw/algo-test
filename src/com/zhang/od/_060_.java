package com.zhang.od;

import java.util.Scanner;

/**
 * ClassName: _060_
 * Package: com.zhang.od
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/19 17:47
 * @Version 1.0
 */
public class _060_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] arr = new long[n];
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextLong();
        }

        long sum = 0;
        for(int i = 0; i<n; i++){
            sum += arr[i];
        }

        long sum1 = 0;
        long sum2 = sum;
        long max = Math.abs(arr[0] - (sum - arr[0]));

        for(int i = 0; i<arr.length-1; i++){
            sum1 += arr[i];
            sum2 -= arr[i];

            max = Math.max(max, Math.abs(sum1 - sum2));
        }
        System.out.println(max);
    }

}
