package com.zhang.od2._100;

import java.util.Scanner;

/**
 * ClassName: _003_
 * Package: com.zhang.od2._100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/3/29 1:46
 * @Version 1.0
 */
public class _003_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;

        String str = n + "";

        for (int i = str.length()-1; i >= 0 ; i--) {
            char c = str.charAt(i);
            if(c < '4'){
                res += (c-'0') * my_power(str.length()-1 - i);
            }else{
                res += (c-'0'-1) * my_power(str.length()-1 - i);
            }

        }

        System.out.println(res);
    }

    static int my_power(int x){
        int res = 1;
        for (int i = 0; i < x; i++) {
            res *= 9;
        }
        return res;
    }
}
