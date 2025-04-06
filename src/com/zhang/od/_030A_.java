package com.zhang.od;

import java.util.*;

/**
 * ClassName: _30A_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/17 0:47
 * @Version 1.0
 */
public class _030A_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(p(arr, 0));
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
        sum1 = Math.min(100, sum1);

        int sum2 = 0;
        for(int j = 0; j<=i-1; j++){
            sum2 += arr[j] * (i-j);
        }
        return Math.max(sum1-sum2, p(arr, i+1));
    }


}
