package com.zhang.hot100;

/**
 * ClassName: _063_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/20 19:46
 * @Version 1.0
 */
public class _063_ {
    public static void main(String[] args) {



    }


    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while (left <= right){
            int mid = (left + right)/2;
            if(nums[mid] > target){
                right = mid-1;
            }else if(nums[mid] < target){
                left = mid+1;
            }else{
                return mid;
            }
        }
        return left;
    }

}
