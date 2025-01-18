package com.zhang.od;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName: _050_
 * Package: com.zhang.od
 * Description: 排列组合
 *
 * @Author 张汉至
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
        int[] arr ;

        public UnionSet(int n){
            this.arr = new int[n];
            for(int i = 0; i<n; i++){
                arr[i] = i;
            }
        }

        public int find(int x){
            if(arr[x] != x){
                return find(arr[x]);
            }
            return x;
        }

        public void union(int a, int b){
            int i1 = find(a);
            int i2 = find(b);

            if(i1 != i2){
                arr[i1] = i2;
            }
        }

    }



    public static void main01(String[] args) {
        char[] arr = {'a','b','c'};
        p(arr, 0, arr.length-1);


    }

    // 打印全排列
    static void p(char[] str, int p, int q){
        if(p == q){
            System.out.println(String.valueOf(str));
            return;
        }

        for(int i = p; i<=q; i++){
            swap(str, p, i);
            p(str, p+1, q);
            swap(str, p, i);
        }

    }

    static void swap(char[] chs, int i, int j){
        char t = chs[i];
        chs[i] = chs[j];
        chs[j] = t;
    }

    public static int getResult(int[] arr) {
        Arrays.sort(arr);

        ArrayList<Integer> res = new ArrayList<>();
        // dfs求10选5的去重组合，并将组合之和记录进res中，即res中记录的是所有可能性的5人小队实力值之和
        dfs(arr, 0, 0, 0, res);

        int sum = Arrays.stream(arr).reduce(Integer::sum).orElse(0);
        // 某队实力为subSum，则另一队实力为sum - subSum，则两队实力差为 abs((sum - subSum) - subSum)，先求最小实力差
        return res.stream().map(subSum -> Math.abs(sum - 2 * subSum)).min((a, b) -> a - b).orElse(0);
    }

    // 求解去重组合
    public static void dfs(int[] arr, int index, int level, int sum, ArrayList<Integer> res) {
        if (level == 5) {
            res.add(sum);
            return;
        }

        for (int i = index; i < 10; i++) {
            if (i > index && arr[i] == arr[i - 1]) {
                continue; // arr已经升序，这里进行树层去重
            }
            dfs(arr, i + 1, level + 1, sum + arr[i], res);
        }
    }



}

