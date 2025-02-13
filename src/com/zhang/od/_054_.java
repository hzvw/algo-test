package com.zhang.od;

import java.util.Scanner;

/**
 * ClassName: _054_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/18 23:31
 * @Version 1.0
 */
public class _054_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long i1 = sc.nextLong();
        int i2 = sc.nextInt();
        System.out.println(p(i1, i2));
        //System.out.println((long) Math.max(1, Math.ceil(Math.log10(i1 / Math.pow(26, i2)))));
    }

    static long p(long x, int y){
//        long t1 = (long) Math.pow(26, y);
//        long t2 = x / t1;
//        long t3 = (long)Math.log10(t2);
//        long t4 = (long) Math.ceil(t3);

        return (long) Math.max(1, Math.ceil(Math.log10(x / Math.pow(26, y))));
    }

}



