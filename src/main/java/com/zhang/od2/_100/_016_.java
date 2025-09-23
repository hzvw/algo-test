package com.zhang.od2._100;

import java.util.Scanner;

/**
 * ClassName: _016_
 * Package: com.zhang.od2._100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/3/30 17:42
 * @Version 1.0
 */
public class _016_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();

        int last_x = 0;
        int last_y = 0;
        int s = 0;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int offsetY = sc.nextInt();
            int y = last_y + offsetY;

            s += (x-last_x) * Math.abs(last_y);

            last_x = x;
            last_y = y;
        }

        if(e > last_x){
            s += (e-last_x) * Math.abs(last_y);
        }
        System.out.println(s);

    }
}
