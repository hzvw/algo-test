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
        Set<Integer> set = new TreeSet<>();
        Arrays.stream(nums).forEach(x->set.add(x));
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        for(int num : set){
            map.put(num - i, map.getOrDefault(num - i,  0) + 1);
            i++;
        }
        return map.size() > 0 ?  map.values().stream().max((a,b)-> a-b).get() : 0;
    }

}
