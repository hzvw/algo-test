package com.zhang.hot100;

/**
 * ClassName: _097_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/22 20:22
 * @Version 1.0
 */
public class _097_ {
    public int majorityElement(int[] nums) {
        int winner = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if(count == 0){
                winner = nums[i];
                count++;
                continue;
            }

            if(winner == nums[i]){
                count++;
            }else{
                count--;
            }
        }
        return winner;
    }
}
