package com.zhang.od;

import java.util.*;

/**
 * ClassName: _115_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/24 23:09
 * @Version 1.0
 */
public class _115_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[] arr1 = Arrays.stream(sc.nextLine().split(","))
                .mapToInt(Integer::parseInt).toArray();
        int[][] arr = new int[N][N];
        for(int i = 0; i<N; i++){
            arr[i] = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        }

        Set<Integer> confirmed = Arrays.stream(arr1)
                .collect(HashSet::new, HashSet::add, HashSet::addAll);

        UnionSet unionSet = new UnionSet(N);
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(arr[i][j] == 1){
                    unionSet.union(i, j);
                }
            }
        }

        Set<Integer> res = new HashSet<>();
        for(int i : confirmed){
            for(int j = 0;j<N; j++){
                if(unionSet.find(i) == unionSet.find(j) && !confirmed.contains(j)){
                    res.add(j);
                }
            }
        }
        System.out.println(res.size());
    }


    static class UnionSet{
        int[] fa;

        public UnionSet(int N){
            this.fa = new int[N];
            for(int i = 0; i<N; i++){
                fa[i] = i;
            }
        }

        public int find(int i ){
            if(fa[i] != i){
                return find(fa[i]);
            }
            return fa[i];
        }

        public void union(int x, int y){
            int fa_x = find(x);
            int fa_y = find(y);
            if(fa_x != fa_y){
                //fa[y] = fa_x;
                fa[fa_y] = fa_x;
            }
        }




    }
}
