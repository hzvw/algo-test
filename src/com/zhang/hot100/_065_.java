package com.zhang.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: _065_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/20 20:06
 * @Version 1.0
 */
public class _065_ {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;

        new _065_().searchRange(nums, target);


    }

    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if(n == 0){
            return new int[]{-1,-1};
        }
        int start = -1;

        int left = 0;
        int right = n-1;
        while (left < right){
            int mid = (left + right)/2;
            if(nums[mid] < target){
                left = mid+1;
            }else {
                right = mid;
            }
        }
        start = nums[left] == target ? left : -1;
        int end = -1;
        left = 0;
        right = nums.length-1;
        while (left < right){
            int mid = (left + right+1) / 2;
            if(nums[mid] > target){
                right = mid-1;
            }else{
                left = mid;
            }
        }
        end = nums[right] == target ? right : -1;

        if(start == -1 || end == -1){
            return new int[]{-1, -1};
        }

        return new int[]{start, end};
    }

//    public int searchInsert(int[] nums, int target) {
//        int left = 0;
//        int right = nums.length-1;
//        int result = -1;
//        while (left <= right){
//            int mid = (left + right)/2;
//            if(nums[mid] > target){
//                right = mid-1;
//            }else if(nums[mid] < target){
//                left = mid+1;
//            }else{
//                result = mid;
//                return result;
//            }
//        }
//        result = left ;
//        return result;
//    }
}
