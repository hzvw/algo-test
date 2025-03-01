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

        System.out.println(minWindow(s, sb.toString()));
    }

    public static int minWindow(String s, String t) {
        if(s == null || s.length() == 0 || t == null || t.length() == 0){
            return 0;
        }

        int[] count = new int[26];
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i)-'A']++;
        }
        int min_len = s.length();
        int i = 0;
        int j = 0;
        //一共欠账
        int n = t.length();
        while (j < s.length()){
            char c = s.charAt(j);
            if(count[c-'A'] > 0){
                n--;
            }
            count[c-'A']--;

            while (n == 0){
                if(j-i+1 < min_len){
                    min_len = j-i+1;
                }
                char c2 = s.charAt(i);
                if(count[c2-'A'] == 0){
                    n++;
                }
                count[c2-'A']++;
                i++;
            }

            j++;
        }
        return min_len;
    }
}
