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
        int res = 0;
        int i = 0;
        int j = 0;
        int[] count = new int[26];

        while (j< s.length()){
            char c = s.charAt(j);
            if(count[c-'a'] == 0){
                res = Math.max(res, j-i+1);
                count[c-'a'] ++;
                j++;
            }else{
                count[s.charAt(i)-'a']--;
                i++;
            }
        }
        return res;
    }
}
