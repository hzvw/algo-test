package com.zhang.od;

import java.util.Scanner;

/**
 * ClassName: _013_
 * Package: com.zhang.od
 * Description:
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
        for(int i = 0; i<cs.length; i++){
            int index = cs.length-1;
            for(int j = cs.length-1;j>=i;j--){
                if(cs[j] < cs[index]){
                    index = j;
                }
            }
            if(cs[index] < cs[i]){
                swap(cs, index, i);
                break;
            }else{
                continue;
            }

        }

        System.out.println(String.valueOf(cs));


    }

    static void swap(char[] cs, int i, int j){
        char tmp = cs[i];
        cs[i] = cs[j];
        cs[j] = tmp;
    }

}
