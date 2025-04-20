package com.zhang.hot100;

/**
 * ClassName: _004_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/18 1:00
 * @Version 1.0
 */
public class _004_ {

    public static void main(String[] args) {
        new _004_().moveZeroes(new int[]{0,1,0,3,12});

    }

    public void moveZeroes(int[] nums) {
        // 从0-i一共有多少个0
        int[] count = new int[nums.length];

        int n = nums.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if(nums[i] == 0){
                cnt++;
            }
            count[i] = cnt;
        }

        for (int i = 0; i < n; i++) {
            if(nums[i] != 0){
                nums[i-count[i]] = nums[i];
            }
        }
        for (int i = n-count[n-1]; i < n; i++) {
            nums[i] = 0;
        }
    }
}
