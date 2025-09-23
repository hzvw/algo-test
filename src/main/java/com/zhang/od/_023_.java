package com.zhang.od;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * ClassName: _023_
 * Package: com.zhang.od
 * Description:最长子字符串的长度以一
 *
 * @Author Harizon
 * @Create 2025/1/16 19:19
 * @Version 1.0
 */
public class _023_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == 'o'){
                set.add(i);
            }
        }

        if(set.size() % 2 == 0){
            System.out.println(s.length());
        }else{
            System.out.println(s.length() - 1 );
        }



    }

}
