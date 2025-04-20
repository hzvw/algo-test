package com.zhang.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: _009_
 * Package: com.zhang.hot100
 * Description:找到字符串中所有字母异位词
 *
 * @Author Harizon
 * @Create 2025/2/18 14:18
 * @Version 1.0
 */
public class _009_ {
    public static void main(String[] args) {


        String s = "cbaebabacd";
        String t = "abc";
        List<Integer> list = new _009_().findAnagrams(s, t);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] count = new int[26];
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            count[c-'a']++;
        }
        int n = p.length();
        int i = 0;
        int j = 0;
        while (j < s.length()){
            char c = s.charAt(j);
            if(count[c-'a'] > 0){
                n--;
            }
            count[c-'a']--;

            while (n == 0){
                if(j-i+1 == p.length()){
                    res.add(i);
                }
                char c2 = s.charAt(i);
                if(count[c2-'a'] == 0){
                    n++;
                }
                count[c2-'a']++;
                i++;
            }
            j++;
        }

        return res;
    }

    public String minWindow(String s, String t) {
        int n = t.length();//目标长度

        // 统计每个字符的次数
        int[] count = new int[26];
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            count[c-'a']++;
        }

        int i = 0;
        int j = 0;
        //双指针就绪

        int min_len = s.length() + 1;
        int start = 0;//记录最终结果的起点
        while(j < s.length()){
            char c = s.charAt(j);
            if(count[c-'a'] > 0){
                n--;
            }
            count[c-'a']--;

            while (n == 0){
                //说明i能向右收缩
                if(min_len > j-i+1){
                    min_len = j-i+1;
                    start = i;
                }
                char c2 = s.charAt(i);
                if(count[c2-'a'] == 0){
                    n++;
                }
                count[c2-'a']++;

                i++;
            }
            j++;
        }
        return min_len == s.length()+1 ? "" : s.substring(start, start+min_len);
    }
}
