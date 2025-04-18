package com.zhang.od;

import java.util.Scanner;

/**
 * ClassName: _050_
 * Package: com.zhang.od
 * Description: 排列组合
 *
 * @Author Harizon
 * @Create 2025/1/6 21:34
 * @Version 1.0
 */
public class _050_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        if(n < 1 || n>=100000 || m<1 || m>=100000){
            System.out.println("NULL");
            return;
        }

        int[][] arr = new int[m][3];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<3; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        UnionSet unionSet = new UnionSet(n+1);
        for(int i = 0; i<m; i++){
            int a = arr[i][0];
            int b = arr[i][1];
            int c = arr[i][2];
            if(a <1 || a>n || b<1 || b>n){
                System.out.println("da pian zi");
                continue;
            }


            if(c == 0){
                unionSet.union(a,b);
            }else if(c == 1){
                boolean flag = unionSet.find(a) == unionSet.find(b);
                if(flag){
                    System.out.println("we are a team");
                }else{
                    System.out.println("we are not a team");
                }
            }else{
                System.out.println("da pian zi");
            }
        }


    }

    static class UnionSet{
        int[] fa;

        public UnionSet(int n) {
            this.fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
        }

        int find(int x){
            if(fa[x] != x){
                return find(fa[x]);
            }
            return fa[x];
        }

        void union(int x, int y){
            int fa_x = find(x);
            int fa_y = find(y);

            if(fa_x != fa_y){
                fa[fa_y] = fa_x;
            }
        }
    }
    



}

