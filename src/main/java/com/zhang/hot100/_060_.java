package com.zhang.hot100;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * ClassName: _060_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/20 18:08
 * @Version 1.0
 */
public class _060_ {
    public static void main(String[] args) {


    }

    char[][] board;
    String word;

    boolean[][] visited;

    int m;
    int n;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.m = board.length;
        this.n = board[0].length;


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == word.charAt(0)){
                    visited = new boolean[m][n];
                    visited[i][j] = true;
                    dfs(1, i, j);
                }
            }
        }

        return res;
    }

    boolean res = false;

    int[][] directions = new int[][]{{-1,0},{0,-1},{0,1},{1,0}};

    void dfs(int level,int i, int j){
        if(level == word.length()){
            res = true;
            return;
        }

        for (int[] direction : directions) {
            int n_x = i + direction[0];
            int n_y = j + direction[1];

            if(n_x >= 0 && n_x < m && n_y >= 0 && n_y < n && !visited[n_x][n_y] && board[n_x][n_y] == word.charAt(level)){
                visited[n_x][n_y] = true;
                dfs(level + 1, n_x, n_y);
                visited[n_x][n_y] = false;
            }
        }
    }


}
