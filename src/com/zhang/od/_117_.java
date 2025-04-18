package com.zhang.od;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ClassName: _117_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/25 22:04
 * @Version 1.0
 */
public class _117_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();

        int cnt = 0;

        int i = 0;
        int j = 0;
        while (true){
            if(cs1[i] == cs2[j]){
                cs1[i] = '#';
                i++;
                j++;
            }else{
                i++;
            }
            if(j == cs2.length){
                cnt++;
                i = 0;
                j = 0;
            }
            if(i == s1.length()){
                break;
            }
        }

        System.out.println(cnt);
    }
}