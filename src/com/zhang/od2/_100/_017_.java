package com.zhang.od2._100;

import java.util.Scanner;

/**
 * ClassName: _017_
 * Package: com.zhang.od2._100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/3/30 17:54
 * @Version 1.0
 */
public class _017_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < c; i++) {
            int t = sc.nextInt();
            int m = sc.nextInt();

            if(m < 128){
                res = Math.min(res, t + m);
            }else{
                res = Math.min(res, t + m1(m));
            }
        }

        System.out.println(res);
    }

    static int m1(int m){
        String s = Integer.toBinaryString(m);
        String exp = s.substring(1,4);
        String mant = s.substring(4,8);

        int int_exp = Integer.parseInt(exp, 2);
        int int_mant = Integer.parseInt(mant, 2);
        return (int_mant | 0x10) << (int_exp + 3);
    }
}
