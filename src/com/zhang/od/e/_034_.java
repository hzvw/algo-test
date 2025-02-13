package com.zhang.od.e;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName: _034_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/29 18:22
 * @Version 1.0
 */
public class _034_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        UnionSet unionSet = new UnionSet(M * N);
        int[][] arr = new int[M][N];
        for(int i = 0; i<M; i++){
            for(int j = 0; j<N; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        //int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}};
        int[][] direction = {{-1,0},{0,-1}};

        for(int i = 0; i<M; i++){
            for(int j = 0; j<N; j++){
                for(int[] dir : direction){
                    int x = i+dir[0];
                    int y = j +dir[1];

                    if(x>=0 && x<=M-1 && y>=0 && y<=N-1 && Math.abs(arr[i][j]-arr[x][y]) <=1 ){
                        unionSet.union(i*N + j, x*N + y);
                    }
                }
            }
        }

        int[] count = new int[M*N];
        for(int i = 0; i<M*N; i++){
            count[unionSet.find(i)] ++;
        }
        System.out.println(Arrays.stream(count).boxed().max((a, b) -> a-b).get());;

    }

    static class UnionSet{
        int[] fa;

        public UnionSet(int n){
            fa = new int[n];
            for(int i = 0; i<n; i++){
                fa[i] = i;
            }
        }

        public int find(int x){
            if(fa[x] == x){
                return x;
            }else{
                return find(fa[x]);
            }
        }

        public void union(int x, int y){
            int x_fa = find(x);
            int y_fa = find(y);
            if(x_fa <= y_fa){
                fa[y_fa] = x_fa;
            }else{
                fa[x_fa] = y_fa;
            }
        }
    }

}
