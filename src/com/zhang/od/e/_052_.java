package com.zhang.od.e;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * ClassName: _052_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/2/12 23:41
 * @Version 1.0
 */
public class _052_ {
    static int n;
    static int m;
    static int k;
    static char[][] arr;
    static boolean[][] visited;

    static int[][] directions = new int[][]{{0,-1},{-1,0},{0,1},{1,0}};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();//行数
        m = sc.nextInt();//列数

        k = sc.nextInt();

        arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next().toCharArray();
        }
        visited = new boolean[n][m];

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] != '#' && !visited[i][j]){
                    ans += bfs(i, j) < k ? 1 : 0;
                }
            }
        }

        System.out.println(ans);


    }

    static int bfs(int i , int j){
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i,j});
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] ints = queue.poll();
            int x = ints[0];
            int y = ints[1];
            if(arr[x][y] == 'E'){
                count++;
            }
            for (int[] direction : directions) {
                int n_x = x + direction[0];
                int n_y = y + direction[1];
                if(n_x >=0 && n_x <n && n_y >=0 && n_y < m && !visited[n_x][n_y] && arr[n_x][n_y] != '#'){
                    queue.offer(new int[]{n_x, n_y});
                    visited[n_x][n_y] = true;
                }
            }
        }
        return count;
    }
}
