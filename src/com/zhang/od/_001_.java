package com.zhang.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 第一题，流浪地球
 */
public class _001_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int E = sc.nextInt();

        // 初始化记录数组
        int[] p = new int[N];
        for(int i = 0; i<N; i++){
            //刚开始都设置为最大时间
            p[i] = 2001;
        }
        // 记录需要先启动的位置和时间
        for(int i = 0; i<E; i++){
            int t = sc.nextInt();
            int index = sc.nextInt();
            p[index] = t;
        }

        // 重点掌握
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                int i1 = Math.abs(i-j);
                int i2 = N-i1;
                int dis = Math.min(i1, i2);

                p[j] = Math.min(p[j], p[i] + dis);
            }
        }

        int last = 0;
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i<N; i++){
            if(p[i] < last){
                continue;
            }else if(p[i] == last){
                res.add(i);
            }else{
                res.clear();
                last = p[i];
                res.add(i);
            }
        }

        System.out.println(res.size());
        for(int i = 0; i<res.size(); i++){
            System.out.print(res.get(i) + " ");
        }
        System.out.println();




    }

}
