package com.zhang.od;

import java.util.Scanner;

/**
 * ClassName: _042_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/6 16:20
 * @Version 1.0
 */
public class _042_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int n = sc.nextInt();

        int[] w = new int[n];
        int[] v = new int[n];
        for(int i = 0; i<n; i++){
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        System.out.println(p(w,v,0,0,0,T));
        //System.out.println(process(w,v,0,T));
    }

    static int p(int[] w, int[] v, int i,int current_v, int current_w, int bag){
        if(i == w.length){
            return current_v;
        }

        if(w[i] + current_w> bag){
            return current_v;
        }

        // 加入
        int v1 = p(w,v,i+1,current_v + v[i], current_w + w[i], bag);
        // 不加入
        int v2 = p(w,v,i+1,current_v, current_w, bag);

        return Math.max(v1,v2);
    }

    /*普通暴力递归*/
    // index 现在到达哪个位置
    // bag 背包容量
    public static int process(int[] w, int[] v, int index, int bag) {
        if (bag < 0) { // 加入货物后超出背包容量，返回-1，表示这个货物不能加入
            return -1;
        }
        if (index == w.length) {  // 已经超出货物数量，递归结束，返回0
            return 0;
        }

        // 背包容量不超，index合法
        // 当前index货物 不放入背包
        int p1 = process(w, v, index + 1, bag);

        int p2 = 0;
        // 判断当前货物能否加入背包
        int nextFlag = process(w, v, index + 1, bag - w[index]);
        if (nextFlag != -1) {
            // 当前index货物 加入背包
            p2 = v[index] + nextFlag;
        }
        return Math.max(p1, p2);
    }

}
