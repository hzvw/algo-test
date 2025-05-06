package com.zhang._0429;

import java.util.Arrays;

/**
 * ClassName: Main
 * Package: com.zhang._0429
 * Description:
 *
 * @Author Harizon
 * @Create 2025/4/29 19:01
 * @Version 1.0
 *
 * 现场编程题题目内容：
 * 这里有N堆香蕉，第i堆中有piles[i]根香蕉。警卫已经离开了，将在H小时后回来。小东可以决定他吃香蕉的速度K（单位：根/小时）。
 * 每个小时，他将会选择一堆香蕉，从中吃掉K根。如果这堆香蕉少于K根，他将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 * 小东喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * 返回他可以在 H 小时内吃掉所有香蕉的最小速度 K（K为整数）。
 * 示例 1： 输入: piles = [3,6,7,11], H = 8          输出: 4
 * 示例 2： 输入: piles = [30,11,23,4,20], H = 5     输出: 30
 * 示例 3： 输入: piles = [30,11,23,4,20], H = 6     输出: 23
 * 提示：
 * 1 <= piles.length <= 10^4      piles.length <= H <= 10^9       1 <= piles[i] <= 10^9
 *
 *
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {3,6,7,11};
        int H = 8;

//        int[] nums = {30,11,23,4,20};
//        int H = 5;

//        int[] nums = {30,11,23,4,20};
//        int H = 6;

        System.out.println(solve(nums, H));
    }

    static int solve(int[] nums, int H){
        int n = nums.length;
        if(n > H){
            return -1;// 不可能吃完
        }

        int left = 1;
        int right = Arrays.stream(nums).max().getAsInt();

        int res = 0;
        while (left <= right){
            int mid = (left + right) / 2;
            if(check(nums, H, mid)){
                res = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        return res;
    }

    static boolean check(int[] nums, int H, int speed){
        int count = 0;
        for (int num : nums) {
            if(num <= speed){
                count += 1;
            }else{
                count += num % speed == 0 ? num / speed : (num / speed + 1);
            }
        }

        return count <= H;
    }


}
