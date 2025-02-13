package com.zhang.od;

import java.util.*;

/**
 * ClassName: _112_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/24 21:23
 * @Version 1.0
 */
public class _112_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(" ");
        Set<String> set = new HashSet<>(Arrays.asList(words));
        Arrays.sort(words, (a,b) -> b.length() - a.length());
        String res = "";
        for(String str : words){
            boolean ret = true;
            int j = str.length();
            while(j > 1){
                String sub = str.substring(0, j-1);
                if(!set.contains(sub)){
                    ret = false;
                }
                j--;
            }
            if(ret && str.length() >= res.length() && str.compareTo(res) > 0){
                res = str;
            }
        }
        System.out.println(res);

    }

}
