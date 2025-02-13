package com.zhang.od.e;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 * ClassName: _053_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/13 0:16
 * @Version 1.0
 */
public class _053_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        //车辆数和到终点的距离

        double[] arr = new double[m];
        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextDouble();
        }

        double front_arrive_time = 0.0;

        for (int i = 0; i < m; i++) {
            double speed = arr[i];

            double arrive_time = i + n / speed;

            if(arrive_time < front_arrive_time){
                arrive_time = front_arrive_time;
            }

            front_arrive_time = arrive_time;
        }

        double ans = front_arrive_time - (m-1);

        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumIntegerDigits(0);
        nf.setMaximumIntegerDigits(3);
        System.out.println(nf.format(ans));

    }
}
