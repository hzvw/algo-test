package com.zhang.hot100;

import java.util.HashMap;

/**
 * ClassName: _010_
 * Package: com.zhang.hot100
 * Description:和为k的子数组
 *
 * @Author Harizon
 * @Create 2025/2/18 15:56
 * @Version 1.0
 */
public class _010_ {
    public static void main(String[] args) {

        int[] nums = {-1,-1,1};
        int k = 0;
        System.out.println(new _010_().subarraySum(nums, k));
    }

//    public int subarraySum(int[] nums, int k) {
//        int count = 0;
//        int n = nums.length;
//        int[] pre = new int[n+1];
//        for (int i = 1; i < n+1; i++) {
//            pre[i] = pre[i-1] + nums[i-1];
//        }
//        for (int i = 0; i < n; i++) {
//            for (int j = i+1; j < n+1; j++) {
//                if(pre[j] - pre[i] == k){
//                    count++;
//                }
//            }
//        }
//        return count;
//    }

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int pre = 0;
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        for (int i = 0; i < n; i++) {
            pre += nums[i];

            if(map.containsKey(pre - k)){
                count += map.get(pre - k);
            }
            if(map.containsKey(pre)){
                map.put(pre, map.get(pre) + 1);
            }else{
                map.put(pre, 1);
            }
        }

        return count;
    }

}
