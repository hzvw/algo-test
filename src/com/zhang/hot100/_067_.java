package com.zhang.hot100;

/**
 * ClassName: _067_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/21 0:16
 * @Version 1.0
 */
public class _067_ {
    public static void main(String[] args) {



    }

    public int findMin(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            throw new IllegalArgumentException("数组为空，无最小元素");
        }
        int left = 0;
        int right = len - 1;
        while (left < right) {
            // int mid = left + (right - left) / 2;
            int mid = (left + right) >>> 1;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // 因为题目中说：你可以假设数组中不存在重复元素。
                // 此时一定有 nums[mid] < nums[right]
                right = mid;
            }
        }
        // 一定存在最小元素，因此无需再做判断
        return nums[left];
    }
}
