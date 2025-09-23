package com.zhang.od.e;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName: _050_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/12 13:02
 * @Version 1.0
 */
public class _050_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        P[] ps = new P[m];
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            int p = sc.nextInt();

            ps[i] = new P(x,y,p == 0 ? z : 0);
        }

        Arrays.sort(ps, (a,b)-> a.weight-b.weight);
        UnionSet unionSet = new UnionSet(n+1);
        int sum = 0;
        for (int i = 0; i < m; i++) {
            int start = ps[i].start;
            int end = ps[i].end;

            if(unionSet.find(start) != unionSet.find(end)){
                unionSet.union(start, end);
                sum += ps[i].weight;
            }
        }
        boolean flag = unionSet.count == 2;

        if(!flag){
            System.out.println(-1);
        }else{
            System.out.println(sum);
        }


    }

    static class P{
        int start;
        int end;
        int weight;

        public P(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    static class UnionSet{
        int[] fa;
        int count;

        public UnionSet(int n) {
            this.count = n;
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
        }

        public int find(int x){
            if(x != fa[x]){
                return find(fa[x]);
            }
            return fa[x];
        }

        public void union(int x, int y){
            int fa_x = find(x);
            int fa_y = find(y);

            if(fa_x != fa_y){
                fa[fa_y] = fa_x;
                count--;
            }
        }
    }

}
