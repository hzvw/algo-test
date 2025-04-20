package com.zhang.leetcode.bak;

import java.util.Arrays;

/**
 * ClassName: _135_
 * Package: com.zhang.leetcode.bak
 * Description:
 *
 * @Author Harizon
 * @Create 2025/4/20 14:15
 * @Version 1.0
 */
public class _135_ {
    public static void main(String[] args) {



    }

    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] count = new int[n];
        Arrays.fill(count, 1);
        for (int i = 1; i < n; i++) {
            if(ratings[i] > ratings[i-1]){
                count[i] = count[i-1] + 1;
            }
        }
        for (int i = n-2; i >= 0 ; i--) {
            if(ratings[i] > ratings[i+1] && count[i] <= count[i+1]){
                count[i] = count[i+1] + 1;
            }
        }
        return Arrays.stream(count).sum();
    }
}
