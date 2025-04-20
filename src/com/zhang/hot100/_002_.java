package com.zhang.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * ClassName: _002_
 * Package: com.zhang.hot100
 * Description:字母异位词分组
 *
 * @Author Harizon
 * @Create 2025/2/18 0:31
 * @Version 1.0
 */
public class _002_ {
    public static void main(String[] args) {


    }

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map2 = new HashMap<>();
        for(String str : strs){
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            String n_str = new String(cs);
            map2.putIfAbsent(n_str, new ArrayList<>());
            map2.get(n_str).add(str);
        }
        List<List<String>> res = new ArrayList<>();
        for (String n_str : map2.keySet()) {
            res.add(map2.get(n_str));
        }

        return  res;
    }
}
