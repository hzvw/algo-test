package com.zhang.od.e;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * ClassName: _039_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/2/2 18:07
 * @Version 1.0
 */
public class _039_ {
    static int N ;//明文长度
    static int[] data;//明文
    static int M;//密文宽度
    static int[][] arr;//密文矩阵

    static boolean[][] visited;

    static List<List<Integer>> res =null;

    static int[][] directions = new int[][]{{-1,0},{0,-1},{0,1},{1,0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        data = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = sc.nextInt();
        }
        M = sc.nextInt();
        arr = new int[M][M];
        visited = new boolean[M][M];
        res = new ArrayList<>();
        LinkedList<Integer> buckets = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                if(arr[i][j] == data[0]){
                    buckets.addLast(i);
                    buckets.addLast(j);
                    visited[i][j] = true;
                    dfs(i,j, 1,N, buckets, res);
                    buckets.removeLast();
                    buckets.removeLast();
                    visited[i][j] = false;
                }
            }
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < res.size(); i++) {
            List<String> collect = res.get(i).stream().map(x -> x + "").collect(Collectors.toList());
            String str = String.join(" ", collect);
            list.add(str);
        }

        System.out.println(list.size() == 0 ? "error" : list.get(0));
    }



    static void dfs(int i, int j,int level, int N, LinkedList<Integer> buckets, List<List<Integer>> res){
        if(level == N){
            res.add(new ArrayList<>(buckets));
            return ;
        }
        for(int[] dir : directions){
            int x = i + dir[0];
            int y = j + dir[1];

            if(x>=0 && x<M && y>=0 && y<M && !visited[x][y] && arr[x][y] == data[level]){
                visited[x][y] = true;
                buckets.addLast(x);
                buckets.addLast(y);

                dfs(x,y,level+1,N,buckets, res);

                visited[x][y] = false;
                buckets.removeLast();
                buckets.removeLast();
            }

        }
    }



}
