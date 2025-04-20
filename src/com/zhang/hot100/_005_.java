package com.zhang.hot100;

/**
 * ClassName: _005_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/18 1:18
 * @Version 1.0
 */
public class _005_ {
    public static void main(String[] args) {



    }

    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;
        int res = 0;
        while (i<j){
            res = Math.max(res, Math.min(height[i], height[j]) * (j-i));
            if(height[i] < height[j]){
                i++;
            }else {
                j--;
            }

        }

        return res;
    }
}
