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
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        int[] count = new int[26];
        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            count[c-'a']++;
        }

        int n = str1.length();
        for (int i = 0; i < str2.length(); i++) {
            char c = str2.charAt(i);
            if(count[c-'a'] >  0){
                n--;
            }
            count[c-'a']--;

            int j = i - str1.length() ;
            if(j >= 0){
                char c2 = str2.charAt(j);
                if(count[c2-'a'] >= 0){
                    n++;
                }
                count[c2-'a']++;
            }
            if(n == 0){
                System.out.println(j+1);
                return;
            }
        }

        System.out.println(-1);
        return;

    }
}
