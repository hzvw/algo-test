package com.zhang.od.e;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: _024_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/1 21:49
 * @Version 1.0
 */
public class _024_ {
    static int M;
    static int N;
    static int X;

    static List<Integer> res = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();//羊
        N = sc.nextInt();//狼
        X = sc.nextInt();//船的容量
        dfs(M, N, 0,0, 0);
        int result = res.size()>0 ? res.stream().min((a,b)->a-b).get() : 0;
        System.out.println(result);
    }

    static void dfs(int m1, int n1, int m2, int n2, int cnt){
        if(m1 == 0 && n1 == 0){
            res.add(cnt);
            return;
        }

        if(m1 + n1 <= X){
            res.add(cnt+1);
            return;
        }

        for(int i = 0; i<=Math.min(m1, X); i++){
            for(int j = 0; j<=Math.min(n1, X); j++){
                //空载
                if(i == 0 && j == 0){
                    continue;
                }
                //超载
                if(i + j > X){
                    continue;
                }

                //岸上的羊小于岸上的狼
                if(m1-i<=n1-j && m1-i != 0){
                    continue;
                }

                //运完之后，对岸的羊小于对岸的狼
                if(m2+i <= n2+j && m2+i != 0){
                    continue;
                }
                if(m2+i == 0 && n2+j >= X){
                    continue;
                }

                dfs(m1-i,n1-j,m2 + i, n2+j, cnt+1);
            }
        }

    }

}
