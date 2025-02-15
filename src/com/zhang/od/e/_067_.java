package com.zhang.od.e;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * ClassName: _067_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/15 21:53
 * @Version 1.0
 */
public class _067_ {

    static int m;//m行
    static int n;

    static int[][] arr;

    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        arr = new int[m][n];
        visited = new boolean[m][n];
        int cnt1 = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
                if(arr[i][j] == 1){
                    cnt1++;
                }
            }
        }
        arr[0][0] = 1;
        int change = bfs();
        System.out.println(m * n - (1+cnt1 + change));

    }

    static int[][] directions = new int[][]{{-1,0},{0,-1},{0,1},{1,0}};

    static int bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        visited[0][0] = true;
        int change = 0;
        while (!queue.isEmpty()){
            int[] ints = queue.poll();
            int x = ints[0];
            int y = ints[1];

            for (int[] direction : directions) {
                int n_x = x + direction[0];
                int n_y = y + direction[1];

                if(n_x >=0 && n_x < m && n_y >= 0 && n_y < n && !visited[n_x][n_y] && arr[n_x][n_y] != 2 ){
                    if(arr[n_x][n_y] == 0){
                        arr[n_x][n_y] = 1;
                        visited[n_x][n_y] = true;
                        change++;
                    }
                    queue.offer(new int[]{n_x, n_y});
                }
            }
        }
        return change;
    }

}
