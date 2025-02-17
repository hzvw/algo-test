package com.zhang.hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * ClassName: _008_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/18 2:23
 * @Version 1.0
 */
public class _008_ {
    public static void main(String[] args) {
        System.out.println(new _008_().lengthOfLongestSubstring("abba"));
    }

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();

        int max_len = 0;
        int i = 0;
        int j = 0;
        while (j < n){
            char c = s.charAt(j);
            if(!map.containsKey(c)){
                map.put(c, j);
                max_len = Math.max(max_len, j-i+1);
                j++;
            }else{
                //重复了
                int last_id = map.get(c);
                i = last_id + 1;
                map.put(c, j);
                max_len = Math.max(max_len, j-i+1);
                j++;
            }
        }
        return max_len;
    }
}
