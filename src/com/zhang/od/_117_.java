package com.zhang.od;

import java.util.Scanner;

/**
 * ClassName: _117_
 * Package: com.zhang.od
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/25 22:04
 * @Version 1.0
 */
public class _117_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine();
        String B = sc.nextLine();

        char[] ca = A.toCharArray();
        char[] cb = B.toCharArray();

        int i = 0;
        int j = 0;
        int cnt = 0;
        while(true){
            char a = ca[i];
            char b = cb[j];

            if(a == b){
                ca[i] = '#';
                i++;
                j++;
            }else{
                i++;
            }
            if(j == cb.length){
                i = 0;
                j = 0;
                cnt++;
            }

            if(i == ca.length && j<cb.length){
                break;
            }
        }

        System.out.println(cnt);

    }

}
