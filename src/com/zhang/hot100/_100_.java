package com.zhang.hot100;

import java.util.Arrays;

/**
 * ClassName: _100_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/22 20:36
 * @Version 1.0
 */
public class _100_ {
    public static void main(String[] args) {
        int[] nums = {3,1,3,4,2};
        new _100_().findDuplicate(nums);

    }
    public int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = 0;
        while (true){
            fast = nums[fast];
            fast = nums[fast];
            slow = nums[slow];
            if(slow == fast){
                break;
            }
        }

        int find = 0;
        while (true){
            find = nums[find];
            slow = nums[slow];
            if(find == slow){
                break;
            }
        }
        return slow;
    }



}
