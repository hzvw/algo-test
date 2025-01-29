package com.zhang.od.e;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * ClassName: _031_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/25 0:19
 * @Version 1.0
 */
public class _031_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        UnionSet unionSet = null;
        int N = -1;
        while(sc.hasNextLine()){
            int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if(unionSet == null){
                unionSet = new UnionSet(arr.length);
            }
            if(N == -1){
                N = arr.length;
            }

            for(int j = 0; j<arr.length; j++){
                if(arr[j] == 1){
                    unionSet.union(i, j);
                }
            }
            i++;
        }

        Set<Integer> set_id = new HashSet<>();
        for(int j = 0; j<N; j++){
            set_id.add(unionSet.find(j));
        }
        System.out.println(set_id.size());


    }

    static class UnionSet{
        int[] fa;
        public UnionSet(int N){
            fa = new int[N];
            for(int i = 0; i<N; i++){
                fa[i] = i;
            }
        }

        public int find(int x){
            if(x != fa[x]){
                fa[x] = find(fa[x]);
            }
            return fa[x];
        }

        public void union(int x, int y){
            int fa_x = find(x);
            int fa_y = find(y);
            if(fa_x != fa_y){
                fa[fa_y] = fa_x;
            }
        }
    }

}
