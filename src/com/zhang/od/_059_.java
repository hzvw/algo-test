package com.zhang.od;

import java.util.Scanner;

/**
 * ClassName: _059_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/19 17:44
 * @Version 1.0
 */
public class _059_ {
    // 这题太难
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();

        int[] count = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            count[c-'a']++;
        }

        int n = s1.length();
        int i = 0;
        while (i < s2.length()) {
            char c = s2.charAt(i);

            if(count[c-'a'] > 0){
                n--;
            }
            count[c-'a']--;

            if(i>=s1.length()){
                char c2 = s2.charAt(i - s1.length());
                if(count[c2-'a'] >= 0){
                    n++;
                }
                count[c2-'a']++;
            }
            if(n == 0){
                System.out.println(i-s1.length()+1);
                return;
            }

            i++;
        }
        System.out.println(-1);
    }
}
