package com.zhang.hot100;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * ClassName: _052_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/20 2:02
 * @Version 1.0
 */
public class _052_ {

    int m;
    int n;
    boolean[][] visited;

    int[][] grid;

    int[][] directions = new int[][]{{-1,0},{0,-1},{0,1},{1,0}};

    LinkedList<int[]> queue = new LinkedList<>();

    public int orangesRotting(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }
        int cnt = bfs();

        boolean flag = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1){
                    flag = false;
                }
            }
        }

        return flag? cnt : -1;
    }

    int bfs(){
        int cnt = 0;
        while (!queue.isEmpty()){
            boolean flag = false;
            LinkedList<int[]> n_queue = new LinkedList<>();

            for (int[] ints : queue) {
                int x = ints[0];
                int y = ints[1];

                for (int[] direction : directions) {
                    int n_x = direction[0] + x;
                    int n_y = direction[1] + y;

                    if(n_x >= 0 && n_x <m && n_y >= 0 && n_y < n && grid[n_x][n_y] == 1 && !visited[n_x][n_y]){
                        visited[n_x][n_y] = true;
                        grid[n_x][n_y] = 2;
                        n_queue.offer(new int[]{n_x, n_y});
                        flag = true;
                    }
                }
            }
            queue = n_queue;
            if(flag){
                cnt++;
            }
        }
        return cnt;
    }

}
