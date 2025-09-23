package com.zhang.hot100;

/**
 * ClassName: _068_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/21 0:18
 * @Version 1.0
 */
public class _068_ {
    public static void main(String[] args) {
        System.out.println(new _068_().findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));


    }


    //
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m > n){
            int[] t = nums1;
            nums1 = nums2;
            nums2 = t;
        }

        m = nums1.length;
        n = nums2.length;

        if(m == 0){
            if(n % 2 == 0){
                return (double) (nums2[n/2] + nums2[n/2 - 1])/2;
            }else{
                return (double) (nums2[(n)/2]);
            }
        }

        int total = (m+n+1)/2;
        int left = 0;
        int right = m;
        int mid1 = 0;
        int mid2 = 0;
        while (left <= right){
            int i = (left + right)/2;
            int j = total - i;

            int a = i == 0 ? Integer.MIN_VALUE : nums1[i-1];
            int b = i == m ? Integer.MAX_VALUE : nums1[i];
            int c = j == 0 ? Integer.MIN_VALUE: nums2[j-1];
            int d = j == n ? Integer.MAX_VALUE : nums2[j];
            if(a < d){
                // a < d
                // c < b
                mid1 = Math.max(a,c);
                mid2 = Math.min(b,d);
                left = i+1;
            }else{
                right = i-1;
            }
        }
        return (m+n) % 2 == 0 ? (mid1+mid2)/ 2.0 : mid1/1.0;
    }
}
