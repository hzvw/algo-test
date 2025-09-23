package com.zhang.hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * ClassName: _080_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/22 0:03
 * @Version 1.0
 */
public class _080_ {
    public static void main(String[] args) {
        new _080_().partitionLabels("ababcbacadefegdehijhklij");

    }

    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        // 存放每个字符最后的下标
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, i);
        }

        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            right = Math.max(right, map.get(c));

            if(i == right){
                res.add(right -left + 1);
                left = right + 1;
            }
        }

//        for (Integer ele : res) {
//            System.out.println(ele);
//        }

        return res;
    }
}
