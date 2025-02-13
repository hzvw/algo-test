package com.zhang.od.e;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName: _078_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/29 20:44
 * @Version 1.0
 */
public class _078_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        UnionSet unionSet = new UnionSet(n);
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                if(arr[i][j] == 1){
                    unionSet.union(i, j);
                }
            }
        }
        int[] count = new int[n];
        for(int i=0; i<n; i++){
            count[unionSet.find(i)]++;
        }

        System.out.println(Arrays.stream(count).boxed().max((a, b) -> a - b).get());
    }

    static class UnionSet{
        int n;
        int[] fa;

        public UnionSet(int n){
            fa = new int[n];
            for(int i = 0; i<n; i++){
                fa[i] = i;
            }
        }

        int find(int x){
            if(x != fa[x]){
                return find(fa[x]);
            }
            return fa[x];
        }

        void union(int x, int y){
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
