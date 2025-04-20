package com.zhang.hot100;

import java.util.HashMap;

/**
 * ClassName: _001_
 * Package: com.zhang.hot100
 * Description:两数之和
 *
 * @Author Harizon
 * @Create 2025/2/18 0:26
 * @Version 1.0
 */
public class _001_ {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i]) && map.get(target-nums[i]) != i){
                return new int[]{i, map.get(target - nums[i])};
            }
        }
        return null;
    }

}
