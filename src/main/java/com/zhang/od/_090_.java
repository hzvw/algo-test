package com.zhang.od;

import java.util.*;
/**
 * ClassName: _090_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/8 1:37
 * @Version 1.0
 */
public class _090_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(",");
        int[] nums = new int[words.length];
        for(int i = 0; i<nums.length; i++){
            nums[i] = Integer.parseInt(words[i]);
        }
        //int[] arr = {92,-48,12,2,-4,-55,-15,-79,24,-57,1,18,5,3,-57,-65};
        //System.out.println(p(nums, nums.length-1));

        int[] dp = new int[nums.length];
        dp[0] = Math.max(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(i-3 >= 0 ? dp[i-3] : 0, nums[i] + dp[i-1]);
        }
        System.out.println(dp[nums.length-1]);
    }

    static int p(int[] arr, int i){
        if(i<0){
            return 0;
        }
        if(i == 0){
            return Math.max(arr[i], 0);
        }
        // 决策
        return Math.max(p(arr, i-3), arr[i] + p(arr, i-1));

    }


}
