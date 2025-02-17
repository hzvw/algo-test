package com.zhang.hot100;

/**
 * ClassName: _007_
 * Package: com.zhang.hot100
 * Description:接雨水
 *
 * @Author Harizon
 * @Create 2025/2/18 1:51
 * @Version 1.0
 */
public class _007_ {
    public static void main(String[] args) {


    }

//    public int trap(int[] height) {
//        int res = 0;
//        int n = height.length;
//        for (int i = 0; i < n; i++) {
//            int l_m = 0;
//            for (int j = 0; j < i; j++) {
//                l_m = Math.max(l_m, height[j]);
//            }
//            int r_m = 0;
//            for (int j = i+1; j < n; j++) {
//                r_m = Math.max(r_m, height[j]);
//            }
//            int t = Math.min(l_m, r_m) - height[i];
//            res += t > 0 ? t : 0;
//        }
//        return res;
//    }

//    public int trap(int[] height) {
//        int res = 0;
//        int n = height.length;
//        int[] lm = new int[n];
//        int[] rm = new int[n];
//        int l = 0;
//        for (int i = 0; i < n; i++) {
//            l = Math.max(l, height[i]);
//            lm[i] = l;
//        }
//
//        int r = 0;
//        for (int i = n-1; i >=0 ; i--) {
//            r = Math.max(r, height[i]);
//            rm[i] = r;
//        }
//
//        for (int i = 0; i < n; i++) {
//            if(height[i] < Math.min(lm[i], rm[i])){
//                res += Math.min(lm[i], rm[i]) - height[i];
//            }
//        }
//
//        return res;
//    }

    public int trap(int[] height) {
        int res = 0;
        int n = height.length;
        int left = 0;
        int right = n-1;
        int l_m = 0;
        int r_m = 0;
        while (left < right){
            l_m = Math.max(l_m, height[left]);
            r_m = Math.max(r_m, height[right]);

            if(l_m < r_m){
                res += l_m - height[left];

                left++;
            }else{
                res += r_m - height[right];

                right--;
            }

        }
        return res;
    }


}
