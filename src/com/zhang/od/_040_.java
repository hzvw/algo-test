package com.zhang.od;

import java.util.Scanner;

/**
 * ClassName: _040_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/18 1:24
 * @Version 1.0
 */
public class _040_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        int k = Integer.parseInt(sc.nextLine());

        int res = m1(s1, s2, k);

        System.out.println(res);

    }

    private static int m1(String s1, String s2, int k) {
        int res = -1;
        int n = s1.length();
        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            count[c-'a']++;
        }
        int i = 0;
        while (i < s2.length()){
            char c = s2.charAt(i);
            if(count[c-'a'] > 0){
                n--;
            }
            count[c-'a']--;

            int j = i - (s1.length() + k);
            if(j >= 0){
                char c2 = s2.charAt(j);
                if(count[c2-'a'] >= 0){
                    n++;
                }
                count[c2-'a']++;
            }
            if(n == 0){
                res = Math.max(0, j + 1);
                return res;
            }
            i++;
        }


        return res;
    }
}
