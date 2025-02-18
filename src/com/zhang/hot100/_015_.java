package com.zhang.hot100;

/**
 * ClassName: _015_
 * Package: com.zhang.hot100
 * Description:轮转数组
 *
 * @Author Harizon
 * @Create 2025/2/18 18:01
 * @Version 1.0
 */
public class _015_ {
    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        new _015_().rotate(nums, k);

    }

    public void rotate(int[] nums, int k) {
        if(k == 0){
            return;
        }

        int n = nums.length;
        k = k % n;

        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = nums[i+n-k];
        }

        for (int i = n-1; i >=k; i--) {
            nums[i] = nums[i-k];
        }
        for (int i = 0; i < k ; i++) {
            nums[i] = arr[i];
        }

    }


}
