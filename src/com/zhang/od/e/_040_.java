package com.zhang.od.e;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: _040_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/30 21:22
 * @Version 1.0
 */
public class _040_ {/* //匈牙利算法
    static boolean[][] arr ;
    static int m = 0;
    static int n = 0;

    static boolean[] visited= null;

    static int[] match;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();//女
        n = sc.nextInt();//男
        int k = sc.nextInt();

        arr = new boolean[m][n];

        for(int i = 0; i<k; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[x][y] = true;
        }

        visited = new boolean[n];
        match = new int[n];
        Arrays.fill(match, -1);

        int result = 0;
        for(int i = 0; i<m; i++){
            Arrays.fill(visited, false);

            if(dfs(i)){
                result++;
            }
        }

        System.out.println(result);


    }


    // 给第i个女生找对象，找对象算法
    static boolean dfs(int i){
        // 从m个男生里面找
        for(int j = 0; j<n; j++){
            //两个人互相还有好感
            if(arr[i][j] && !visited[j]){
                visited[j] = true;

                //如果这个男生还没对象，或者说有对象，但是其现在的对象能找到他之外的人配对
                if(match[j] == -1 || dfs(match[j])){
                    match[j] = i;
                    return true;//找到了一个，拜拜
                }
            }
        }

        return false;
    }*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        int[][] arr = new int[N][M];
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        int[] nums = new int[M];
        for(int i = 0; i<M; i++){
            nums[i] = i;
        }
        List<List<Integer>> res = new ArrayList<>();
        p(nums, N, 0, new LinkedList<>(), res, new boolean[M]);


        List<List<Integer>> res2 = new ArrayList<>();

        for(int i =0; i<N; i++){
            List<Integer> list = new ArrayList<>();
            for(int j : res.get(i)){
                list.add(arr[i][j]);
            }
            res2.add(list);
        }

        res.forEach(x -> {x.forEach( a -> System.out.print(a + " "));
            System.out.println();});

//        System.out.println(res.stream().map(x -> x.get(K-1)).min((a,b) -> a-b).get());;

//        res2.stream().forEach(x -> x.sort((a,b)->a-b));
//        System.out.println(res2.stream().map(x -> x.get(K-1)).min((a,b) -> a-b).get());;


    }

    static void p(int[] nums, int n, int level, LinkedList<Integer> buckets, List<List<Integer>> res, boolean[] visited){
        if(buckets.size() == n){
            res.add(new ArrayList<>(buckets));
            return;
        }

        for(int i = 0; i<nums.length; i++){
            if(visited[i]){
                continue;
            }

            buckets.addLast(nums[i]);
            visited[i] = true;

            p(nums, n, level + 1, buckets, res, visited);
            buckets.removeLast();
            visited[i] = false;
        }

    }




}
