package com.zhang.od2._100;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName: _012_
 * Package: com.zhang.od2._100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/3/29 16:35
 * @Version 1.0
 */
public class _013_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        char[] cs = str.toCharArray();
        Arrays.sort(cs);
        if(str.equals(String.valueOf(cs))){
            System.out.println(str);
        }else{
            char[] n_cs = str.toCharArray();
            for (int i = 0; i < n_cs.length; i++) {
                if(cs[i] != n_cs[i]){
                    int j = str.lastIndexOf(cs[i]);
                    swap(n_cs, i, j);
                    System.out.println(String.valueOf(n_cs));
                    return;
                }
            }


        }

    }

    static void swap(char[] cs, int i, int j){
        char c = cs[i];
        cs[i] = cs[j];
        cs[j] = c;
    }
}
