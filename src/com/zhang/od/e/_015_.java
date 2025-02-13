package com.zhang.od.e;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: _015_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/1 1:17
 * @Version 1.0
 */
public class _015_ {
    static int n;

    static int[] arr;

    static int[] brr;
    static int all = 1474560;

    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        brr = new int[n];
        visited = new boolean[n];
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
            brr[i] = (int)Math.ceil(arr[i] / 512.0) * 512;
        }
//        List<Integer> res = new ArrayList<>();
//        dfs(0, n, new LinkedList<>(), res);

//        System.out.println(res.stream().max((a,b) -> a-b).get());
        System.out.println(p());
    }

    static int p(){
        int bag = all / 512;
        int[] v = new int[n];
        int[] w = new int[n];
        int[][] dp = new int[n+1][bag+1];
        for(int i =0;i<n; i++){
            v[i] = arr[i];
            w[i] = brr[i]/512;
        }

        for(int i = 1; i<n+1; i++){
            for(int j = 1; j<bag+1; j++){
                int v1 = v[i-1];
                int w1 = w[i-1];
                if(w1 > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], v1 + dp[i-1][j-w1]);
                }
            }
        }
        return dp[n][bag];
    }


    static void dfs (int i, int n, LinkedList<Integer> buckets, List<Integer> res){
        if(i > n){
            return;
        }
        int sum = compute(buckets);
        if(sum > all){
            return;
        }

        if(sum <= all ){
            res.add(compute2(buckets));
        }

        for(int j = 0; j<n; j++){
            if(visited[j]){
                continue;
            }

            buckets.addLast(j);
            visited[j] = true;

            dfs(i+1, n, buckets, res);

            buckets.removeLast();
            visited[j] = false;
        }
    }

    static int compute(List<Integer> buckets){
        int sum = 0;

        for(int i : buckets){
            sum += brr[i];
        }
        return sum;
    }

    static int compute2(List<Integer> buckets){
        int sum = 0;

        for(int i : buckets){
            sum += arr[i];
        }
        return sum;
    }

}
