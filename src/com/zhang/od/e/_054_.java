package com.zhang.od.e;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: _054_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/2/13 0:41
 * @Version 1.0
 */
public class _054_ {
    static int r;
    static int c;

    static int[][] arr;

    static boolean[][] visited;

    static int[][] directions = new int[][]{{-1,0},{0,-1},{0,1},{1,0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();//行数
        c = sc.nextInt();//列数

        arr = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        visited = new boolean[r][c];

        List<List<int[]>> res = new LinkedList<>();
        visited[0][0] = true;
        dfs(0,0, new LinkedList<>(), res);
        int ans = Integer.MIN_VALUE;
        for (List<int[]> list : res) {
            int min = Integer.MAX_VALUE;
            for (int[] ints : list) {
                min = Math.min(min, arr[ints[0]][ints[1]]);
            }
            ans = Math.max(ans, min);
        }
        System.out.println(ans);

        // 深度优先搜索

    }

    static void dfs(int i, int j, LinkedList<int[]> buckets, List<List<int[]>> res){
        if(i == r-1 && j == c-1){
            res.add(new LinkedList<>(buckets));
            return;
        }

        for (int[] direction : directions) {
            int n_x = i + direction[0];
            int n_y = j + direction[1];

            if(n_x >= 0 && n_x < r && n_y >=0 && n_y < c && !visited[n_x][n_y]){

                buckets.addLast(new int[]{n_x, n_y});
                visited[n_x][n_y] = true;
                dfs(n_x, n_y, buckets, res);
                buckets.removeLast();
                visited[n_x][n_y] = false;
            }
        }
    }

    static void bfs(){

    }


}
