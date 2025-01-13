package com.zhang.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: _046_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/9 2:19
 * @Version 1.0
 */
public class _046_ {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        p(nums, 0, res);
        return res;
    }

    static void p(int[] nums, int i, List<List<Integer>> res){
        if(i == nums.length-1){
            List<Integer> tmp = new ArrayList<>();
            for(int m = 0; m<nums.length; m++){
                tmp.add(nums[m]);
            }
            res.add(tmp);
        }

        for(int j = i; j<nums.length; j++){
            swap(nums, i, j);
            p(nums, i+1, res);
            swap(nums, i, j);
        }
    }

    static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }






}
