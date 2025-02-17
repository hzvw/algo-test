package com.zhang.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * ClassName: _006_
 * Package: com.zhang.hot100
 * Description:三数之和
 *
 * @Author Harizon
 * @Create 2025/2/18 1:25
 * @Version 1.0
 */
public class _006_ {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(nums[i] > 0){
                return res;
            }

            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            int left = i+1;
            int right = n-1;

            while(left < right){
                if(nums[i] + nums[left] + nums[right] > 0){
                    right --;
                }else if(nums[i] + nums[left] + nums[right] < 0){
                    left ++;
                }else{
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while(left < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    while(left < right && nums[left] == nums[left + 1]){
                        left++;
                    }
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}
