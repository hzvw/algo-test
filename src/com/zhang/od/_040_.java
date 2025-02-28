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

        // 这题太难

        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int k = Integer.parseInt(sc.nextLine());

        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i)-'a']++;
        }

        int n = s1.length();
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);

            if(count[c-'a'] > 0){
                n--;
            }
            count[c-'a']--;

            if(i >= s1.length() + k){

                int j = i-(k+s1.length());
                // i-j = k + s1.length;
                char to_del = s2.charAt(j);

                if(count[to_del-'a'] >= 0){
                    n++;
                }
                count[to_del-'a']++;
            }
            if(n == 0){
                System.out.println(Math.max(0, i-(k+s1.length())+1));
                return;
            }
        }
        System.out.println(-1);
        return;
    }

}
