package com.zhang.od;

import java.util.*;

/**
 * ClassName: _30A_
 * Package: com.zhang.od
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/17 0:47
 * @Version 1.0
 */
public class _030A_ {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String line = sc.nextLine();
//        String[] words = line.split(" ");
//        int[] arr = new int[words.length];
//        for(int i = 0; i<arr.length; i++){
//            arr[i] = Integer.parseInt(words[i]);
//        }
//        System.out.println(p(arr, 0));
        //int[] arr = {1,98,1};
        //int[] arr = {50,60,1};
        //System.out.println(p(arr, 0));
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(p(arr, 0));
        //System.out.println(p(arr));
    }

    static int p(int[] arr, int i){
        if(i == arr.length-1){ // base case
            int sum1 = 0;
            for(int j=0; j<=i;  j++){
                sum1 += arr[j];
            }
            sum1 = Math.min(100, sum1);

            int sum2 = 0;
            for(int j = 0; j<=i-1; j++){
                sum2 += arr[j] * (i-j);
            }

            return sum1 - sum2;
        }

        int sum1 = 0;
        for(int j=0; j<=i;  j++){
            sum1 += arr[j];
        }
        int tmp = sum1;
        sum1 = Math.min(100, sum1);

        int sum2 = 0;
        for(int j = 0; j<=i-1; j++){
            sum2 += arr[j] * (i-j);
        }
        return Math.max(sum1-sum2, p(arr, i+1));
    }

    static int p(int[] arr){
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        for(int i = 1; i<arr.length; i++){
            int sum1 = 0;
            for(int j=0; j<=i;  j++){
                sum1 += arr[j];
            }
            sum1 = Math.min(100, sum1);

            int sum2 = 0;
            for(int j = 0; j<=i-1; j++){
                sum2 += arr[j] * (i-j);
            }
            dp[i] = Math.max(dp[i-1]-sum2, sum1 - sum2);
        }

        return dp[arr.length-1];
    }


//    static int p(int[] arr, int i){
//        if(i == arr.length-1){
//            int sum_x = 0;
//            for(int j = 0;j<arr.length; j++){
//                sum_x += arr[j] + (arr.length-1-j);
//            }
//            int sum_y = 0;
//            for(int j = 0; j<arr.length;j++){
//                sum_y += arr[j];
//            }
//            return sum_y - sum_x;
//        }
//
//
//
//        return 0;
//    }


}
