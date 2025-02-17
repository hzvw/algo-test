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
        int n = height.length;
        int i = 0;
        int j = n-1;

        int max_cap = 0;
        while(i < j){
            max_cap = Math.max(max_cap, (j-i) * Math.min(height[i], height[j]));
            if(height[i] > height[j]){
                j--;
            }else{
                i++;
            }
        }
        return max_cap;
    }
}
