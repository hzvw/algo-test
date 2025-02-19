package com.zhang.od;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * ClassName: _002_
 * Package: com.zhang.od
 * Description:构成正方形的数量
 *
 * @Author Harizon
 * @Create 2025/1/4 20:56
 * @Version 1.0
 */
public class _002_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] x = new int[N];
        int[] y = new int[N];

        Set<String> set = new HashSet<>();
        for(int i = 0; i<N; i++){
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
            set.add(x[i] + " " +  y[i]);
        }

        int cnt = 0;
        for(int i = 0; i<N; i++){
            for(int j = i+1; j<N; j++){
                int x1 = x[i];
                int y1 = y[i];
                int x2 = x[j];
                int y2 = y[j];


                if(set.contains((x2+y2-y1) + " " + (y2-x2+x1)) && set.contains((x1+y2-y1) + " " + (y1-x2+x1)) ) cnt ++;
                if(set.contains((x2-y2+y1) + " " + (y2+x2-x1)) && set.contains((x1-y2+y1) + " " + (y1+x2-x1)) ) cnt ++;

            }
        }
        System.out.println(cnt / 4);


    }




}
