package com.zhang.od2._100;

import java.util.Scanner;

/**
 * ClassName: _006_
 * Package: com.zhang.od2._100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/3/29 2:33
 * @Version 1.0
 */
public class _006_ {

    static int[] nums;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            int left = check(i-1);
            int right = check(i+1);
            res = Math.max(res, nums[i] + compute(left, right));
        }
        System.out.println(res);
    }

    static int compute(int left, int right){
        if(nums[left] > nums[right]){
            left = check(left-1);
        }else{
            right = check(right+1);
        }

        if(left == right){
            return nums[left];
        }

        int res1 = nums[left] + compute(check(left-1), right);
        int res2 = nums[right] + compute(left, check(right+1));
        return Math.max(res1, res2);
    }

    static int check(int i){
        if(i == -1){
            return nums.length-1;
        }else if(i == nums.length){
            return 0;
        }else{
            return i;
        }
    }


}
