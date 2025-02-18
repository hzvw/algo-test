package com.zhang.hot100;

/**
 * ClassName: _012_
 * Package: com.zhang.hot100
 * Description:最小覆盖子串
 *
 * @Author Harizon
 * @Create 2025/2/18 17:01
 * @Version 1.0
 */
public class _012_ {
    public static void main(String[] args) {


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
        return min_len == s.length()+1 ? "" : s.substring(start, start+min_len);
    }

}
