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

        HashMap<Character, Integer> s_map = new HashMap<>();
        for(char c : s.toCharArray()){
            s_map.put(c, s_map.getOrDefault(c,0) +1);
        }

        StringBuilder sb = new StringBuilder();
        for(char c: s_map.keySet()){
            if(s_map.get(c) > avg){
                int diff = s_map.get(c) - avg;
                for(int i =0; i<diff; i++){
                    sb.append(c);
                }
            }
        }

        System.out.println(minWindow(s, sb.toString()).length());
    }

    public static String minWindow(String s, String t) {
        if(s == null || s.length() == 0 || t == null || t.length() == 0){
            return "";
        }

        HashMap<Character, Integer> t_map = new HashMap<>();
        for(char c : t.toCharArray()){
            t_map.put(c, t_map.getOrDefault(c, 0) + 1);
        }
        //窗口内满足条件的字符
        HashMap<Character, Integer> windowMap = new HashMap<>();
        //满足条件的数量
        int cnt = 0;

        char[] cs = s.toCharArray();
        int N = cs.length;
        int i = 0;
        int j = 0;
        int min_len = Integer.MAX_VALUE;
        String res = "";
        while(j < N){
            char c = cs[j];
            if(t_map.containsKey(c) && windowMap.getOrDefault(c,0) < t_map.get(c)){
                windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
                cnt++;
            }else if(t_map.containsKey(c)){
                windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
            }
            while(cnt == t.length()){
                if(t_map.containsKey(cs[i]) && windowMap.get(cs[i]) <= t_map.get(cs[i])){
                    windowMap.put(cs[i], windowMap.get(cs[i]) -1);
                    cnt--;
                }else if(t_map.containsKey(cs[i])){
                    windowMap.put(cs[i], windowMap.get(cs[i]) -1);
                }

                int len = j-i+1;
                if(len < min_len){
                    min_len = len;
                    res = s.substring(i, j+1);;
                }
                i++;
            }
            j++;
        }
        return res;
    }
}
