package com.zhang.hot100;

import java.util.LinkedList;

/**
 * ClassName: _051_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/20 1:31
 * @Version 1.0
 */
public class _051_ {
    public static void main(String[] args) {


        _051_ v = new _051_();
        char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println(v.numIslands(grid));
    }

    int ans = 0;

    char[][] grid = null;

    boolean[][] visited = null;

    int m = 0;
    int n = 0;
    int[][] directions = new int[][]{{-1,0},{0,-1},{0,1},{1,0}};

    public int numIslands(char[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '1' && !visited[i][j]){
                    ans ++;
                    bfs(i,j);
                }
            }
        }
        return ans;
    }

    void bfs(int i, int j){
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i,j});
        visited[i][j] = true;

        while (!queue.isEmpty()){
            LinkedList<int[]> n_queue = new LinkedList<>();
            for (int[] ints : queue) {
                int x = ints[0];
                int y = ints[1];

                for (int[] direction : directions) {
                    int n_x = x + direction[0];
                    int n_y = y + direction[1];

                    if(n_x >= 0 && n_x < m && n_y >= 0  && n_y < n && !visited[n_x][n_y] && grid[n_x][n_y] == '1'){
                        n_queue.offer(new int[]{n_x, n_y});
                        visited[n_x][n_y] = true;
                    }
                }
            }
            queue = n_queue;
        }
    }
}
