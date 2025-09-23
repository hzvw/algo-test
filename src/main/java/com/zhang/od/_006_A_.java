package com.zhang.od;

import java.util.Scanner;

/**
 * ClassName: _005_A_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/3/2 1:52
 * @Version 1.0
 */
public class _006_A_ {
    static long[] nums;
    static int n;

    static long[][] cache;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        nums = new long[n];
        cache = new long[n][n];

        for(int i = 0; i<n; i++){
            nums[i] = sc.nextLong();
        }

        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = ((i-1) + nums.length) % nums.length;
            int right = (i+1) % nums.length;
            res = Math.max(res, nums[i] + dfs(nums, left, right));
        }
        System.out.println(res);
    }

    static long dfs(long[] nums, int left, int right){
        if(nums[left] > nums[right]){
            left = p(nums, left-1);
        }else{
            right = p(nums, right+1);
        }

        if(cache[left][right] != 0){
            return cache[left][right];
        }
        if(left == right){
            cache[left][right] = nums[left];
            return nums[left];
        }
        long x = nums[left] + dfs(nums, p(nums, left-1), right);
        long y = nums[right] + dfs(nums, left, p(nums, right+1));
        cache[left][right] = Math.max(x,y);
        return Math.max(x, y);
    }

    static int p(long[] nums, int i){
        return (i+nums.length) % nums.length;
    }

}
