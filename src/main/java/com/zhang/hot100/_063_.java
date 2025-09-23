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

        int[] nums = {1,2,4,5};
//        int target = -1;
//        int target = 2;
//        int target = 3;
        int target = 6;
        System.out.println(new _063_().searchInsert(nums, target));


    }


    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
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
        return right+1;
    }

}
