package com.zhang.od;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName: _013_
 * Package: com.zhang.od
 * Description:字符串变换最小字符串
 *
 * @Author Harizon
 * @Create 2025/1/14 19:10
 * @Version 1.0
 */
public class _013_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] cs = str.toCharArray();
        Arrays.sort(cs);
        String n_str = new String(cs);
        if(n_str.equals(str)){
            System.out.println(str);
            return;
        }

        char[] cs2 = str.toCharArray();
        for (int i = 0; i < cs2.length; i++) {
            if(cs2[i] != cs[i]){
                char tmp = cs2[i];
                cs2[i] = cs[i];
                int index = str.lastIndexOf(cs[i]);
                cs2[index] = tmp;
                break;
            }
        }
        System.out.println(new String(cs2));
    }


}
