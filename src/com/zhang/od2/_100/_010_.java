package com.zhang.od2._100;

import java.util.*;

/**
 * ClassName: _010_
 * Package: com.zhang.od2._100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/3/29 11:00
 * @Version 1.0
 */
public class _010_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String pre = sc.nextLine();

        String[] words = str.split("[^a-zA-Z]");
        Set<String> res = new TreeSet<>();
        for (String word : words) {
            if(word.startsWith(pre)){
                res.add(word);
            }
        }

        if(res.size() != 0){
            for (String s : res) {
                System.out.print(s + " ");
            }
        }else{
            System.out.println(pre);
        }
    }
}
