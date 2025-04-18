package com.zhang.od;

import java.util.HashMap;
import java.util.Scanner;

/**
 * ClassName: _110_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/24 17:28
 * @Version 1.0
 */
public class _110_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int N = s.length();
        int avg = N / 4;

        HashMap<Character, Integer> count = new HashMap<>();
        for(char c : s.toCharArray()){
            count.put(c, count.getOrDefault(c,0) +1);
        }

        StringBuilder sb = new StringBuilder();
        for(char c: count.keySet()){
            if(count.get(c) > avg){
                int diff = count.get(c) - avg;
                for(int i =0; i<diff; i++){
                    sb.append(c);
                }
            }
        }

        minWindow(s, sb.toString());
        //System.out.println(minWindow(s, sb.toString()));
    }

    public static void minWindow(String s, String t) {
        int min_len = s.length();
        int[] count = new int[26];
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            count[c-'a']++;
        }
        int n = t.length();
        int i = 0;
        int j = 0;
        while (i < s.length()){
            char c = s.charAt(i);
            if(count[c-'a'] > 0){
                n--;
            }
            count[c-'a']--;

            while (n == 0){
                if(i-j+1<min_len){
                    min_len = i-j+1;
                }
                char c2 = s.charAt(j);
                if(count[c2-'a'] >= 0){
                    n++;
                }
                count[c2-'a']++;
                j++;
            }
            i++;
        }
        System.out.println(min_len == s.length() ? "-1 0": j + " " + min_len);
    }
}
