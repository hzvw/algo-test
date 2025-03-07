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
        int[] count = new int[128];
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i)]++;
        }

        int i = 0;
        int j = 0;
        int n = t.length();
        int minLen = s.length() + 1;
        int start = 0;
        while (j < s.length()){
            char c = s.charAt(j);
            if(count[c] > 0){
                n--;
            }
            count[c]--;

            while (n == 0){
                if(j-i+1 < minLen){
                    minLen = j-i+1;
                    start = i;
                }

                char c2 = s.charAt(i);
                if(count[c2] == 0){
                    n++;
                }
                count[c2]++;
                i++;
            }
            j++;
        }

        return minLen == s.length() + 1 ? "" : s.substring(start, start+minLen);
    }

}
