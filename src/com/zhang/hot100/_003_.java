package com.zhang.hot100;

import java.util.*;

/**
 * ClassName: _003_
 * Package: com.zhang.hot100
 * Description:最长连续序列
 *
 * @Author Harizon
 * @Create 2025/2/18 0:48
 * @Version 1.0
 */
public class _003_ {
    public static void main(String[] args) {


    }

    public int longestConsecutive(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        HashMap<Integer, Integer> count = new HashMap<>();
        int i = 0;
        for (Integer ele : set) {
            count.put(ele-i, count.getOrDefault(ele-i, 0) + 1);
            i++;
        }
        if(count.size() > 0){
            return count.values().stream().max((a,b) -> a-b).get();
        }else{
            return 0;
        }
    }

}
