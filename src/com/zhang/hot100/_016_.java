package com.zhang.hot100;

/**
 * ClassName: _016_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/18 18:15
 * @Version 1.0
 */
public class _016_ {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        new _016_().productExceptSelf(nums);
    }

    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];

        int l = 1;
        for (int i = 0; i < nums.length; i++) {
            ans[i] = l;
            l = l * nums[i];
        }

        int r = 1;
        for (int i = nums.length-1; i >= 0 ; i--) {
            ans[i] = ans[i] * r;
            r = r * nums[i];
        }
        return ans;
    }
}
