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
    //
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length)//保证num1长度小，如果不小我交换一下
        {
            int team[]=nums2.clone();
            nums2=nums1;
            nums1=team;
        }
        int k=(nums1.length+nums2.length+1)/2;//理论中位数满足的位置
        int left=0,right=nums1.length;//二分查找短的

        while (left<right) {//找到对应位置
            int m1=(left+right)/2;//在短的位置
            int m2=k-m1;//在长的第几个
            //System.out.println(m1+" "+m2);
            if(nums1[m1]<nums2[m2-1])//left右移
                left=m1+1;
            else {//right左移
                right=m1;
            }
        }
        //System.out.println(left+" "+k);
        //左侧最大和右侧最小那个先算出来再说，根据奇偶再使用
        double leftbig= Math.max(left==0?Integer.MIN_VALUE:nums1[left-1], k-left==0?Integer.MIN_VALUE:nums2[k-left-1]);
        double rightsmall=Math.min(left==nums1.length?Integer.MAX_VALUE:nums1[left],k-left==nums2.length?Integer.MAX_VALUE:nums2[k-left]);
        //System.out.println(rightsmall);
        if((nums1.length+nums2.length)%2==0)
        {
            return (leftbig+rightsmall)/2;
        }
        else {
            return leftbig;
        }
    }
}
