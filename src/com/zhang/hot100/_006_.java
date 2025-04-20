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
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            if(nums[i] > 0){
                continue;
            }
            if(i-1>=0 && nums[i] == nums[i-1]){
                continue;
            }

            int j = i+1;
            int k = nums.length-1;
            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum > 0){
                    k--;
                }else if(sum < 0){
                    j++;
                }else{
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    while (j < k && nums[j] == nums[j+1]){
                        j++;
                    }
                    while (j<k && nums[k] == nums[k-1]){
                        k--;
                    }

                    j++;
                    k--;
                }


            }

        }


        return res;
    }
}
