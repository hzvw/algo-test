package com.zhang.leetcode.bak;

import java.util.Arrays;

/**
 * ClassName: _1371_
 * Package: com.zhang.leetcode.bak
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/17 22:06
 * @Version 1.0
 */
public class _1371_ {
    public static void main(String[] args) {
        new _1371_().findTheLongestSubstring("eleetminicoworoep");
    }

    public int findTheLongestSubstring(String s) {
        int status = 0b00000;
        int[] map = new int[32];
        Arrays.fill(map, -2);
        map[0] = -1;
        int max_len = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c == 'a'){
                status ^= 0b10000;
            }else if(c == 'e'){
                status ^= 0b01000;
            }else if(c == 'i'){
                status ^= 0b00100;
            }else if(c == 'o'){
                status ^= 0b00010;
            }else if(c == 'u'){
                status ^= 0b00001;
            }
            if(map[status] != -2){
               max_len = Math.max(max_len, i - map[status]);
            }else{
                map[status] = i;
            }
        }
        return max_len;
    }

}
