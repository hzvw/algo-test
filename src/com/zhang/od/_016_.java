package com.zhang.od;

import java.util.Scanner;

/**
 * ClassName: _016_
 * Package: com.zhang.od
 * Description:计算面积
 *
 * @Author Harizon
 * @Create 2025/1/14 22:46
 * @Version 1.0
 */
public class _016_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int E = sc.nextInt();

        long last_x = 0;
        long last_y = 0;

        long s = 0;
        for(int i = 0; i<N; i++){
            long x = sc.nextInt();
            long offsetY = sc.nextInt();

            long y = last_y + offsetY;

            s += (x - last_x) * Math.abs(last_y);

            last_x = x;
            last_y = y;
        }

        if(E > last_x){
            s += (E-last_x) * Math.abs(last_y);
        }
        System.out.println(s);




    }

}
