package com.zhang.od;

import java.util.Scanner;

/**
 * ClassName: _006_
 * Package: com.zhang.od
 * Description:分披萨
 *
 * @Author Harizon
 * @Create 2025/1/14 0:39
 * @Version 1.0
 */
public class _006_ {
    static long[] nums;
    static long[][] cache;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        nums = new long[n];
        cache = new long[n][n];

        for(int i = 0; i<n; i++){
            nums[i] = sc.nextInt();
        }

        long max = 0;
        for(int i = 0; i<n; i++){
            max = Math.max(max, nums[i] + p(check(i-1),check(i+1)));
        }
        System.out.println(max);
    }


    static long p(int i, int j){
        if(nums[i] > nums[j]){
            i = check(i-1);
        }else{
            j = check(j+1);
        }
        if(cache[i][j] > 0){
            return cache[i][j];
        }

        if(i == j){
            cache[i][j] = nums[i];
            return nums[i];
        }

        long i1 = nums[i] + p( check(i-1), j);
        long i2 = nums[j] + p( i, check(j+1));

        cache[i][j] = i1 > i2 ? i1:i2;
        return cache[i][j];
    }

    static int check(int i){
        if(i < 0){
            return nums.length -1;
        }
        if(i > nums.length-1){
            return 0;
        }
        return i;
    }



}
