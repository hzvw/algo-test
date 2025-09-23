package com.zhang.od;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * ClassName: _119_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/27 0:07
 * @Version 1.0
 */
public class _119_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] words = str.split(" ");
        int count = 0;
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            boolean flag = false;
            for (int j = 0; j < word.length(); j++) {
                if(!(word.charAt(j)>='a' && word.charAt(j)<='z')){
                    flag = true;
                }
            }
            if(word.length() < 4){
                continue;
            }

            char[] cs = word.toCharArray();
            if(!flag) {
                reverse(cs);
            }
            int j = 0;
            while (j < word.length() - 3){
                if(!set.contains(cs[j]) && Character.isLowerCase(cs[j])
                        && set.contains(cs[j+1])
                        && !set.contains(cs[j+2])
                        && cs[j+2] != 'r'  && Character.isLowerCase(cs[j+2])
                        && cs[j+3] == 'e'){
                        count++;
                }
                j++;
            }


        }
        System.out.println(count);
    }

    static void reverse(char[] cs){
        int i = 0;
        int j = cs.length-1;
        while (i<j){
            char t = cs[i];
            cs[i] = cs[j];
            cs[j] = t;
            i++;
            j--;
        }
    }
}
