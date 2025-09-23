package com.zhang.od;

import java.util.Scanner;

/**
 * ClassName: _056_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/19 0:37
 * @Version 1.0
 */
public class _056_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int k = sc.nextInt();
        char[] cs = str.toCharArray();
        int[] count = new int[10];
        for(int i = 0; i<cs.length; i++){
            int t = cs[i] - '0';
            count[t]++;
        }

        int[] count2 = new int[10];
        for(int i = 1; i<=k; i++){
            in(count2, i);
        }
        if(isEq(count, count2)){
            System.out.println(1);
            return;
        }

        for(int i = k+1; i<=100000; i++){
            in(count2, i);
            de(count2, i-k);
            if(isEq(count, count2)){
                System.out.println(i-k+1);
                return;
            }
        }



    }

    static boolean isEq(int[] count, int count2[]){
        for(int i = 0; i<count.length; i++){
            if(count[i] != count2[i]){
                return false;
            }
        }

        return true;
    }

    static void in(int[] count2, int i){
        while(i > 0){
            int j = i % 10;
            count2[j] ++;
            i = i / 10;
        }
    }

    static void de(int[] count2, int i){
        while(i > 0){
            int j = i % 10;
            count2[j] --;
            i = i / 10;
        }
    }


}
