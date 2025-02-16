package com.zhang.leetcode.bak;

/**
 * ClassName: _076_
 * Package: com.zhang.leetcode.bak
 * Description:最小子串  https://leetcode.cn/problems/minimum-window-substring/
 *
 * @Author Harizon
 * @Create 2025/2/16 22:28
 * @Version 1.0
 */
public class _076_ {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(new _076_().minWindow(s, t));

    }

    public String minWindow(String s, String t) {
        int n = t.length();//目标长度

        // 统计每个字符的次数
        int[] count = new int[128];
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i)]++;
        }

        int i = 0;
        int j = 0;
        //双指针就绪

        int min_len = s.length() + 1;
        int start = 0;//记录最终结果的起点
        while(j < s.length()){
            char c = s.charAt(j);
            if(count[c] > 0){
                n--;
            }
            count[c]--;

            while (n == 0){
                //说明i能向右收缩
                if(min_len > j-i+1){
                    min_len = j-i+1;
                    start = i;
                }
                char tmp = s.charAt(i);
                if(count[tmp] == 0){
                    n++;
                }
                count[tmp]++;

                i++;
            }
            j++;
        }
        return "";
    }
}
